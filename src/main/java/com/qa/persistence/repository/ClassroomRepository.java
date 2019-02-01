package com.qa.persistence.repository;

public interface ClassroomRepository 
{
	String getAllClassrooms();
	String createClassroom(String classroom);
	String deleteClassroom(Long id);
	String updateClassroom(String classroom, Long id);
}
