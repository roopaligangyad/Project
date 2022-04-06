package com.cg.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "courses_table")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_Id", nullable = false)
	private int courseId;

	@Column(name = "course_name", nullable = false)
	private String courseName;

	@Column(name = "course_fees", nullable = false)
	private double courseFees;

	@Column(name = "student_fk", nullable = true)

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	@ManyToOne
	@JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id")
	private Trainer trainer;

	@Column(name = "hours")
	private float hours;

	public Course() {
		super();
	}

	public Course(int courseId, String courseName, double courseFees, List<Student> students, Trainer trainer,
			float hours) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFees = courseFees;
		this.students = students;
		this.trainer = trainer;
		this.hours = hours;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(double courseFees) {
		this.courseFees = courseFees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees
				+ ", students=" + students + ", trainer=" + trainer + ", hours=" + hours + "]";
	}

}
