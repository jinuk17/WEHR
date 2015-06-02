'use strict';

/**
 * @ngdoc service
 * @name wehrApp.sessionService
 * @description
 * # sessionService
 * Service in the wehrApp.
 */
angular.module('wehrApp')
  .service('sessionService', ['wehrRequestFactory', 'wehrRestfulApi', 'sessionInfo', '$log', function (wehrRequestFactory, wehrRestfulApi, sessionInfo, $log) {
	  
	  this.login = function(params, successCallback){
		  
		  var request = wehrRequestFactory.createRequest('authentication', 'login', '');
		  
		  request.params = {
				  email : params.email,
				  password : params.password
		  };
		  
		  wehrRestfulApi.login(
				  request,
				  function(response){
					  sessionInfo.reset();
					  sessionInfo.setUserInfo(response);
					  successCallback(response);
				  },
				  function(error){
					  $log.error('Server Exception is ', error);
				  }
		  );
	  };
  }]);
