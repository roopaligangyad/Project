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
@Table(name = "payments_table")
public class Payment {
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;

    @Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "payment_date", nullable = false)
	private String paymentDate;
	
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;
	
	
	public Payment(int transactionId, double amount, String description, String paymentDate, Student student,
			Course course) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.description = description;
		this.paymentDate = paymentDate;
		this.student = student;
		this.course = course;
	}


	public Payment() {
		super();
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", amount=" + amount + ", description=" + description
				+ ", paymentDate=" + paymentDate + ", student=" + student + ", course=" + course + "]";
	}
	
	

	

}
