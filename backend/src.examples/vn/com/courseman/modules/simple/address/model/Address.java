package vn.com.courseman.modules.simple.address.model;

import domainapp.basics.model.meta.DAssoc;
import domainapp.basics.model.meta.DAssoc.AssocEndType;
import domainapp.basics.model.meta.DAssoc.AssocType;
import domainapp.basics.model.meta.DAssoc.Associate;
import domainapp.basics.model.meta.DAttr;
import domainapp.basics.model.meta.DAttr.Type;
import domainapp.basics.model.meta.DClass;
import java.util.*;
import domainapp.basics.model.meta.DOpt;
import domainapp.basics.model.meta.AttrRef;
import domainapp.basics.exceptions.ConstraintViolationException;
import domainapp.basics.util.Tuple;
import vn.com.courseman.modules.simple.student.model.Student;

/**
 * @overview 
 * A domain class representing simple addresses that contain just the city names. This class is used as 
 * the <code>allowedValues</code> of the domain attributes of 
 * other domain classes (e.g. Student.address).  
 * 
 * <p>Method <code>toString</code> overrides <code>Object.toString</code> to 
 * return the string representation of a city name which is expected by 
 * the application. 
 * 
 * @author dmle
 * @version 1.0
 */
@DClass(schema = "courseman")
public class Address {
    public Address() {}

    /*** STATE SPACE **/
    @DAttr(name = "id", id = true, auto = true, length = 3, mutable = false, optional = false, type = Type.Integer)
    private int id;

    @DAttr(name = "cityName", type = Type.String, length = 20, optional = false)
    private String cityName;

    @DAttr(name = "student", type = Type.Domain, optional = true, serialisable = false)
    @DAssoc(ascName = "student-has-address", role = "address", ascType = AssocType.One2One, endType = AssocEndType.One, associate = @Associate(type = Student.class, cardMin = 1, cardMax = 1, determinant = true))
    private Student student;

    /*** BEHAVIOUR SPACE **/
    private static int idCounter;

    @DOpt(type = DOpt.Type.Getter)
    @AttrRef(value = "id")
    public int getId() {
        return this.id;
    }

    @DOpt(type = DOpt.Type.AutoAttributeValueGen)
    @AttrRef(value = "id")
    private static int genId(Integer id) {
        Integer val;
        if (id == null) {
            idCounter++;
            val = idCounter;
        } else {
            if (id > idCounter) {
                idCounter = id;
            }
            val = id;
        }
        return val;
    }

    @DOpt(type = DOpt.Type.Getter)
    @AttrRef(value = "cityName")
    public String getCityName() {
        return this.cityName;
    }

    @DOpt(type = DOpt.Type.Setter)
    @AttrRef(value = "cityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @DOpt(type = DOpt.Type.Getter)
    @AttrRef(value = "student")
    public Student getStudent() {
        return this.student;
    }

    @DOpt(type = DOpt.Type.Setter)
    @AttrRef(value = "student")
    public void setStudent(Student student) {
        this.student = student;
    }

    @DOpt(type = DOpt.Type.LinkAdderNew)
    @AttrRef(value = "student")
    public boolean setNewStudent(Student obj) {
        setStudent(obj);
        return false;
    }

    @DOpt(type = DOpt.Type.DataSourceConstructor)
    public Address(Integer id, String cityName) throws ConstraintViolationException {
        this.id = genId(id);
        this.cityName = cityName;
        this.student = null;
    }

    @DOpt(type = DOpt.Type.ObjectFormConstructor)
    public Address(String cityName, Student student) throws ConstraintViolationException {
        this.id = genId(null);
        this.cityName = cityName;
        this.student = student;
    }

    @DOpt(type = DOpt.Type.RequiredConstructor)
    public Address(String cityName) throws ConstraintViolationException {
        this.id = genId(null);
        this.cityName = cityName;
        this.student = null;
    }

    @DOpt(type = DOpt.Type.AutoAttributeValueSynchroniser)
    public static void synchWithSource(DAttr attrib, Tuple derivingValue, Object minVal, Object maxVal) throws ConstraintViolationException {
        String attribName = attrib.name();
        if (attribName.equals("id")) {
            int maxIdVal = (Integer) maxVal;
            if (maxIdVal > idCounter)
                idCounter = maxIdVal;
        }
    }
}
