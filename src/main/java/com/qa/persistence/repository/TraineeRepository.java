package com.qa.persistence.repository;

public interface TraineeRepository 
{
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(Long id);
	String updateTrainee(String trainee, Long id);
}
