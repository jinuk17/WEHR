'use strict';

/**
 * @ngdoc overview
 * @name wehrApp
 * @description
 * # wehrApp
 *
 * Main module of the application.
 */

var wehrApp = angular
.module('wehrApp', [
  'ngAnimate',
  'ngCookies',
  'ngResource',
  'ngRoute',
  'ngSanitize',
  'ui.bootstrap',
  'ui.router',
  'gettext',
  'gettext_translation',
  'ui.grid',
  'ui.grid.pagination',
  'ui.grid.autoResize',
  'ui.select',
  'angularTreeview',
  'ui.tree'
])
.config(['$locationProvider', '$stateProvider', '$urlRouterProvider',
         function ($locationProvider, $stateProvider, $urlRouterProvider) {
	  $locationProvider.html5Mode(false).hashPrefix(''); // hashbang mode - could use other modes (html5 etc)
	  
	  $urlRouterProvider.otherwise('/');
	  $stateProvider
	  .state("main", {
		  url : "/", 
		  templateUrl: 'views/main.html',
		  controller: 'MainCtrl'
	  }).state("login", {
		  url : "/login", 
		  templateUrl: 'views/login.html',
		  controller: 'LoginCtrl'
	  }).state("contactsList", {
		  url : "/contactsList", 
		  templateUrl: 'views/contactsList.html',
		  controller: 'ContactsListCtrl'
	  }).state("contactUpload", {
		  url : "/contactUpload", 
		  templateUrl: 'views/contactUpload.html',
		  controller: 'ContactUploadCtrl'
	  }).state("contactInfo", {
		  url : "/contactInfo/{userId:[0-9]{1,4}}",
		  templateUrl: 'views/contactInfo.html',
		  controller: 'ContactInfoCtrl'
	  }).state("jqGrid", {
		  url : "/jqGrid", 
		  templateUrl: 'views/jqGrid.html',
		  controller: 'JqgridTestCtrl'
	  });
}])
.run(['$rootScope', '$state', '$stateParams', 'gettextCatalog', 
      function ($rootScope, $state, $stateParams, gettextCatalog) {
			
	$rootScope.$state = $state;
	
	$rootScope.$stateParams = $stateParams;
	
	$rootScope.setLang = function(lang, isDebug) {
		if(lang) {
			gettextCatalog.currentLanguage = lang;
		} else {
			gettextCatalog.currentLanguage = 'ko_KR';
		}
		gettextCatalog.debug = isDebug;
	};
	$rootScope.setLang('ko_KR', true);
	
}]);
