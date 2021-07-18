package com.alpha.rest_api;

//import com.alpha.rest_api.Repository.StudentsRepositoryImpl;
import com.alpha.rest_api.Repository.IStudentsRepository;
import com.alpha.rest_api.Services.StudentsService;
import com.alpha.rest_api.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories(basePackages = IStudentsRepository.class)

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
