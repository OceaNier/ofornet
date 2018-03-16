package com.hust.ofornet.pojo;

import java.util.List;

public class Category {
    private Integer id;

    private String name;
    /*如下是非数据库字段*/
    private List<Job> jobs;

    private List<List<Job>> jobsByRow;

   

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<List<Job>> getJobsByRow() {
		return jobsByRow;
	}

	public void setJobsByRow(List<List<Job>> jobsByRow) {
		this.jobsByRow = jobsByRow;
	}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}