'use strict';

/**
 * @ngdoc filter
 * @name wehrApp.filter:propsFilter
 * @function
 * @description
 * # propsFilter
 * Filter in the wehrApp.
 */
angular.module('wehrApp')
  .filter('propsFilter', function () {
    return function (input, props) {
    	 var out = new Array();
    	    if (angular.isArray(input)) {
    	      input.forEach(function(item) {
    	        var itemMatches = false;

    	        var keys = Object.keys(props);
    	        for (var i = 0; i < keys.length; i++) {
    	          var prop = keys[i];
    	          var text = props[prop].toLowerCase();
    	          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
    	            itemMatches = true;
    	            break;
    	          }
    	        }

    	        if (itemMatches) {
    	          out.push(item);
    	        }
    	      });
    	    } else {
    	      // Let the output be the input untouched
    	      out = input;
    	    }

    	    return out;
    };
  });
