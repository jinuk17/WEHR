'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('LoginCtrl', ['$scope', '$location', 'sessionService', 'sessionInfo', '$log', function ($scope, $location, sessionService, sessionInfo, $log) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.submitLogin = function(){
    	sessionService.login($scope.login, changeState);
    };
    
    function changeState(response){
    	alert(SessionInfo.getCurrentUser().name + '님 반갑습니다. :)');
    	$location.path("contactsList");
    }
  }]);
