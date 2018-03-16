package com.hust.ofornet.pojo;

import java.util.Date;

public class Employment {
    private Integer id;

    private String employmentCode;

    private Integer coid;

    private Integer rid;

    private Integer uid;

    private Integer jobid;

    private String message;

    private Date createDate;

    private String employStatus;
    
    private User user;
    private Company company;
    private Resume resume;
    private Job job;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmploymentCode() {
        return employmentCode;
    }

    public void setEmploymentCode(String employmentCode) {
        this.employmentCode = employmentCode == null ? null : employmentCode.trim();
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(String employStatus) {
        this.employStatus = employStatus == null ? null : employStatus.trim();
    }
}