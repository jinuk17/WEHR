'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
