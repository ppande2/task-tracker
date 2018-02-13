package com.tt.dao.api;

import java.util.Collection;
import java.util.List;

import com.tt.domain.Task;

public interface TaskDAO {
	

	public Task save(Task tsk);
	public List<Task> getAllTasksForThisUserId(String userId);
	public int deleteSelectedTasks(Collection<Object> idsToDelete);
	public List<Task> getAllTasksToSendEmail();

}
