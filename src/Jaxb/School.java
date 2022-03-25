package Jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Students")
@XmlAccessorType(XmlAccessType.FIELD)
public class School
{
    @XmlElement(name = "student")
    private List<Student> students;

    public void setStudents(List < Student > students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

}
