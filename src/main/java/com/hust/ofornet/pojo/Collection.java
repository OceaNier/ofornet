package com.hust.ofornet.pojo;

public class Collection {
    private Integer id;

    private Integer uid;

    private Integer jobid;

    private Job job;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}