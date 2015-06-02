'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:ContactInfoCtrl
 * @description
 * # ContactInfoCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('ContactInfoCtrl', function ($scope, $modalInstance, items) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    $scope.items = items;
    $scope.selected = {
      item: $scope.items[0]
    };

    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    
    //Start Datapicker
    
    $scope.today = function() {
    	$scope.dt = new Date();
    };
    
    $scope.clear = function () {
    	$scope.dt = null;
    };

    /*
    $scope.disabled = function(date, mode) {
    	return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
    };
    $scope.toggleMin = function() {
    	$scope.minDate = $scope.minDate ? null : new Date();
    };
    
    $scope.toggleMin();
    
     $scope.today();
    */
    $scope.open = function($event) {
    	$event.preventDefault();
    	$event.stopPropagation();
    	$scope.opened = true;
    };

    $scope.dateOptions = {
    		formatYear: 'yy',
    		startingDay: 1
    };
    
    //End Datapicker
    
    
    //Start Company ui select
    $scope.company = {};
    $scope.companies = [
                     { id: 1,      code: 'WE',      name: '위메이드엔터테이먼트'},
                     { id: 2,      code: 'WC',      name: '위메이드크리에이티브'},
                     { id: 3,      code: 'JM',      name: '조이맥스'},
                     { id: 4,      code: 'IO',      name: '아이오엔터테이먼트'},
                     { id: 5,      code: 'LW',      name: '리니웍스'},
                     { id: 6,      code: 'FS',      name: '피버스튜디오'},
                     { id: 7,      code: 'LT',      name: '링크투머로우'}
                   ];
    
  //End Company ui select
    

  });
