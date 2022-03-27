package com.backend.inctathon.logger;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.backend.inctathon.model.ReportEntity;
import com.backend.inctathon.service.impl.ReportServiceImpl;
import com.backend.inctathon.utils.HttpRequestResponseUtils;


@Component
public class ReportEntityLogger implements HandlerInterceptor {

	@Autowired
	private ReportServiceImpl reportServiceImpl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		final String ip = HttpRequestResponseUtils.getClientIpAddress();
		final String url = HttpRequestResponseUtils.getRequestUrl();
		final String page = HttpRequestResponseUtils.getRequestUri();
		final String refererPage = HttpRequestResponseUtils.getRefererPage();
		final String queryString = HttpRequestResponseUtils.getPageQueryString();
		final String userAgent = HttpRequestResponseUtils.getUserAgent();
		final String requestMethod = HttpRequestResponseUtils.getRequestMethod();
		final LocalDateTime timestamp = LocalDateTime.now();

		ReportEntity reportEntity = new ReportEntity();
		reportEntity.setUser(HttpRequestResponseUtils.getLoggedInUser());
		reportEntity.setIp(ip);
		reportEntity.setMethod(requestMethod);
		reportEntity.setUrl(url);
		reportEntity.setPage(page);
		reportEntity.setQueryString(queryString);
		reportEntity.setRefererPage(refererPage);
		reportEntity.setUserAgent(userAgent);
		reportEntity.setLoggedTime(timestamp);
		reportEntity.setUniqueVisit(true);

		reportServiceImpl.saveVisitorInfo(reportEntity);

		return true;
	}

}