package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.status.Status;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DemoData> getData() {
		DemoData data = new DemoData();
		data.id = Long.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmm")));
		data.name = "Jyoti";
		data.age = 27;
		data.qual = "B.Tech";
	    return new ResponseEntity<>(data, HttpStatus.OK);
	}

}

class DemoData {
	long id;
	String name;
	int age;
	String qual;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
}
