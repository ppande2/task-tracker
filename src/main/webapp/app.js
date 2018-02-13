/**
 * 
 */

var app = angular.module('routerApp', ['ui.router','loginController','registerController','taskController','existingController','ngCookies']);

app.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {

	
	
		$urlRouterProvider.otherwise('loginBox');
		
		$stateProvider.state('loginBox', {
		      url: '/loginBox',
		      templateUrl: 'templates/loginBox.html',
		      controller :'formSubmitController'
	  });
		
		$stateProvider.state('entertask', {
		      url: '/entertask',
		      views: {

		            // the main template will be placed here (relatively named)
		            '': { templateUrl: 'templates/activityPage.html'},

		            
		            'columnOne@entertask': { 
		            	templateUrl: 'templates/enterTask.html',
		            	controller: 'taskSubmitController'
		            },
		            
		            // the child views will be defined here (absolutely named)
		            'columnTwo@entertask': { 
		            		templateUrl:'templates/existingTask.html',
		            		controller: 'existingTasksController'
		            			
		            }
		            
		         // for column two, we'll define a separate controller 
		            
		            
		            	  							            	 	  

		            
		          
		      }
		    
		  });
		
		$stateProvider.state('registerMe', {
		      url: '/registerMe',
		      templateUrl: 'templates/registerMe.html',
		      controller:'registerSubmitController'
		      
		    
		  });
		
		
		
	}]);	

app.run([ '$rootScope', '$state', '$stateParams', '$cookies' , '$location', '$window', 
          function ($rootScope, $state, $stateParams, $cookies, $location, $window) {
            $rootScope.$on( '$stateChangeStart', 
              function(e, toState, toParams, fromState, fromParams) {
                var loginStateStr = "loginBox";
                var registerStateStr="registerMe";
                var isLogin = toState.name === loginStateStr;
                var isRegisterMe=toState.name===registerStateStr;
                var userInfo = $cookies.getObject('data');

                if(isLogin || isRegisterMe) {
                  $cookies.remove('data');
                  return;          
                }

                if(userInfo === undefined) {
                    e.preventDefault(); // stop current execution
                    $state.go(loginStateStr); // go to login
                }
              }
            );	
          }
        ]);
