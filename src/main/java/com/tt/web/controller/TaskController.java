package com.tt.web.controller;

import java.io.IOException;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.domain.ID;
import com.tt.domain.Task;
import com.tt.services.api.TaskService;
import com.tt.utils.JsonUtil;

@Controller
@Transactional
public class TaskController {
	
	@Autowired
	TaskService taskService;

		
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(@RequestBody Task task) throws JsonGenerationException, JsonMappingException, IOException {		
		
		if(task.getTaskPriority()==null){
			task.setTaskPriority("3");
		}
		
		Task tsk=taskService.save(task);
		Task newTask=new Task();
		
		if((tsk)!=null)
		{
			newTask=tsk;
			return JsonUtil.buildJsonFromObject(newTask); 
					
		}
		else 
			return JsonUtil.buildJsonFromObject(newTask);
					
	}
	
	
	@RequestMapping(value = "/existingTasks", method = RequestMethod.GET)
	@ResponseBody
	public String getAllTasksForThisUserId(String userId) throws JsonGenerationException, JsonMappingException, IOException {		
						
		List<Task> tasks=taskService.getAllTasksForThisUserId(userId);
		List<Task> newTask=new ArrayList<Task>();
		
		if((tasks)!=null)
		{
			newTask=tasks;
			return JsonUtil.buildJsonFromObject(newTask); 
					
		}
		else 
			return JsonUtil.buildJsonFromObject(newTask);
					
	}
	
	@RequestMapping(value = "/deleteSelectedTask", method = RequestMethod.POST)
	@ResponseBody
	public String deleteSelectedTasks(@RequestBody String idsToDelete) throws JsonGenerationException, JsonMappingException, IOException {		
		
		String status;
		Map<String,Object> idsMap=JsonUtil.buildmapFromJson(idsToDelete);
		int deletedCount=taskService.deleteSelectedTasks(idsMap.values());
		Map<String,String> myMap=new HashMap<String,String>();
				
		if (deletedCount > 0){
			
			myMap.put("status", "Success");
			return JsonUtil.buildJsonFromObject(myMap);
		}
		else{ 
			myMap.put("status", "Failure");
			return JsonUtil.buildJsonFromObject(myMap);
		}
		//System.out.println(JsonUtil.buildmapFromJson(deleteIds));
		
		//taskService.deleteSelectedTasks(task);	
		/*List<Task> newTask=new ArrayList<Task>();
		
		if((tasks)!=null)
		{
			newTask=tasks;
			return JsonUtil.buildJsonFromObject(newTask); 
					
		}
		else 
			return JsonUtil.buildJsonFromObject(newTask);
	*/
		
	}
	
	
}
