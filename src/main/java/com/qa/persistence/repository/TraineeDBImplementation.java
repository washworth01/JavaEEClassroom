package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.*;

@Default
@Transactional(SUPPORTS)
public class TraineeDBImplementation implements TraineeRepository
{
	@PersistenceContext(unitName = "primary")
	private EntityManager eManager;
	
	@Inject
	JSONUtil util;
	
	@Override
	public String getAllTrainees() 
	{
		TypedQuery<Trainee> query = eManager.createQuery("SELECT c FROM Trainee c ORDER BY trainer", Trainee.class);
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) 
	{
		Trainee newTrainee = util.getObjectForJSON(trainee, Trainee.class) ;
		eManager.persist(newTrainee);
		return "{\"message\": \"account sucessfully created\"}" + util.getJSONForObject(newTrainee);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) 
	{
		Trainee removeTrainee = eManager.find(Trainee.class, id);
		eManager.remove(removeTrainee);
		return "{\"message\": \"account sucessfully deleted\"}" + util.getJSONForObject(removeTrainee);
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(String trainee, Long id)
	{
		Trainee updatedTrainee = util.getObjectForJSON(trainee, Trainee.class);
		Trainee oldTrainee = eManager.find(Trainee.class, id);
		eManager.remove(oldTrainee);
		eManager.persist(updatedTrainee);
		return "{\"message\": \"account sucessfully updated\"}" + util.getJSONForObject(updatedTrainee);
	}
	
}
