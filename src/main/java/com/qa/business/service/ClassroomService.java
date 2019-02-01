package com.qa.business.service;

public interface ClassroomService 
{
	String getAllClassrooms();
	String createClassroom(String classroom);
	String deleteClassroom(Long id);
	String updateClassroom(String classroom, Long id);
}
