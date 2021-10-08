package com.training.entity;

import com.training.request.CreateStudentRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Signifies that the DB is automatically handling the incrementing
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Transient //Indicates that this is not a column represented in the table. Will not be persisted to DB
    private String fullName;

    public Student(CreateStudentRequest createStudentRequest){
        this.firstName=createStudentRequest.getFirstName();
        this.lastName=createStudentRequest.getLastName();
        this.email=createStudentRequest.getEmail();
        this.fullName=createStudentRequest.getFirstName() + " " + createStudentRequest.getLastName();
    }

}
