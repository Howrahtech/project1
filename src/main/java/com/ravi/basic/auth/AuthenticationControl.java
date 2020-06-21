package com.ravi.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:6200")
@RestController
public class AuthenticationControl {

	
	
	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldBeanMethod() {
		return new AuthenticationBean("you are  authenticated ");
	}
	
	
}









