package com.company.Jaxb;

import javax.xml.bind.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;



public class Jaxb
{
    //tai cia sugeneruoja XML
    public void marshall()
    {

        try
        {

            Student student = new Student();
            student.setName("Xz");
            student.setSubject("cbb");

            School school = new School();

            school.setStudents(Arrays.asList(student));

            JAXBContext jc = JAXBContext.newInstance(School.class);
            Marshaller ms = jc.createMarshaller();

            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //tai va cia kazkokia xujne ir pisa prota, ten kur tu siuntei ten naudoja visiskai kitoki liba,
            // bet cia turetu but viskas ok siaip nes sita koda is kazkur nupisau ir ten viskas rabotina tai idk whats wrong
            ms.marshal(school, System.out);
            //VIRSUJ apie sita kalbu
            ms.marshal(student, new File("C:\\Users\\smics\\Desktop\\Saitynai\\src\\data\\Students.xml"));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    //IS XML i paprasta object
    public void unmarshall()
    {
        try
        {
            JAXBContext jc = JAXBContext.newInstance(School.class);
            Unmarshaller ums = jc.createUnmarshaller();
            School school = (School) ums.unmarshal(new File("C:\\Users\\smics\\Desktop\\Saitynai\\src\\data\\Students.xml"));
            List<Student> students = school.getStudents();

            for (Student student: students) {
                System.out.println("Student info");
                System.out.println("Name: " + student.getName());
                System.out.println("Subject: "+ student.getSubject());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
