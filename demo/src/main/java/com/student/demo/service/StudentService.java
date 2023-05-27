
package com.student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.controller.Student;
import com.student.demo.studentrepository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student createUser(Student student) {
		return studentRepository.save(student);
	}

	public void updateStudent(Student student) {
		
		Student  studentOld = studentRepository.getById(student.getId());
		studentOld.setMarks1(student.getMarks1());
		studentOld.setMarks2(student.getMarks2());
		studentOld.setMarks3(student.getMarks3());
		studentOld.setTotal(student.getMarks1()+student.getMarks2()+student.getMarks3());
		Float avg = (float) ((student.getMarks1()+student.getMarks2()+student.getMarks3())/3);
		studentOld.setAverage(avg);
		studentOld.setDob(studentOld.getDobdb().toLocaleString());
		studentOld.setResult(student.getResult());
		studentRepository.saveAndFlush(studentOld);
	}	
}
