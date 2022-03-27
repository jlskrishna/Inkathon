package com.backend.inctathon.service;

import java.util.List;

import com.backend.inctathon.model.ReportEntity;
import com.backend.inctathon.model.Student;

public interface ReportService {
	List<ReportEntity> getReport();
    ReportEntity saveReportEntity(ReportEntity reportEntity);
	
    ReportEntity getReportEntityById(Long id);
	
    ReportEntity updateReportEntity(ReportEntity reportEntity);
	
	void deleteReportEntityById(Long id);
}
