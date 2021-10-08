package com.training.controller;

import com.training.entity.Student;
import com.training.request.CreateStudentRequest;
import com.training.request.InQueryRequest;
import com.training.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.training.response.StudentResponse;
import com.training.service.StudentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudents(){
        List<Student> studentList=studentService.getAllStudents();
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student=studentService.createStudent(createStudentRequest);

        return new StudentResponse(student);
    }

    @PutMapping("/update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student= studentService.updateStudent(updateStudentRequest);

        return new StudentResponse(student);
    }

//    @DeleteMapping("/delete")
//    public String deleteStudent(@RequestParam long id){
//        return studentService.deleteStudent(id);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("getByFirstName/{firstname}")
    public List<StudentResponse> getByFirstName(@PathVariable String firstname){
        List<Student> studentList=studentService.getByFirstName(firstname);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getByLastName/{lastname}")
    public List<StudentResponse> getByLastName(@PathVariable String lastname){
        List<Student> studentList=studentService.getByLastName(lastname);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getByEmail/{email}")
    public List<StudentResponse> getByEmail(@PathVariable String email){
        List<Student> studentList=studentService.getByEmail(email);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return new StudentResponse(studentService.getByFirstNameAndLastName(firstName,lastName));
    }

    @GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName){
        List<Student> studentList=studentService.getByFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        List<Student> studentList=studentService.getByFirstNameIn(inQueryRequest);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getAllWithPagination")
    public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo,
                                                             @RequestParam int pageSize){
        List<Student> studentList=studentService.getAllStudentsWithPagination(pageNo, pageSize);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getAllWithSorting")
    public List<StudentResponse> getAllWithSorting(){
        List<Student> studentList=studentService.getAllStudentsWithSorting();
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("like/{firstName}")
    public List<StudentResponse> like(@PathVariable String firstName){
        List<Student> studentList=studentService.findByLike(firstName);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("startsWith/{firstName}")
    public List<StudentResponse> startsWith(@PathVariable String firstName){
        List<Student> studentList=studentService.findbyStartsWith(firstName);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("endsWith/{firstName}")
    public List<StudentResponse> endsWith(@PathVariable String firstName){
        List<Student> studentList=studentService.findbyEndsWith(firstName);
        List<StudentResponse> studentResponseList= new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }
}
