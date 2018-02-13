package com.tt.services.api;

import java.util.Collection;
import java.util.List;

import com.tt.domain.Task;

public interface TaskService {

	public Task save(Task task);
	public List<Task> getAllTasksForThisUserId(String userId);
	public int deleteSelectedTasks(Collection<Object> idsToDelete);
	
}
