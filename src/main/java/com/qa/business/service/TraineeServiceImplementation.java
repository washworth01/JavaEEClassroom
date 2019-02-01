package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImplementation implements TraineeService
{
	@Inject
	JSONUtil util;
	
	@Inject
	public TraineeRepository traineeRepo;
	
	@Override
	public String getAllTrainees() 
	{
		return traineeRepo.getAllTrainees();
	}

	@Override
	public String createTrainee(String trainee)
	{
		return traineeRepo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(Long id) 
	{
		return traineeRepo.deleteTrainee(id);
	}

	@Override
	public String updateTrainee(String trainee, Long id) 
	{
		return traineeRepo.updateTrainee(trainee, id);
	}

}
