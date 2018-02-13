var loginServiceModule=angular.module('registerServiceModule',['ngResource']);

loginServiceModule.service('registerService',function($http,$q,$state,$resource){
	

	var task =this;
	task.taskList={};
	
task.submit=function(formData,success,failure) {
	
	var register = $resource('register');
	register.save({},formData, success, failure);
	
			
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