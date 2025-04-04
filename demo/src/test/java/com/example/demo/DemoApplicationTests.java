package com.example.demo;

import com.example.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private String baseUrl = "/book/create";

	@Test
	void contextLoads() {

		Book book = new Book();
		book.setTitle("Spring Boot");
		book.setAuthor("John Doe");


		ResponseEntity<Book> response = restTemplate.postForEntity(baseUrl, book, Book.class);

		assertEquals(200, response.getStatusCodeValue());

		assertEquals("Spring Boot", response.getBody().getTitle());
		assertEquals("John Doe", response.getBody().getAuthor());
	}
}
