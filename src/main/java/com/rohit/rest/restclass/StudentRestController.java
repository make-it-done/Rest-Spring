package com.rohit.rest.restclass;

import com.rohit.rest.Entity.Student;
import com.rohit.rest.Entity.StudentErrorResponse;
import com.rohit.rest.Exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/get")
public class StudentRestController {


    private List<Student > students=new ArrayList<>();

    @PostConstruct
    public void loadData() {
        Student student1 = new Student("rohit", "kumar");
        Student student2 = new Student("kumar", "rohit");
        students.add(student1);
        students.add(student2);
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if (studentId>=students.size() || studentId<0)
            throw  new StudentNotFoundException("Student id not found "+studentId);
        return students.get(studentId);
    }
}
