package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

public class TraineeMapRepository implements TraineeRepository
{

	@Inject
	JSONUtil util;
	
	private Map<Long, Trainee> traineeMap = new HashMap<>();

	
	@Override
	public String getAllTrainees()
	{
		return util.getJSONForObject(traineeMap.values());
	}

	@Override
	public String createTrainee(String trainee)
	{
		Trainee newTrainee = util.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(newTrainee.getTraineeID(), newTrainee);
		return "New Trainee created";
	}

	@Override
	public String deleteTrainee(Long id) 
	{
		if (traineeMap.get(id) != null)
		{
			traineeMap.remove(id);
		}
		
		return "Trainee has been deleted.";
	}

	@Override
	public String updateTrainee(String trainee, Long id)
	{
		Trainee updatedClassroom = util.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(id, updatedClassroom);
		return "Trainee has been updated";
	}

}
