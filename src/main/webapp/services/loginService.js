var loginServiceModule=angular.module('loginServiceModule',['ngResource']);

loginServiceModule.service('loginService',function($http,$q,$state,$resource){
	

	var task =this;
	task.taskList={};
	
task.submit=function(formData,success,failure) {
	
	var login = $resource('login');
	login.save({},formData, success, failure);
	
			
	/*	var defer=$q.defer();	
		var response = $http.post('login', formData);
		response.success(function(data, status, headers, config) {
		task.taskList=data;		
		defer.resolve(data);	
		$state.go('entertask');
		$location.path=("entertask");  
		console.log($location.path);			
		});
		response.error(function(data, status, headers, config) {
		console.log("It's in reject function");
		defer.reject(alert( "Exception details: " + JSON.stringify({data: data})));
		});
			
		return defer.promise;*/
	};
	
	//return task;
	
});