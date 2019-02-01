package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.*;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class ClassroomDBImplementation implements ClassroomRepository
{
	@PersistenceContext(unitName = "primary")
	private EntityManager eManager;
	
	@Inject
	JSONUtil util;

	@Override
	public String getAllClassrooms() 
	{
		TypedQuery<Classroom> query = eManager.createQuery("SELECT c FROM Classroom c ORDER BY trainer", Classroom.class);
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(REQUIRED)
	public String createClassroom(String classroom) 
	{
		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class) ;
		eManager.persist(newClassroom);
		return "{\"message\": \"account sucessfully created\"}" + util.getJSONForObject(newClassroom);
	}

	@Override
	public String deleteClassroom(Long id)
	{
		Classroom removeClassroom = eManager.find(Classroom.class, id);
		eManager.remove(removeClassroom);
		return "{\"message\": \"account sucessfully deleted\"}" + util.getJSONForObject(removeClassroom);
	}

	@Override
	public String updateClassroom(String classroom, Long id) 
	{
		Classroom updatedClassroom = util.getObjectForJSON(classroom, Classroom.class);
		Classroom oldClassroom = eManager.find(Classroom.class, id);
		eManager.remove(oldClassroom);
		eManager.persist(updatedClassroom);
		return "{\"message\": \"account sucessfully updated\"}" + util.getJSONForObject(updatedClassroom);
	
	}
	
}
