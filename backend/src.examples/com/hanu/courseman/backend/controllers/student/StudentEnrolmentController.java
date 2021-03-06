package com.hanu.courseman.backend.controllers.student;

import domainapp.modules.webappgen.backend.base.controllers.DefaultNestedRestfulController;
import com.hanu.courseman.modules.student.model.Student;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import domainapp.modules.webappgen.backend.base.models.Identifier;
import domainapp.modules.webappgen.backend.base.models.PagingModel;
import com.hanu.courseman.modules.enrolment.model.Enrolment;
import domainapp.modules.webappgen.backend.base.models.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping(value = "/students/{id}/enrolments")
@Generated(value = "domainapp.modules.webappgen.backend.generators.SourceCodeWebControllerGenerator")
public class StudentEnrolmentController extends DefaultNestedRestfulController<com.hanu.courseman.modules.student.model.Student, com.hanu.courseman.modules.enrolment.model.Enrolment> {

    @org.springframework.web.bind.annotation.PostMapping()
    public Enrolment createInner(Identifier arg0, @org.springframework.web.bind.annotation.RequestBody() Enrolment arg1) {
        return super.createInner(arg0, arg1);
    }

    @org.springframework.web.bind.annotation.GetMapping()
    public Page getInnerListByOuterId(Identifier arg0, PagingModel arg1) {
        return super.getInnerListByOuterId(arg0, arg1);
    }

    @Autowired()
    public StudentEnrolmentController(domainapp.modules.webappgen.backend.base.websockets.WebSocketHandler arg0) {
        super(arg0);
    }
}
