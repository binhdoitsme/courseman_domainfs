package com.hanu.courseman.backend.services.studentclass;

import domainapp.modules.webappgen.backend.base.services.SimpleDomServiceAdapter;
import com.hanu.courseman.modules.studentclass.model.StudentClass;
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
@Service(value = "com.hanu.courseman.backend.services.studentclass.StudentClassService")
public class StudentClassService extends SimpleDomServiceAdapter<com.hanu.courseman.modules.studentclass.model.StudentClass> {

    public void deleteEntityById(Identifier arg0) {
        super.deleteEntityById(arg0);
    }

    public StudentClass updateEntity(Identifier arg0, StudentClass arg1) {
        return super.updateEntity(arg0, arg1);
    }

    public Page getEntityListByPage(PagingModel arg0) {
        return super.getEntityListByPage(arg0);
    }

    public StudentClass createEntity(StudentClass arg0) {
        return super.createEntity(arg0);
    }

    public StudentClass getEntityById(Identifier arg0) {
        return super.getEntityById(arg0);
    }

    public void setOnCascadeUpdate(BiConsumer arg0) {
        super.setOnCascadeUpdate(arg0);
    }

    public Collection getAllEntities() {
        return super.getAllEntities();
    }

    @Autowired()
    public StudentClassService(domainapp.softwareimpl.SoftwareImpl arg0) {
        super(arg0);
        this.setType(StudentClass.class);
    }
}
