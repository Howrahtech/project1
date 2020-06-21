package com.ravi.movie.Hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:6200")
@RestController
public class HelloWorld {

	
	@GetMapping(path="/hello")
	public String helloWorldMethod() {
		return "hello world";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBeanMethod() {
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanMethodPath(@PathVariable String name) {
		return new HelloWorldBean("hello world  "+name);
	}
}
