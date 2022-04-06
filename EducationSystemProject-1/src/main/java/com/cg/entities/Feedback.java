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
@Table(name = "Feedbacks")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;

	@Column(name = "feedback")
	private String feedback;

	@ManyToOne
	@JoinColumn(name = "trainerId")
	private Trainer trainer;

	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;

	// Empty Constructor.

	public Feedback() {

	}

	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", feedback=" + feedback + ", trainer=" + trainer + ", student=" + student
				+ "]";
	}

	public Feedback(int fid, String feedback, Trainer trainer, Student student) {
		super();
		this.fid = fid;
		this.feedback = feedback;
		this.trainer = trainer;
		this.student = student;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
