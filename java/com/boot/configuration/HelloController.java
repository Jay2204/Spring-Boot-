package com.boot.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.ExceptionResponse;
import com.boot.model.User;
import com.boot.service.StudentService;

@Controller
public class HelloController {


	@Autowired
	StudentService studentService;

	@RequestMapping("/hello")
	public String hello(
			Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		System.out.println("hey" + name);
		return "forward:/WelcomeScreen.jsp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<User> addStudent(@RequestBody User user) {

		System.out.println("added student details");
		System.out.println("added "+user.getName());
		studentService.addStudent(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@RequestMapping(value = "/view1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> viewStudent() {
		
		List<User> userList=studentService.viewStudentDetails();
			

		System.out.println("view student details");
		return studentService.viewStudentDetails();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> updateStudent(@PathVariable(value = "id") int id,
			@RequestBody User oldStudent) {
		List<User> studentList = studentService
				.updateStudent(id, oldStudent);
		System.out.println("updated student details");
		return studentList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable(value = "id") int id) {
		System.out.println("id= "+id);
		List<User> studentList = studentService.deleteStudent(id);
		System.out.println("size "+studentList.size());
		
		
	}
}