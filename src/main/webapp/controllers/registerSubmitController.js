/**
 * 
 */

var app = angular.module('registerController', ['registerServiceModule']);
	           
	app.controller('registerSubmitController',['$scope','$http','$location','$state','registerService','$cookies', function($scope,$http,$location,$state,registerService,$cookies) {
			

	    $scope.registerStatus='Go back to login';
	//	$scope.list = [];		
	//  $scope.headerText = 'Task Tracker: Register below form';
		$scope.submit=function () {
			
			var formData = {
					"userId" : $scope.userId,
					"password" : $scope.password,	
					"role":"USER"
			};
		
		var success=function(data){
			
		//	$scope.list.push(data);
			console.log("I am in success");
			console.log(data.userId);
			
			if (data.userId === null)
				{
				console.log(data);
				$scope.registerStatus="User already exist.Click me.";
				}
			else	{
				$scope.registerStatus="User registered.Click me.";
				//$location.path('loginBox');
						
			}
		};
		
		var failure=function(data)
		{
			console.log("I am in failure");
			
		};
		
		registerService.submit(formData,success,failure);
		
		};
		
	//	$scope.list = [];
		
		
	}]);