package com.alpha.rest_api.Services;




import com.alpha.rest_api.Repository.IStudentsRepository;
import com.alpha.rest_api.model.ResponseData;
import com.alpha.rest_api.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class StudentsService implements IStudentsService {

    private static Logger logger = LoggerFactory.getLogger(StudentsService.class);

    @Autowired
     private IStudentsRepository studentsRepository;

    @Autowired
    private RestTemplate restTemplate;



    public List<Student> getAllStudents() {

        return studentsRepository.findAll();

    }

    public Student saveStudent(Student student) {
        return studentsRepository.save(student);
    }

    public Student getStudentById(String id) {


        logger.info("Trying to get student by ID {}");

        Student response = studentsRepository.findByid(id);

//        ResponseData responseData = ResponseData.Success;

        logger.info("Successfully retrieved student by ID {}", id);

        return response;


    }

    public ResponseData deleteStudentById(String id) {



        logger.info("Trying to delete by ID {}");

        studentsRepository.deleteById(id);
        logger.info("Successfully deleted student by ID {}");
        System.out.println(ResponseData.Success);
        return ResponseData.Success;

    }

//    public Student findbyGPA(Integer gpa){
//        return studentsRepository.findByGpa(gpa);
//    }



}
