package com.tt.dao.imp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tt.dao.api.TaskDAO;
import com.tt.domain.Task;



@Repository("TaskDAO")
public class TaskDAOImp implements TaskDAO  {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public Task save(Task task){
		
		TypedQuery<Task> typedQuery=entityManager.createQuery("select t from Task t where t.userId=:userId and t.taskName=:taskName and t.dateandtime=:dateandtime",Task.class);
		typedQuery.setParameter("userId",task.getUserId());
		typedQuery.setParameter("taskName",task.getTaskName());
		typedQuery.setParameter("dateandtime",task.getDateandtime());
		List<Task> tasks = typedQuery.getResultList(); 
		if(!tasks.isEmpty())
		{
			return null;
		}		
		
		entityManager.persist(task);	
		return task;
		
	}
	
	public List<Task> getAllTasksForThisUserId(String userId){
		
		System.out.println("I am here");
			
		TypedQuery<Task> typedQuery=entityManager.createQuery("select t from Task t where t.userId=:userId ",Task.class);
		typedQuery.setParameter("userId",userId);
		List<Task> tasks = typedQuery.getResultList();
		
		return tasks;
		
			
	}
	
	public int deleteSelectedTasks(Collection<Object> idsToDelete){
		
//My Changes
		//Integer[] idsToDeleteCovertedToIntegerArray = (Integer[])(idsToDelete.toArray(new Integer[idsToDelete.size()]));
		Query query=entityManager.createQuery("delete from Task t where t.id IN :idsToDelete");
		query.setParameter("idsToDelete",idsToDelete);
		int countDeleted=query.executeUpdate();
		System.out.println("Count Deleted" + countDeleted);
		return countDeleted;

		
		
		
	}
	
	public List<Task> getAllTasksToSendEmail()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date currentDate = new Date();
		System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        Calendar d = Calendar.getInstance();
        c.setTime(currentDate);
        d.setTime(currentDate);

        // manipulate date
        c.add(Calendar.SECOND, 5);
        d.add(Calendar.SECOND, -5);
        

        // convert calendar to date
        Date currentDatePlus30sec = c.getTime();
        Date currentDateMinus30sec = d.getTime();
        

        System.out.println(dateFormat.format(currentDatePlus30sec));
        System.out.println(dateFormat.format(currentDateMinus30sec));
		//long toTimeAdd30sec = now + TimeUnit.SECONDS.toMillis(30);
		//long fromTimeSubstarct30sec=now-TimeUnit.SECONDS.toMillis(30);
	
		TypedQuery<Task> typedQuery=entityManager.createQuery("select t from Task t where dateandtime between :currentDateMinus30sec AND :currentDatePlus30sec  ",Task.class);
		typedQuery.setParameter("currentDatePlus30sec",currentDatePlus30sec);
		typedQuery.setParameter("currentDateMinus30sec",currentDateMinus30sec);
		List<Task> tasks = typedQuery.getResultList();
		for(int i=0 ; i<tasks.size();i++){
		System.out.println("List is " + tasks.get(i).getTaskName());
		}
		return tasks;
	}

}
