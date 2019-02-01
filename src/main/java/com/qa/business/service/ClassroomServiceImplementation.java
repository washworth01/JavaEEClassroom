package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImplementation implements ClassroomService
{
	@Inject
	JSONUtil util;
	
	@Inject
	public ClassroomRepository classroomRepo;
	
	@Override
	public String getAllClassrooms() 
	{
		return classroomRepo.getAllClassrooms();
	}

	@Override
	public String createClassroom(String classroom) 
	{
		return classroomRepo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Long id) 
	{
		return classroomRepo.deleteClassroom(id);
	}

	@Override
	public String updateClassroom(String classroom, Long id) 
	{
		return classroomRepo.updateClassroom(classroom, id);
	}
	
}
