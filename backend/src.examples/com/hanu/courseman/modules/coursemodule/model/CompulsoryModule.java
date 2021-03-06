package com.hanu.courseman.modules.coursemodule.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import domainapp.basics.exceptions.ConstraintViolationException;
import domainapp.basics.model.meta.AttrRef;
import domainapp.basics.model.meta.DClass;
import domainapp.basics.model.meta.DOpt;

/**
 * Represents a compulsory module (a subclass of Module)
 *
 * @author dmle
 *
 */
@DClass(schema="courseman")
public class CompulsoryModule extends CourseModule {

  // constructor method
  // the order of the arguments must be this:
  // - super-class arguments first, then sub-class
  @DOpt(type=DOpt.Type.ObjectFormConstructor)
  @JsonCreator
  public CompulsoryModule(@AttrRef("name") String name,
      @AttrRef("semester") Integer semester, @AttrRef("credits") Integer credits) {
    this(null, null, name, semester, credits);
  }

  @DOpt(type=DOpt.Type.DataSourceConstructor)
  public CompulsoryModule(Integer id, String code, String name, Integer semester, Integer credits)
    throws ConstraintViolationException {
    super(id, code, name, semester, credits);
  }

  private CompulsoryModule() { }
}
