package com.student.demo.controller.validator;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.format.datetime.DateFormatter;import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.student.demo.controller.Student;

public class StudentValidation {
	public static Map<String, String> errors;
	
	public static boolean validate(Student student,BindingResult bindingResult) {
		errors= new HashMap<>();
		if(student.getDob()!= null) {
			DateFormatter formatter =new DateFormatter("dd-mm-YYYY");
		try {
			Date date = formatter.parse(student.getDob(), Locale.US);
			student.setDobdb( new java.sql.Date(date.getTime()));
			
			Date todayDate = new Date();
			int diff =getDiffYears(date,todayDate);
			if(!(diff > 15  && diff <= 20))
			{
				FieldError obj = new FieldError("student","DOB", " Age should be greater than 15 year and less than or equal to 20 years.");
				bindingResult.addError(obj);
			}
		} catch (ParseException e) {
			FieldError obj = new FieldError("student","DOB", "Invalid Date Format");
			bindingResult.addError(obj);
		}
		}
		if(student.getGender() == null || 
				!(student.getGender().equalsIgnoreCase("Male")
				|| student.getGender().equalsIgnoreCase("Female"))) {
			FieldError obj = new FieldError("student","gender", "Gender should be Male/Female");
			bindingResult.addError(obj);
		}
		if(student.getSection() == null || 
				!(student.getSection().equalsIgnoreCase("A")
				|| student.getSection().equalsIgnoreCase("B")
				|| student.getSection().equalsIgnoreCase("C"))) {
			FieldError obj = new FieldError("student","section", "Section should be A/B/C");
			bindingResult.addError(obj);
		}
		int m1 = student.getMarks1() == null?0:student.getMarks1();
		int m2 = student.getMarks2() == null?0:student.getMarks2();
		int m3 = student.getMarks3() == null?0:student.getMarks3();
		student.setTotal(m1+m2+m3);
		Float f = (float) ((m1+m2+m3)/3);
		student.setAverage(f);
		if(m1>= 35 && m2 >= 35 && m3 >= 35) {
			student.setResult("Pass");
		}else {
			student.setResult("Fail");
		}
		if(bindingResult.hasErrors()){
			 bindingResult .getAllErrors().forEach((error) -> { 
			        String fieldName =  ((FieldError) error).getField();
			        String errorMessage = error.getDefaultMessage();
			        errors.put(fieldName, errorMessage);
			    });return false;
		}
		return true;
	}
	
	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}
	
	public static int getDiffYears(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diff = b.getTime().getYear() - a.getTime().getYear();
	    if (a.getTime().getMonth() > b.getTime().getMonth() || 
	        (a.getTime().getMonth() == b.getTime().getMonth() && a.getTime().getDate() > b.getTime().getDate())) {
	        diff--;
	    }
	    return diff;
	}

	public static void validateUpdate(Student student) {
		errors= new HashMap<>();
		if(StringUtils.isEmpty(student.getId() )) {
			errors.put("id", "Student Id cannot be left blank");
		}
			if(StringUtils.isEmpty(student.getMarks1() )) {
				errors.put("marks1", "Marks1 cannot be left blank");
			}
			if(StringUtils.isEmpty(student.getMarks2() )) {
				errors.put("marks2", "Marks2 cannot be left blank");
			}
			if(StringUtils.isEmpty(student.getMarks3() )) {
				errors.put("marks3", "Marks3 cannot be left blank");
			}
			if(!(student.getMarks1() <= 100 &&  student.getMarks1() > 0)) {
				errors.put("marks1", "Marks1 range is 0 to 100");
			}
			if(!(student.getMarks2() <= 100 &&  student.getMarks2() > 0)) {
				errors.put("marks2", "Marks2 range is 0 to 100");
			}
			if(!(student.getMarks3() <= 100 &&  student.getMarks3() > 0)) {
				errors.put("marks3", "Marks3 range is 0 to 100");
			}
		
			if(student.getMarks1()>= 35 && student.getMarks2() >= 35 && student.getMarks3() >= 35) {
				student.setResult("Pass");
			}else {
				student.setResult("Fail");
			}
	}

}
