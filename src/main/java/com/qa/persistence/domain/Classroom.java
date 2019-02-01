package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomID;
	
	private String trainer;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="trainee")
	@JoinColumn(name = "traineeID")
	private List<Trainee> trainees;
	
	
	public Classroom()
	{
		
	}
	
	public Classroom(String trainer, List<Trainee> trainees)
	{
		this.trainer = trainer;
		this.trainees = trainees;

	}

	public Long getId() {
		return classroomID;
	}

	public void setId(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
}
