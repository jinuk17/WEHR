'use strict';

/**
 * @ngdoc service
 * @name wehrApp.sessionInfo
 * @description
 * # sessionInfo
 * Service in the wehrApp.
 */
angular.module('wehrApp')
  .service('sessionInfo', ['$rootScope', function ($rootScope) {
	  
	  this.lcalStorageKey = "__SESSION_IFNO";
	  
	  try{
		  $rootScope.currentUser = JSON.parse(localStorage.getItem(this.lcalStorageKey) || "{}");
	  }catch(e){
		  $rootScope.currentUser = {};
	  }
	  
	  this.getCurrentUser = function(){
		  return $rootScope.currentUser;
	  };
	  
	  this.isUserSignedIn = function(){
		  if(tihs.getCurrentUser() && this.getCurrentUser().id){
			  return true;
		  }else{
			  return false;
		  }
	  };
	  
	  this.setUserInfo = function(info){
		  angular.extend($rootScope.currentUser, info);
		  localStorage.setItem(this.localStorageKey, JSON.stringify($rootScope.currentUser));
	  };
	  
	  this.reset = function(){
		  $rootScope.currentUser = {};
		  localStorage.setItem(this.localStorageKey, JSON.stringify($rootScope.currentUser));
	  };

  }]);
