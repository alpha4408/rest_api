/*package com.alpha.rest_api.Repository;


import com.alpha.rest_api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class StudentsRepositoryImpl implements IStudentsRepository {

    @Autowired
    Student student;

    @Autowired
    IStudentsRepository iStudentsRepository;

    public String getStudentById(String id) {
        if(id.equals(student.getId())){
            iStudentsRepository.findById(id);
        }
        return student.getFirstName() + student.getLastName() + student.getEmail();

    }

    @Override
    public <S extends Student> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Student> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Student> findById(String s) {
        return Optional.empty();
    }


    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Iterable<Student> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }


    public void deleteStudentById(String id) {
        if(id.equals(student.getId())){
            iStudentsRepository.deleteById(id);
        }


    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Student> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Student> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Student> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Student> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Student> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Student> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Student> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Student> boolean exists(Example<S> example) {
        return false;
    }
}
*/