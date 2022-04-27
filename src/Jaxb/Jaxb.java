package Jaxb;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.URL;


public class Jaxb
{

    private final XMLInputFactory factory = XMLInputFactory.newInstance();


    //to XML
    public String Marshall(School school)
    {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(School.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File("Students.xml");
            marshaller.marshal(school, file);
            Path fileName = Path.of(file.getName());

            return Files.readString(fileName);
        }
        catch (Exception e)
        {
            System.out.println("An error has occurred: " + e.getMessage());
            return null;
        }
    }
    //IS XML i paprasta object
    public School unmarshalll(String Xml, boolean CheckSchema)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(School.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            if (CheckSchema)
            {
                final URL schemaURL = Jaxb.class.getResource("/Students.xml");
                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
                Schema schema = sf.newSchema(schemaURL);
                unmarshaller.setSchema(schema);
            }
            InputStream stream = new ByteArrayInputStream(Xml.getBytes(StandardCharsets.UTF_8));
            XMLEventReader eventReader = factory.createXMLEventReader(stream);
            JAXBElement<School> userElement = unmarshaller.unmarshal(eventReader, School.class);


            return userElement.getValue();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /*
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

     */
}
