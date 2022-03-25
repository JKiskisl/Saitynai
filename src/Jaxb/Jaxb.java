package Jaxb;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import java.io.File;
import javax.xml.bind.JAXBContext;



public class Jaxb
{
    //tai cia sugeneruoja XML
    public void marshall()
    {

        try
        {
            Student student = new Student("Xz","cbb");
            JAXBContext jc = JAXBContext.newInstance(Student.class);
            Marshaller ms = jc.createMarshaller();

            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //tai va cia kazkokia xujne ir pisa prota, ten kur tu siuntei ten naudoja visiskai kitoki liba,
            // bet cia turetu but viskas ok siaip nes sita koda is kazkur nupisau ir ten viskas rabotina tai idk whats wrong
            ms.marshal(student, (Result) System.out);
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
            JAXBContext jc = JAXBContext.newInstance(Student.class);
            Unmarshaller ums = jc.createUnmarshaller();
            Student student = (Student) ums.unmarshal(new File("C:\\Users\\smics\\Desktop\\Saitynai\\src\\data\\Students.xml"));


            System.out.println("Student info");
            System.out.println("Name: " + student.getNameee());
            System.out.println("Subject: "+ student.getSubjecttt());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
