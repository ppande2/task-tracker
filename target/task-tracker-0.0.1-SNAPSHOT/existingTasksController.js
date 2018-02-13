/**
 * 
 */

var app = angular.module('existingController', ['existingTasksServiceModule']);
	           
	app.controller('existingTasksController',['$scope','$http','$location','$state','existingTasksService','$cookies', function($scope,$http,$location,$state,existingTasksService,$cookies) {
			

	    $scope.existingTasksStatus='';
	    $scope.currentTasks=[];
	    var userId=$cookies.getObject('data').userId;
	 

		$scope.getTasks=function () {
			
			console.log("My user Id is :" + userId);
			
			var formData = {
					"userId" : userId
			};
		
		var success=function(data){
			
			console.log("I am in success of existingTaskController");
			$scope.currentTask=data;
			
		};
		
		var failure=function(data)
		{
			
			console.log("I am in failure of existingTaskController");
		
			
		};
		
		existingTasksService.getTasks(formData,success,failure);
		
		};
		
		$scope.remove = function() {
			
			var success=function(data){
				
				console.log("I am in success of remove function");
				$scope.currentTask=data;
				
			};
			
			var failure=function(data)
			{
				
				console.log("I am in failure of remove function");
			
				
			};
			
            var newCurrentTask=[];
            var deleteTask={};
            var i=0;
            angular.forEach($scope.currentTask,function(rowToDelete){
            if(!rowToDelete.isDelete){
            	newCurrentTask.push(rowToDelete);
            } 
            else {
                 
            	deleteTask["ids" +i]=rowToDelete.id;
            	i=i+1;
            
            }
                
        });  
            
  
         if (Object.keys(deleteTask).length > 0 ) {
        	  console.log(deleteTask);
        	  existingTasksService.deleteSelectedTasks(deleteTask,success,failure); 
         }
         $scope.currentTask=newCurrentTask;      
	   };   
						
		
	}]);