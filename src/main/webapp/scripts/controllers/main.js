'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('MainCtrl', ['$scope', 'personService', function ($scope, personService) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.doSomething = function(){
    	alert("msg");
    	var params = {userId : 1};
    	//personService.column(params);
    	personService.list(params);
    };
  }]);
