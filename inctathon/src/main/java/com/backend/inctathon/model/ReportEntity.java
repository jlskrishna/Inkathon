package com.backend.inctathon.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "report_entity")
public class ReportEntity {
	
	@Id
	@GeneratedValue  //(strategy =  GenerationType.IDENTITY)
	public int id;
	public String user;
	public String ip;
	public String method;
	public String url;
	public String page;
	public String queryString;
	public String refererPage;
	public String userAgent;
	public LocalDateTime loggedTime;
	public boolean uniqueVisit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getRefererPage() {
		return refererPage;
	}
	public void setRefererPage(String refererPage) {
		this.refererPage = refererPage;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public LocalDateTime getLoggedTime() {
		return loggedTime;
	}
	public void setLoggedTime(LocalDateTime loggedTime) {
		this.loggedTime = loggedTime;
	}
	public boolean isUniqueVisit() {
		return uniqueVisit;
	}
	public void setUniqueVisit(boolean uniqueVisit) {
		this.uniqueVisit = uniqueVisit;
	}
	
	
	
}
