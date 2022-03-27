package com.backend.inctathon.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.backend.inctathon.model.ReportEntity;
import com.backend.inctathon.model.Student;
import com.backend.inctathon.repository.ReportRepo;
import com.backend.inctathon.repository.StudentRepository;
import com.backend.inctathon.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
//g
	//@Autowired
//g
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	
	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}