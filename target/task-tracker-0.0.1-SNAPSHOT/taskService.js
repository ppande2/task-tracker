var loginServiceModule=angular.module('taskServiceModule',['ngResource']);

loginServiceModule.service('taskService',function($http,$q,$state,$resource){
	

	var task =this;
	task.taskList={};
	
task.submit=function(formData,success,failure) {
	
	var tasksetup = $resource('task');
	console.log(formData);
	tasksetup.save({},formData, success, failure);
	
			
	};
	
	//return task;
	
});