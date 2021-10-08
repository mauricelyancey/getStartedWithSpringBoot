package com.training.controller;

import com.training.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.training.response.StudentResponse;
import com.training.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

//    @Value("${app.name:Default Demo App}")
//    private String appName;

    @Autowired
    StudentService studentService;

//    @GetMapping("/get")
//    public String getStudent(){
////        StudentResponse studentResponse = new StudentResponse(1, "Reese", "Smith");
////        return studentResponse;
//        return "Reese Smith";
//    }

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudents(){
        List<Student> studentList=studentService.getAllStudents();
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }


}
