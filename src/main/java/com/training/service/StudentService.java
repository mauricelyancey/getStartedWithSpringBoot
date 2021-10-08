package com.training.service;

import com.training.entity.Student;
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
}
