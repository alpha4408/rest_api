package com.alpha.rest_api;

import com.alpha.rest_api.Controllers.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static  org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiApplicationTests {

	@Test
	void contextLoads() {
		HomeController homeController = new HomeController();
		String expected = "Welcome to my simple Rest API example";
		String actual = homeController.Home();
		assertEquals(expected,actual,"This method shows strings");


		}


}
