package com.backend.inctathon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.inctathon.model.ReportEntity;
import com.backend.inctathon.repository.ReportRepo;


@Service
public class ReportServiceImpl {

	@Autowired
	private ReportRepo reportRepo;

	public ReportEntity saveVisitorInfo(ReportEntity reportEntity) {
		return reportRepo.save(reportEntity);
	}

}