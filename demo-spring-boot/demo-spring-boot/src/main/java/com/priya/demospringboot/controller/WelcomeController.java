package com.priya.demospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
	@GetMapping("/welcome")
	public String sayHi(){
		return "Hello Priya";
		
	}
	@GetMapping("/")
	public String home(){
		return "Hello";
	}
}
