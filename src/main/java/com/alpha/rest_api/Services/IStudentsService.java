package com.alpha.rest_api.Services;

import com.alpha.rest_api.model.ResponseData;
import com.alpha.rest_api.model.Student;

import java.util.List;

public interface IStudentsService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(String id);
    ResponseData deleteStudentById(String id);

}
