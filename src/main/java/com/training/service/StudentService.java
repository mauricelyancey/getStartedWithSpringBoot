package com.training.service;

import com.training.entity.Student;
import com.training.request.CreateStudentRequest;
import com.training.request.InQueryRequest;
import com.training.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
       return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student=new Student(createStudentRequest);

        student = studentRepository.save(student);
        return student;
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if(updateStudentRequest.getFirstName() !=null && !updateStudentRequest.getFirstName().isEmpty()){
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        if(updateStudentRequest.getLastName() !=null && !updateStudentRequest.getLastName().isEmpty()){
            student.setLastName(updateStudentRequest.getLastName());
        }
        if(updateStudentRequest.getEmail() !=null && !updateStudentRequest.getEmail().isEmpty()){
            student.setEmail(updateStudentRequest.getEmail());
        }
        student= studentRepository.save(student);

        return  student;
    }

    public String deleteStudent(long id){
       studentRepository.deleteById(id);
        return "Student has been deleted successfully";
    }

    public List<Student> getByFirstName(String firstName){ return studentRepository.findByFirstName(firstName);}
    public List<Student> getByLastName(String lastName){ return studentRepository.findByLastName(lastName);}
    public List<Student> getByEmail(String email){ return studentRepository.findByEmail(email);}

    public Student getByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }
}
