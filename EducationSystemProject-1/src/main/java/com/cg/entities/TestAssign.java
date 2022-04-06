package com.cg.entities;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TestAssign {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "testId")
	private Test test;

	private Date testDate;

	private LocalTime startTime;

	private LocalTime endTime;

	private int marksObtained;

	public TestAssign() {
		super();

	}

	public TestAssign(int id, Student student, Test test, Date testDate, LocalTime startTime, LocalTime endTime,
			int marksObtained) {
		super();
		this.id = id;
		this.student = student;
		this.test = test;
		this.testDate = testDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.marksObtained = marksObtained;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	@Override
	public String toString() {
		return "TestAssign [id=" + id + ", student=" + student + ", test=" + test + ", testDate=" + testDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", marksObtained=" + marksObtained + "]";
	}

}
