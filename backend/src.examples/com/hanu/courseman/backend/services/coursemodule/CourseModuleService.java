package com.hanu.courseman.backend.services.coursemodule;

import domainapp.modules.webappgen.backend.base.services.InheritedDomServiceAdapter;
import com.hanu.courseman.modules.coursemodule.model.CourseModule;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import domainapp.modules.webappgen.backend.base.models.Identifier;
import domainapp.modules.webappgen.backend.base.models.PagingModel;
import domainapp.modules.webappgen.backend.base.models.Page;
import java.util.Collection;
import java.util.function.BiConsumer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import domainapp.modules.webappgen.backend.utils.InheritanceUtils;

@Generated(value = "domainapp.modules.webappgen.backend.generators.SourceCodeServiceTypeGenerator")
@Service(value = "com.hanu.courseman.backend.services.coursemodule.CourseModuleService")
public class CourseModuleService extends InheritedDomServiceAdapter<com.hanu.courseman.modules.coursemodule.model.CourseModule> {

    public void deleteEntityById(Identifier arg0) {
        super.deleteEntityById(arg0);
    }

    public CourseModule updateEntity(Identifier arg0, CourseModule arg1) {
        return super.updateEntity(arg0, arg1);
    }

    public Page getEntityListByPage(PagingModel arg0) {
        return super.getEntityListByPage(arg0);
    }

    public CourseModule createEntity(CourseModule arg0) {
        return super.createEntity(arg0);
    }

    public CourseModule getEntityById(Identifier arg0) {
        return super.getEntityById(arg0);
    }

    public void setOnCascadeUpdate(BiConsumer arg0) {
        super.setOnCascadeUpdate(arg0);
    }

    public Collection getAllEntities() {
        return super.getAllEntities();
    }

    @Autowired()
    public CourseModuleService(domainapp.softwareimpl.SoftwareImpl arg0, @Qualifier(value = "com.hanu.courseman.modules.coursemodule.model.CourseModule") java.util.Map arg1) {
        super(arg0, arg1);
        this.setType(CourseModule.class);
        this.setSubtypes(InheritanceUtils.getSubtypeMapFor(this.type));
    }
}
