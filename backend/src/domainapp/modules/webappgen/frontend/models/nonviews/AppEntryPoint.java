package domainapp.modules.webappgen.frontend.models.nonviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domainapp.basics.model.config.Configuration;
import domainapp.basics.model.meta.module.ModuleDescriptor;
import domainapp.basics.model.meta.module.model.ModelDesc;
import domainapp.basics.util.ApplicationToolKit;
import domainapp.modules.mccl.model.MCC;
import domainapp.modules.webappgen.frontend.models.JsFrontendElement;
import domainapp.modules.webappgen.frontend.templates.JsTemplate;
import domainapp.modules.webappgen.frontend.templates.JsTemplates;
import org.modeshape.common.text.Inflector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppEntryPoint implements JsFrontendElement {
    private final Collection<FrontendModule> frontendModules = new ArrayList<>();
    private final String appName;
    private final String welcomeText;
    private final Collection<FrontendModuleDescriptor> frontendModuleDescriptors;

    public AppEntryPoint(Class sysConfigClass, MCC mainMCC, Map<Class, MCC> moduleDescriptorMap) {
        Configuration initConfig = ApplicationToolKit.parseInitApplicationConfiguration(sysConfigClass);
        this.appName = initConfig.getAppName();
        this.welcomeText = "Welcome to " + mainMCC.getPropertyVal("viewDesc", "formTitle").asLiteralStringValueExpr().getValue();
        this.frontendModuleDescriptors = getFrontendModuleDescriptors(
                ApplicationToolKit.parseApplicationModules(sysConfigClass), mainMCC);
        for (Map.Entry<Class, MCC> entry : moduleDescriptorMap.entrySet()) {
            frontendModules.add(new FrontendModule(entry.getKey(), entry.getValue()));
        }
    }

    private Collection<String> getImports() {
        return frontendModules.stream()
                .map(module -> String.format("import %s from './%s'",
                        module.getModuleAlias(), module.getFolder()))
                .collect(Collectors.toList());
    }

    public Collection<FrontendModule> getFrontendModules() {
        return frontendModules;
    }

    public String getFileName() {
        return "App";
    }

    @Override
    public JsTemplate getTemplate() {
        return JsTemplates.APP;
    }

    @Override
    public String getAsString() {
        try {
            return getTemplate().getAsString()
                    .replace("{{ view.main.imports }}", getImports().stream().reduce("", (s1, s2) -> s1 + "\n" + s2))
                    .replace("{{ view.main.welcome }}", welcomeText)
                    .replace("{{ view.main.appName }}", appName)
                    .replace("{{ view.main.modules }}",
                            new ObjectMapper().writeValueAsString(this.frontendModuleDescriptors))
                    .replace("{{ view.main.routers }}", String.join("\n", generateRouters()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static Collection<FrontendModuleDescriptor> getFrontendModuleDescriptors(
            Class[] modules, MCC mainMCC) {
        return Stream.of(modules)
                .filter(module -> {
                    try {
                        return !module.equals(Class.forName(mainMCC.getFqn()));
                    } catch (ClassNotFoundException e) {
                        return true;
                    }
                })
                .map(module -> (ModuleDescriptor)module.getAnnotation(ModuleDescriptor.class))
                .map(ModuleDescriptor::modelDesc)
                .map(ModelDesc::model)
                .map(module -> module.getSimpleName())
                .map(FrontendModuleDescriptor::new)
                .collect(Collectors.toList());
    }

    private Collection<String> generateRouters() {
        return frontendModuleDescriptors.stream()
                .map(moduleDesc ->
                        String.format("<Route path='%s'>" +
                                        "<Module%s title='%s' />" +
                                        "</Route>",
                                moduleDesc.endpoint,
                                moduleDesc.simpleDClassName,
                                moduleDesc.name))
                .collect(Collectors.toList());
    }

    private static class FrontendModuleDescriptor {
        private static final Inflector inflector = Inflector.getInstance();
        private final String endpoint;
        private final String name;
        @JsonIgnore
        private final String simpleDClassName;

        public FrontendModuleDescriptor(String simpleDClassName) {
            this.simpleDClassName = simpleDClassName;
            this.endpoint = toHrefString(simpleDClassName);
            this.name = "Manage " + toPluralHumanString(simpleDClassName);
        }

        // href string: /a-simple-string
        private static String toHrefString(String original) {
            return "/" + inflector.pluralize(
                    inflector.humanize(
                            inflector.underscore(original)))
                    .replace(" ", "-").toLowerCase(Locale.ROOT);
        }

        private static String toPluralHumanString(String original) {
            return inflector.capitalize(inflector.pluralize(inflector.humanize(inflector.underscore(original))));
        }

        public String getName() {
            return name;
        }

        public String getEndpoint() {
            return endpoint;
        }

        @Override
        public String toString() {
            return "FrontendModuleDescriptor{" +
                    "href='" + endpoint + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
