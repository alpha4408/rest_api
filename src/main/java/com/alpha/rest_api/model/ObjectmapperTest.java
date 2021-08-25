package com.alpha.rest_api.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectmapperTest {

    public static void main(String[] args) throws IOException {

        Student student = new Student("","Alpha","Ngwenya","4.0","angweny1@asu.edu");


        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("target/student.json"), student);
    }
}
