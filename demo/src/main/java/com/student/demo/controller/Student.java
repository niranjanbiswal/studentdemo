package com.student.demo.controller;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;

@Entity(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	@Column(name = "FIRST_NAME")
	@NotBlank(message = "First Name should not be empty")
	@Size(min=3,message = "First Name should be atleast  3 characters")
	String firstName;
	
	
	@Column(name = "LAST_NAME")
	@NotBlank(message = "Last Name should not be empty")
	@Size(min=3 , message = "Last Name should be atleast  3 characters")
	
	String lastName;
	
	
	@NotBlank(message = "DOB is mandatory")
	@Transient
	String dob;
	
	@Column(name="DOB")
	Date dobdb;
	
	@Column(name = "SECTION")
	String section;
	
	@Column(name = "GENDER")
	String gender;
	
	
	@Column(name = "Marks1")
	@Range(min = 0,max=100,message = "Marks1 range is 0 to 100")
	Integer marks1;
	
	@Column(name = "Marks2")
	@Range(min = 0,max=100, message = "Marks2 range is 0 to 100")
	Integer marks2;
	
	@Column(name = "Marks3")
	@Range(min = 0,max=100, message = "Marks3 range is 0 to 100")
	Integer marks3;
	
	@Column(name = "Total")
	Integer total;
	
	@Column(name = "Average")
	Float average;
	
	@Column(name = "Result")
	String result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Date getDobdb() {
		return dobdb;
	}

	public void setDobdb(Date dobdb) {
		this.dobdb = dobdb;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getMarks1() {
		return marks1;
	}

	public void setMarks1(Integer marks1) {
		this.marks1 = marks1;
	}

	public Integer getMarks2() {
		return marks2;
	}

	public void setMarks2(Integer marks2) {
		this.marks2 = marks2;
	}

	public Integer getMarks3() {
		return marks3;
	}

	public void setMarks3(Integer marks3) {
		this.marks3 = marks3;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
}
