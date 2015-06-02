'use strict';

/**
 * @ngdoc service
 * @name wehrApp.wehrRestfulApi
 * @description
 * # wehrRestfulApi
 * Factory in the wehrApp.
 */
angular.module('wehrApp')
  .factory('wehrRestfulApi', ['$resource',  function ($resource) {

	  var prefixUrl = '';
	  
	  return $resource(
			  prefixUrl + ':area/:resource/:id',
			  {
				  area : "@area",
				  resource : "@resource",
				  id : "@id"
			  },
			  {
				  /*
				  'get' : {method:'GET'},
				  'list': {method:'GET', isArray:true},
				  'save' : {method:'POST'},
				  'update' : {method:'PUT'},
				  'delete' : {method:'DELETE'},
				  */
				  'login' : {method:'POST'}, 
				  'list': {method:'POST', isArray:true}
			  });
}]);
