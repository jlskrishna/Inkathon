package com.backend.inctathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.inctathon.model.ReportEntity;

@Repository
public interface ReportRepo extends JpaRepository<ReportEntity, Long>{

}
