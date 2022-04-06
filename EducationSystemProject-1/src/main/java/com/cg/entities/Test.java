package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "tests_table")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_id")
	private int testId;

	@Column(name = "test_name")
	private String testName;

	@Column(name = "total")
	private int total;

	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

	public Test() {
		super();
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", total=" + total + ", course=" + course + "]";
	}

	public Test(int testId, String testName, int total, Course course) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.total = total;
		this.course = course;
	}

}