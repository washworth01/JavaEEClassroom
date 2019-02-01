package com.qa.business.service;

public interface TraineeService 
{
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(Long id);
	String updateTrainee(String trainee, Long id);
}
