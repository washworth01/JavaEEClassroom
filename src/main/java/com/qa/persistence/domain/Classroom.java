package com.qa.persistence.domain;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Classroom")
public class Classroom
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomID;
	@Column
	private String trainer;
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "classroomID")
	private Collection<Trainee> trainees = new LinkedHashSet<Trainee>();
	
	
	public Classroom()
	{
		
	}
	
	public Classroom(String trainer, List<Trainee> trainees)
	{
		this.trainer = trainer;
		this.trainees = trainees;

	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Collection<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
}
