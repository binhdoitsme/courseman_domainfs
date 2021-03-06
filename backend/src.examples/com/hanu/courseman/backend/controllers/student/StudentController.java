package com.hanu.courseman.backend.controllers.student;

import domainapp.modules.webappgen.backend.base.controllers.DefaultRestfulController;
import com.hanu.courseman.modules.student.model.Student;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import domainapp.modules.webappgen.backend.base.models.Identifier;
import domainapp.modules.webappgen.backend.base.models.PagingModel;
import domainapp.modules.webappgen.backend.base.models.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping(value = "/students")
@Generated(value = "domainapp.modules.webappgen.backend.generators.SourceCodeWebControllerGenerator")
public class StudentController extends DefaultRestfulController<com.hanu.courseman.modules.student.model.Student> {

    @org.springframework.web.bind.annotation.DeleteMapping(value = "/{id}")
    public void deleteEntityById(Identifier arg0) {
        super.deleteEntityById(arg0);
    }

    @org.springframework.web.bind.annotation.PatchMapping(value = "/{id}")
    public Student updateEntity(Identifier arg0, @org.springframework.web.bind.annotation.RequestBody() Student arg1) {
        return super.updateEntity(arg0, arg1);
    }

    @org.springframework.web.bind.annotation.GetMapping()
    public Page getEntityListByPage(PagingModel arg0) {
        return super.getEntityListByPage(arg0);
    }

    @org.springframework.web.bind.annotation.PostMapping()
    public Student createEntity(@org.springframework.web.bind.annotation.RequestBody() Student arg0) {
        return super.createEntity(arg0);
    }

    @org.springframework.web.bind.annotation.GetMapping(value = "/{id}")
    public Student getEntityById(Identifier arg0) {
        return super.getEntityById(arg0);
    }

    @Autowired()
    public StudentController(domainapp.modules.webappgen.backend.base.websockets.WebSocketHandler arg0) {
        super(arg0);
    }
}
