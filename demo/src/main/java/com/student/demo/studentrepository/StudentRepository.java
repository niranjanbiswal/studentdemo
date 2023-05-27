package com.student.demo.studentrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.demo.controller.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
