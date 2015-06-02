'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:JsJqgridControllerCtrl
 * @description
 * # JsJqgridControllerCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('JsJqgridControllerCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.getTest = function(){
    	alert("JsJqgridControllerCtrl $scopt.getTest");
    };
  });
