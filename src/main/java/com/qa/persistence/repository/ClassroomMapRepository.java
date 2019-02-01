package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository
{
	@Inject
	JSONUtil util;
	
	private Map<Long, Classroom> classroomMap = new HashMap<>();

	@Override
	public String getAllClassrooms() 
	{
		return util.getJSONForObject(classroomMap.values());
	}

	@Override
	public String createClassroom(String classroom)
	{
		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(newClassroom.getClassroomID(), newClassroom);
		return "New Account created";
	}

	@Override
	public String deleteClassroom(Long id) 
	{
		if (classroomMap.get(id) != null)
		{
			classroomMap.remove(id);
		}
		
		return "Account has been deleted.";
	}

	@Override
	public String updateClassroom(String classroom, Long id) 
	{
		Classroom updatedClassroom = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(id, updatedClassroom);
		return "Classroom has been updated";
	}
}
