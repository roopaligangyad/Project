package com.cg.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trainers_table")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainer_id", nullable = false)
	private int trainer_id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@OneToMany(mappedBy = "trainer")
	private List<Course> courses;

	public Trainer() {
		super();
	}

	public Trainer(int trainer_id, String firstName, String lastName, List<Course> courses) {
		super();
		this.trainer_id = trainer_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}



	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainer_id + ", firstName=" + firstName + ", lastName=" + lastName + ", courses="
				+ courses + "]";
	}

}
