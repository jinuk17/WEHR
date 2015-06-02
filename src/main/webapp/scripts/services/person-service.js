'use strict';

/**
 * @ngdoc service
 * @name wehrApp.personService
 * @description
 * # personService
 * Service in the wehrApp.
 */
angular.module('wehrApp')
  .service('personService', ['wehrRequestFactory', 'wehrRestfulApi', '$log', function (wehrRequestFactory, wehrRestfulApi, $log) {
	  
	  this.column = function(params, successCallback){
		  var request = wehrRequestFactory.createRequest('person', 'columns', '');
		  request.params = {
				  userId : params.userId
		  };
		  
		  wehrRestfulApi.query(request, function(response){
											  successCallback();
										  },
										  function(error){
											  $log.error('Server Exception is ', error);
										  }
		  );
	  };
	  
	  this.list = function(params, successCallback){
		  
		  var params = {
				  page : params.pageNumber,
				  rows : params.pageSize,
				  sort : params.sort.column,
				  order : params.sort.direction,
				  departmentId : params.departmentId
		  };
		  
		  var request = wehrRequestFactory.createRequest('person', 'list', '', params);
		 
		  wehrRestfulApi.get(request, function(response){
											  successCallback(response);
										  },
										  function(error){
											  $log.error('Server Exception is ', error);
										  }
		  );
	  };
	  
	  this.search = function(params, successCallback){
		  var params = {
				  page : params.pageNumber,
				  rows : params.pageSize,
				  sort : params.sort.column,
				  order : params.sort.direction 
		  };
		  
		  var request = wehrRequestFactory.createRequest('person', 'columns', '', params);
		  
		  wehrRestfulApi.list(request, function(response){
											  successCallback(response);
										  },
										  function(error){
											  $log.error('Server Exception is ', error);
										  }
		  );
	  };
	  
	  this.departmentTree = function(companyId, successCallback){
		  
			  var request = wehrRequestFactory.createRequest('department', 'tree', companyId);
			  
			  wehrRestfulApi.query(request, function(response){
				  successCallback(response);
			  },
			  function(error){
				  $log.error('Server Exception is ', error);
			  }
		  );
	  };
  }]);
