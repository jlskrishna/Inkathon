package com.backend.inctathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.inctathon.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
