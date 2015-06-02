'use strict';

/**
 * @ngdoc directive
 * @name wehrApp.directive:testBtn
 * @description
 * # testBtn
 */
angular.module('wehrApp')
  .directive('testBtn', function () {
    return {
    	templateUrl:'views/test.html',
    	restrict: 'E',
    	replace: true,
    	transclude: true, 
    	//require: "mainCtrl",
    	controller:"MainCtrl",
    	scope:{
    		title: '@',
    		onOk: '&',
    		onCancel: '&',
    		visible: '='
    	},
    	link : function(scope, element, attrs, mainCtrl){
    		alert("AAA");
    		localAlert("AAA");
    	}
    };
});
