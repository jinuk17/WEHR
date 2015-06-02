'use strict';

/**
 * @ngdoc function
 * @name wehrApp.controller:ContactsListCtrl
 * @description
 * # ContactsListCtrl
 * Controller of the wehrApp
 */
angular.module('wehrApp')
  .controller('ContactsListCtrl',['$scope', 'personService', 'uiGridConstants', '$modal','$log', 
                                  function ($scope, personService, uiGridConstants, $modal, $log) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    
    //Start Company ui select
    
    $scope.companies = [
                     { id: 1,      code: 'WE',      name: '위메이드엔터테이먼트'},
                     { id: 2,      code: 'WC',      name: '위메이드크리에이티브'},
                     { id: 3,      code: 'JM',      name: '조이맥스'},
                     { id: 4,      code: 'IO',      name: '아이오엔터테이먼트'},
                     { id: 5,      code: 'LW',      name: '리니웍스'},
                     { id: 6,      code: 'FS',      name: '피버스튜디오'},
                     { id: 7,      code: 'LT',      name: '링크투머로우'}
                   ];
    $scope.company = {selected :$scope.companies[0]};
    
    $scope.$watch('company.selected', function( newObj, oldObj ) {
    	 personService.departmentTree($scope.company.selected.id, function(data){
    	    	$scope.treedata = data;
    	    	$scope.deptTree.currentNode = data[0];
    	    	$scope.deptTree.currentNode.selected = 'selected';
    	 });
    });
  
  //End Company ui select
    
  //Start Department treeview
   
    $scope.$watch( 'deptTree.currentNode', function( newObj, oldObj ) {
    	if( $scope.deptTree && angular.isObject($scope.deptTree.currentNode) ) {
    		paginationOptions.departmentId = $scope.deptTree.currentNode.id;
    		getPage();
    		}
    	}, false);
    
    
    $scope.currentNode = {};
    $scope.selectNode = function(node){
		if( $scope.currentNode && $scope.currentNode.selected ) {
			$scope.currentNode.selected = undefined;
		}
		alert(node.name);
		//set highlight to selected node
		node.selected = 'selected';

		//set currentNode
		$scope.currentNode = node;
    };
    	
  //End Department treeview
    
  //Start Employee Grid
    var paginationOptions = {
    		pageNumber : 1,
    		pageSize : 25,
    		sort : {
    					column : null,
    					direction : null
    				},
    		departmentId : null
    };
    
    var getPage = function(){
    	personService.list(paginationOptions, function(data){
    		$scope.gridOptions.totalItems = data.total;
    		$scope.gridOptions.data = data.rows;
    		resizeGrid(data.rows.length);
    	});
    };
    
    var resizeGrid = function(rows){
    	var newHeight =paginationOptions.pageSize*$scope.gridOptions.rowHeight+80;
        angular.element(document.getElementsByClassName('grid')[0]).css('height', newHeight + 'px');
    	//$scope.gridStyle = 'height:'+(paginationOptions.pageSize*$scope.gridOptions.rowHeight+80)+'px;';
    };
    $scope.gridOptions = {
    		paginationPageSizes : [25, 50, 75, 100],
    		paginationPageSize : 25,
    		rowHeight : 25,
    		//enableHorizontalScrollbar: uiGridConstants.scrollbars.NEVER,
    		enablePaginationControls: true,
    		useExternalPagination : true,
    		useExternalSorting : true,
    		enableSorting : true,
    		columnDefs : [
    		              { field: 'id' , width:100},
    		              { field: 'issueDt' , width:100},
    		              { field: 'retireDt' , width:100},
    		              { field: 'code' , width:100},
    		              { field: 'personDto.name' , width:100},
    		              { field: 'departments[0].code' , width:100},
    		              { field: 'departments[0].name' , width:100},
    		              { field: 'act' , width:100},
    		              { field: 'mail' , width:100},
    		              { field: 'tel' , width:100},
    		              { field: 'personDto.hp' , width:100},
    		              { field: 'gradeName' , width:100},
    		              { field: 'dutyDto.code' , width:100},
    		              { field: 'dutyDto.name' , width:100},
    		              { field: 'empType' , width:100}
    		              ],
    		onRegisterApi : function(gridApi){
    			$scope.gridApi = gridApi;
    			$scope.gridApi.core.on.sortChanged($scope, function(grid, sortColumns){
    				if(sortColumns.length == 0){
    					paginationOptions.sort.column = null;
    					paginationOptions.sort.direction = null;
    				}else{
    					paginationOptions.sort.column = sortColumns[0].field;
    					paginationOptions.sort.direction = sortColumns[0].sort.direction;
    				}
    				getPage();
    			});
    			gridApi.pagination.on.paginationChanged($scope, function(newPage, pageSize){
    				paginationOptions.pageNumber = newPage;
    				paginationOptions.pageSize = pageSize;
    				getPage();
    			});
    		}
    };
    
    //End Employee Grid
    
    
    //Start Employee Info Modal
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
        var modalInstance = $modal.open({
        	templateUrl: 'views/contactInfo.html',
        	controller: 'ContactInfoCtrl',
        	backdrop : 'static',
        	size: size,
        	resolve: {
        		items: function () {
        			return $scope.items;
        		}
        	}
        });

        modalInstance.result.then(function (selectedItem) {
          $scope.selected = selectedItem;
        }, function () {
          $log.info('Modal dismissed at: ' + new Date());
        });
      };
      //End Employee Info Modal

  }]);
