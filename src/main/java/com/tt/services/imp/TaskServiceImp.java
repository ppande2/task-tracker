package com.tt.services.imp;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.dao.api.TaskDAO;
import com.tt.domain.Task;
import com.tt.services.api.TaskService;

@Service
@Transactional
public class TaskServiceImp implements TaskService {
	
	
	@Autowired
	TaskDAO taskdao;
	
	//@Autowired
	//UserDAOJdbc usrdaojdbc;
	
	public Task save(Task tsk){
		
		Task task=taskdao.save(tsk);
		return task;
	}
	
	public List<Task> getAllTasksForThisUserId(String userId){
		
		List<Task> tasks=taskdao.getAllTasksForThisUserId(userId);
		return tasks;
		
		
	}
	
	public int deleteSelectedTasks(Collection<Object> idsToDelete)
	{
		return taskdao.deleteSelectedTasks(idsToDelete);
	}

}
