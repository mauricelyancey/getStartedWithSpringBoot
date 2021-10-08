package com.training.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.training.entity.Student;
import lombok.*;

//@Data //Makes Getters, Setters, toString, and hashcode for all variables
//@AllArgsConstructor //Makes a constructor with All arguments automatically
//@NoArgsConstructor //Makes a constructor with no arguments automatically
@Getter
@Setter
public class StudentResponse {
//    @JsonIgnore //Enables you to keep JSON from populating this field in the com.training.response
    private long id;

    @JsonProperty("first_name") //Enables you to change the name in the JSON com.training.response
    private String firstName;

    private String lastName;

    private String email;

    public StudentResponse(Student student){
        this.id=student.getId();
        this.firstName=student.getFirstName();
        this.lastName=student.getLastName();
        this.email=student.getEmail();
    }
}
