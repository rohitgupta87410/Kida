package com.espark.adarsh.bean;

import com.espark.adarsh.persistence.entites.impl.UserRole;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class TaskCreateForm {

	@NotEmpty
	private String issue_name = "test3";

	public String getIssue_name() {
		return issue_name;
	}

	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}

	public String getIssue_report_date() {
		return issue_report_date;
	}

	public void setIssue_report_date(String issue_report_date) {
		this.issue_report_date = issue_report_date;
	}

	public String getIssue_update_date() {
		return issue_update_date;
	}

	public void setIssue_update_date(String issue_update_date) {
		this.issue_update_date = issue_update_date;
	}

	public String getIssue_heading() {
		return issue_heading;
	}

	public void setIssue_heading(String issue_heading) {
		this.issue_heading = issue_heading;
	}

	public String getIssue_description() {
		return issue_description;
	}

	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}

	public String getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}

	public String getIssue_linked_with() {
		return issue_linked_with;
	}

	public void setIssue_linked_with(String issue_linked_with) {
		this.issue_linked_with = issue_linked_with;
	}

	public String getIssue_comments() {
		return issue_comments;
	}

	public void setIssue_comments(String issue_comments) {
		this.issue_comments = issue_comments;
	}

	public String getIssue_others() {
		return issue_others;
	}

	public void setIssue_others(String issue_others) {
		this.issue_others = issue_others;
	}

	public String getIssue_closed() {
		return issue_closed;
	}

	public void setIssue_closed(String issue_closed) {
		this.issue_closed = issue_closed;
	}

	public String getIssue_type() {
		return issue_type;
	}

	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}

	private String issue_report_date = "";

	private String issue_update_date = "";

	private String issue_heading = "";

	private String issue_description = "";

	private String issue_status = "";

	private String issue_linked_with = "";

	private String issue_comments = "";

	private String issue_others = "";

	private String issue_closed = "";

	@NotNull
	private String issue_type = "";
	
	private UserRole userRole;
	
	public void setRole(UserRole userRole) {
        this.userRole = userRole;
    }
	
	public UserRole getRole() {
        return userRole;
    }

	@Override
	public String toString() {
		return "TaskCreateForm{" + "issue_name='"
				+ '\'' + ", issue_report_date='"
				+ '\'' + ", issue_update_date=" 
				+ '\'' + ", issue_heading="
				+ '\'' + ", issue_description="
				+ '\'' + ", issue_status=" 
				+ '\'' + ", issue_linked_with="
				+ '\'' + ", issue_comments="
				+ '\'' + ", issue_others=" 
				+ '\'' + ", issue_closed="
				+ '\'' + ", issue_type="
				+ '}';
	}

}
