/**
 * 
 */

var app = angular.module('loginController', ['loginServiceModule']);
	           
	app.controller('formSubmitController',['$scope','$http','$location','$state','loginService','$cookies', function($scope,$http,$location,$state,loginService,$cookies) {
			
/*		var init = function() {
			$scope.userTypes = ['USER', 'ADMIN'];
			$scope.userType = 'USER';
			$scope.loginResult = null;
		};
	
		init();
*/		
/*		$scope.loginDropdownShowMe = false;
		$scope.registerDropdownShowMe = false;
	    $scope.loginDropdown = function() {
	        $scope.loginDropdownShowMe = !$scope.loginDropdownShowMe;
	    };
	    
	    $scope.registerDropdown = function() {
	        $scope.registerDropdownShowMe = !$scope.registerDropdownShowMe;
	    };
*/			
	    $scope.loginStatus="";
		$scope.list = [];		
		$scope.headerText = 'Task Tracker: Submit below form';
		$scope.submit=function () {
			
			var formData = {
					"userId" : $scope.userId,
					"password" : $scope.password,	
					"role":"USER"
			};
		
		var success=function(data){
			
			$scope.list.push(data);
			console.log("I am in success");
			console.log(data.userId);
			
			if (data.userId === null)
				{
				console.log(data);
				$scope.loginStatus="Oops wrong UserId or Password.If not registered ,click Register me.";
				}
			else	{
					$cookies.putObject('data',data);
					$location.path('entertask');
				
			}
		};
		
		var failure=function(data)
		{
			console.log("I am in failure");
			
		};
		
		/*var promise=loginService.submit(formData);		
		promise.then(function (data){
			
		$scope.list.push(data);
		$scope.taskofList=loginService.taskList;
		console.log($scope.taskofList);
		
		},function(err){

		});
		//Empty list data after process
		
		}; */
		
		loginService.submit(formData,success,failure);
		
		};
		
		$scope.list = [];
		
		
	}]);