package com.company.Jaxb;

import javax.xml.bind.annotation.*;
//student klase kur talpins is xml i paprasta object viska kas bus tame XML'e

@XmlRootElement
public class Student
{
    private String name;
    private String subject;

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }


}
