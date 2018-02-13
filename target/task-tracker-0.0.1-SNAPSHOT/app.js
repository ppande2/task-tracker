/**
 * 
 */

var app = angular.module('routerApp', ['ui.router','loginController','registerController','taskController','existingController','ngCookies']);

app.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {

	
	
		$urlRouterProvider.otherwise('loginBox');
		
		$stateProvider.state('loginBox', {
		      url: '/loginBox',
		      templateUrl: 'loginBox.html',
		      controller :'formSubmitController'
	  });
		
		$stateProvider.state('entertask', {
		      url: '/entertask',
		      views: {

		            // the main template will be placed here (relatively named)
		            '': { templateUrl: 'activityPage.html'},

		            // the child views will be defined here (absolutely named)
		            'columnOne@entertask': { 
		            		templateUrl:'existingTask.html',
		            		controller: 'existingTasksController'
		            			
		            },
		            
		         // for column two, we'll define a separate controller 
		            
		            'columnTwo@entertask': { 
		            	templateUrl: 'enterTask.html',
		            	controller: 'taskSubmitController'
		            }
		            	  							            	 	  

		            
		          
		      }
		    
		  });
		
		$stateProvider.state('registerMe', {
		      url: '/registerMe',
		      templateUrl: 'registerMe.html',
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
