package com.alpha.rest_api.Controllers;


import com.alpha.rest_api.Services.StudentsService;
import com.alpha.rest_api.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/school")
public class StudentsController {

    private static Logger logger = LoggerFactory.getLogger(StudentsController.class);

    @Autowired
    private StudentsService studentsService;

    @PostMapping(path = "/student")
    public Student saveStudent(@RequestBody Student student) throws IOException {
        logger.info("Saving student to the mongoDB");
        return studentsService.saveStudent(student);
    }

    @GetMapping(path = "/students")
    public List<Student> getMyStudents() {
        return studentsService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable("id") String id) throws IOException{
        logger.info("Trying to get student by ID ");
        return studentsService.getStudentById(id);

    }
    @DeleteMapping(path = ("/delete/{ID}"))
    public void deleteStudentById(@PathVariable(value = "ID") String id){
        logger.info("Trying to delete the records by id", id);
        studentsService.deleteStudentById(id);

    }
//TODO: Update this app to find by GPA
//    @GetMapping(path = ("/{gpa}"))
//    public void findbyGPA(@PathVariable (value = "gpa") Integer gpa){
//        studentsService.findbyGPA(gpa);
//    }

}





