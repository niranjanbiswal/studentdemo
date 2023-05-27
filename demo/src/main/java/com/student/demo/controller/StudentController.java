package com.student.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.controller.validator.StudentValidation;
import com.student.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/create",method =RequestMethod.POST)
	@ResponseBody
	Map<String, String> createStudent(@Valid @RequestBody Student student,final BindingResult bindingResult ) {
		
		if(StudentValidation.validate(student, bindingResult)) {
		studentService.createUser(student);
		Map<String, String> map = new HashMap<String, String>();
		map.put("Status", "Student Info Saved Successfully.");
		return map;
		}
		else {
			return StudentValidation.errors;
		}
	}

	
	@RequestMapping(value = "/update",method =RequestMethod.POST)
	@ResponseBody
	Map<String, String> updateStudent(@RequestBody Student student ) {
		
		StudentValidation.validateUpdate(student);
		if(!StudentValidation.errors.isEmpty()) {
			return StudentValidation.errors;
		}else {
			studentService.updateStudent(student);
			Map<String, String> map = new HashMap<String, String>();
			map.put("Status", "Student Info Update Successfully.");
			return map;
		}
		
		
	}
	
	
	
}
