'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:ContactUploadCtrl
 * @description
 * # ContactUploadCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('ContactUploadCtrl', ['$scope', 'fileUpload', function ($scope, fileUpload) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.uploadFile = function(){
        var file = $scope.fileToUpload;
        console.log('file is ' + JSON.stringify(file));
        var uploadUrl = "person/import";
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };
  }]);
