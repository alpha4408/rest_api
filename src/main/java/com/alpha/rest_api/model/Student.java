package com.alpha.rest_api.model;


import org.bson.types.ObjectId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Document(collection="students")
@Entity
public class Student implements Serializable {

    public Student(String id, String firstName, String lastName, Integer gpa, String email, String phoneNumber, List<String> courseList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseList = courseList;
    }

    @Id
    private String id;

    @NotNull
    @Size(min=2, message ="Name must be at least more than 2 characters")
    @JsonProperty("FirstName")
    private String firstName;

    @NotNull
    @Size(min=2, message ="Name must be at least more than 2 characters")
    @JsonProperty("LastName")
    private String lastName;

    @JsonIgnore
    private Integer gpa;

    private String email;
    private String phoneNumber;

    @Size(min=1, message ="You must have at least one course")
    private List<String> courseList;

            public Student(String id, String firstName, String lastName, String s, String email) {
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}

