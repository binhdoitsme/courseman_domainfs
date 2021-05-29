package com.hanu.courseman.backend.services.enrolment;

import domainapp.modules.webappgen.backend.base.services.SimpleDomServiceAdapter;
import com.hanu.courseman.modules.enrolment.model.Enrolment;
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
@Service(value = "com.hanu.courseman.backend.services.enrolment.EnrolmentService")
public class EnrolmentService extends SimpleDomServiceAdapter<com.hanu.courseman.modules.enrolment.model.Enrolment> {

    public void deleteEntityById(Identifier arg0) {
        super.deleteEntityById(arg0);
    }

    public Enrolment updateEntity(Identifier arg0, Enrolment arg1) {
        return super.updateEntity(arg0, arg1);
    }

    public Page getEntityListByPage(PagingModel arg0) {
        return super.getEntityListByPage(arg0);
    }

    public Enrolment createEntity(Enrolment arg0) {
        return super.createEntity(arg0);
    }

    public Enrolment getEntityById(Identifier arg0) {
        return super.getEntityById(arg0);
    }

    public void setOnCascadeUpdate(BiConsumer arg0) {
        super.setOnCascadeUpdate(arg0);
    }

    public Collection getAllEntities() {
        return super.getAllEntities();
    }

    @Autowired()
    public EnrolmentService(domainapp.softwareimpl.SoftwareImpl arg0) {
        super(arg0);
        this.setType(Enrolment.class);
    }
}
