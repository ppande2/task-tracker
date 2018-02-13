/**
 * 
 */

var existingTasksServiceModule=angular.module('existingTasksServiceModule',['ngResource']);

existingTasksServiceModule.service('existingTasksService',function($http,$q,$state,$resource){
	

	var task =this;
	task.taskList={};
	
task.getTasks=function(formData,success,failure) {
	
	console.log("Also here I am");
	console.log(formData);
	var existingTasks = $resource('existingTasks',formData,{query:{method:'GET',isArray:true}});
	existingTasks.query({},success, failure);
				
	};
	
task.deleteSelectedTasks=function(deleteTasks,success,failure) {
	
	console.log("Also here I am delete service");
    console.log(deleteTasks);
	var deleteSelectedTask = $resource('deleteSelectedTask');
	deleteSelectedTask.save({},deleteTasks,success,failure);
	
    
};

});