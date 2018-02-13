/**
 * 
 */

var app = angular.module('taskController', ['taskServiceModule']);
	           
	app.controller('taskSubmitController',['$scope','$http','$location','$state','taskService','$cookies', function($scope,$http,$location,$state,taskService,$cookies) {
			

	    $scope.taskStatus='';
	    var userId=$cookies.getObject('data').userId;
	//	$scope.list = [];		
	//  $scope.headerText = 'Task Tracker: Register below form';
		$scope.submit=function () {
			
			var formData = {
					"userId" : userId,
					"taskName" : $scope.taskName,
					"taskDescription" : $scope.taskDescription,	
					"taskPriority":$scope.taskPriority,
					"dateandtime" :$scope.taskSchedule
			};
		
		var success=function(data){
			
			console.log("I am in success");
			console.log(data.userId);
			
			if (data.userId === null)
				{
				console.log(data);
				$scope.taskStatus="Task Already Exist wih same name at same time.";
				}
			else	{
				$scope.taskStatus="Task Setup Succesfully.";
						
			}
		};
		
		var failure=function(data)
		{
			
			console.log("I am in failure");
		
			
		};
		
		taskService.submit(formData,success,failure);
		
		};
				
		
	}]);