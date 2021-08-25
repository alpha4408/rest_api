package com.alpha.rest_api.Repository;


import com.alpha.rest_api.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentsRepository extends MongoRepository<Student, String> {
    Student findByid(String id);
    Student findByGpa(Integer gpa);
    List<Student> findAllByCourseList();

}
