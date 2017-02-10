package com.espark.adarsh.persistence.entites.impl;

import java.util.Date;
import java.util.HashSet;

import com.espark.adarsh.bean.TaskCreateForm;
import com.espark.adarsh.bean.UserCreateForm;
import com.espark.adarsh.persistence.entites.construct.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "issue_main")
public final class Task extends AbstractEntity<Long> {

	 @Column(unique = true, length = 24, nullable = false)
    private String issue_name;
    
    @Column(nullable = false, length = 100)
    private String issue_report_date;
    
    @Column(nullable = true, length = 24)
    private String issue_update_date;
    
    @Column(nullable = true, length = 100)
    private String issue_heading;
    
    @Column(nullable = true, length = 100)
    private String issue_description;

    @Column(nullable = true, length = 100)
    private String issue_status;

    @Column(nullable = true, length = 100)
    private String issue_linked_with;
    
    @Column(nullable = true, length = 100)
    private String issue_comments;
    
    @Column(nullable = true, length = 100)
    private String issue_others;
    
    @Column(nullable = true, length = 100)
    private String issue_closed;

    @Column(nullable = false, length = 100)
    private String issue_type;
    
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

	

	public Task() {
        super(Task.class);
    }

	public Task(Long id) {
        super(Task.class);
        super.setId(id);
        this.settaskname("");
    }
	
    public Task(String issue_name) {
        this();
        this.issue_name = issue_name;
    }

    public Task(Task task) {
        super(Task.class);
        this.issue_name = task.gettaskname();
        this.issue_status = task.getIssue_status();
        this.issue_report_date = task.getIssue_report_date();
        this.issue_update_date = task.getIssue_update_date();
        this.issue_heading = task.getIssue_heading();
        this.issue_description = task.getIssue_description();
        this.issue_linked_with = task.getIssue_linked_with();
        this.issue_comments = task.getIssue_comments();
        this.issue_others = task.getIssue_others();
        this.issue_closed = task.getIssue_closed();
        this.issue_type = task.getIssue_type();
    }
    
    public Task(final TaskCreateForm taskCreateForm){
        super(Task.class);
        this.issue_name = taskCreateForm.getIssue_name();
        this.issue_status = taskCreateForm.getIssue_status();
        this.issue_report_date = taskCreateForm.getIssue_report_date();
        this.issue_update_date = taskCreateForm.getIssue_update_date();
        this.issue_heading = taskCreateForm.getIssue_heading();
        this.issue_description = taskCreateForm.getIssue_description();
        this.issue_linked_with = taskCreateForm.getIssue_linked_with();
        this.issue_comments = taskCreateForm.getIssue_comments();
        this.issue_others = taskCreateForm.getIssue_others();
        this.issue_closed = taskCreateForm.getIssue_closed();
        this.issue_type = taskCreateForm.getIssue_type();
    }

    public String gettaskname() {
        return issue_name;
    }

    public void settaskname(String issue_name) {
        this.issue_name = issue_name;
    }

    public String getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}

    @Override
    public String toString() {
        return "Task{" +
                "issue_name='" + issue_name + '\'' +
                 "issue_status='" + issue_status + '\'' +
                 "issue_report_date='" + issue_report_date + '\'' +
                 "issue_update_date='" + issue_update_date + '\'' +
                 "issue_heading='" + issue_heading + '\'' +
                 "issue_description='" + issue_description + '\'' +
                 "issue_linked_with='" + issue_linked_with + '\'' +
                 "issue_comments='" + issue_comments + '\'' +
                 "issue_others='" + issue_others + '\'' +
                 "issue_closed='" + issue_closed + '\'' +
                 "issue_type='" + issue_type + '\'' +
                '}';
    }
}
