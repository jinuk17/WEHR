'use strict';

/**
 * @ngdoc directive
 * @name wehrApp.directive:jsJqGrid
 * @description
 * # jsJqGrid
 */
angular.module('wehrApp')
  .directive('jsJqGrid', ["$log", "$parse", "jsJqGridLoader", function ($log, $parse, jsJqGridLoader) {
	  var link = function(scope, element, attrs, gridCrtl){
		  var gridElement, alias, options;
		  gridElement = element.find("table.jsJqGrid");
		  alias = attrs.gridName;
		  if(alias){
			  $parse(alias).assign(scope, gridCrtl);
		  }
		  
		  options = $parse(attrs.gridController)(scope);
		  
		    if (!options) {
                throw new Error("undefined grid options");
            }
		    
		    if (attrs.gridColumnModel) {
                options.colModel = angular.fromJson(attrs.gridColumnModel);
            }
		    
		    scope.$on("$destroy", function() {
                $log.debug("[jsJqGrid] destroying the grid", gridElement);
                return gridElement.jqGrid("GridDestroy");
            });
		  
		    init = function(){
		    	
		    	var onGridComplete, _gridComplete;
		    	
		    	$log.debug("[jsJqGrid] initalizing '" + alias + "' with", options);
		    	
		    	if(options.url == null && options.path != null){
		    		options.url = pathWithContext(options.path);
		    	}
		    	
		    	if(options.datatype === undefined || options.datatype === null){
		    		options.data = jsJqGridLoader(options.url, gridCrtl);
		    	}
		    	
		    	if(options.pager !== false){
		    		options.pager = element.find(".jsJqGrid-pager").attr("id") || "jsJqGrid-pager";
		    	}
		    	
		    	if(options.selectFirstRow === true){
		    		_gridComplete = options.gridComplete;
		    		onGridComplete = function(){
		    			var dataIds;
		    			dataIds = gridElement.getDataIDs();
		    			if(dataIds.length > 0){
		    				gridElement.setSelection(dataIds[0], true);
		    			}
		    			if(_.isFunction(_gridComplete)){
		    				return _gridComplete;
		    			}
		    		};
		    		options.gridComplete = onGridComplete;
		    	}
		    	
		    };
	  };
    return {
      template: "<table class='jsJqGrid'></table>" +
      			"<div class='jsJqGrid-pager'></div>",
      restrict: 'E',
      require: 'gridController',
      controller:'JsJqgridControllerCtrl',
      compile: function(element, attrs){
    	  var id;
    	  id = attrs.gridNmae != null ? attrs.gridNmae : "jsJqGrid";
    	  element.find("table.jsJqGrid").attr("id", id);
    	  element.find("div.jsJqGrid-pager").attr("id", id+"-pager");
    	  return {
    		  post: link
    	  };
      }
    };
  }]);
