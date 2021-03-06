package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Trainee")
public class Trainee 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long traineeID;
	@Column
	private Long classroomID;
	@Column
	private String traineeName;
	
	
	public Trainee()
	{
		
	}
	
	public Trainee(String traineeName, Long classroomID)
	{
		this.classroomID = classroomID;
		this.traineeName = traineeName;
	}

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
}
