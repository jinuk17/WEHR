'use strict';

/**
 * @ngdoc service
 * @name wehrApp.wehrFactory
 * @description
 * # wehrFactory
 * Factory in the wehrApp.
 */
angular.module('wehrApp')
  .factory('wehrRequestFactory', function () {
	  var createRequest = function( area, resource, id, params){
		  
		  var request ={
			  "area" : area,
			  "resource" : resource,
			  "id" : id
		  };
		  if(params){
			  request = $.extend(request, params);
		  }
		  
		  return request;
	  };
	  // Public API here
	  return {
		  createRequest : createRequest
	  };
});
