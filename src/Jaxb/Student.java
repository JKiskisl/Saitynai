package Jaxb;

import javax.xml.bind.annotation.*;
//student klase kur talpins is xml i paprasta object viska kas bus tame XML'e

@XmlRootElement(name = "Students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student
{

    private String name, subject;

    @XmlElement
    public void setNamee(String name)
    {
        this.name=name;
    }

    public String getNameee()
    {
        return name;
    }

    @XmlElement
    public void setSubjectt(String subject)
    {
        this.subject=subject;
    }

    public String getSubjecttt()
    {
        return subject;
    }

    public Student(String name, String subject)
    {
        super();
    }
    public Student()
    {
        super();
    }

}
