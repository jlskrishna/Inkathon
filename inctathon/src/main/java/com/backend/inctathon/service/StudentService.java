package com.backend.inctathon.service;

import java.util.List;

import com.backend.inctathon.model.ReportEntity;
import com.backend.inctathon.model.Student;



public interface StudentService {
	List<Student> getAllStudents();
	

	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}