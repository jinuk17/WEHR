'use strict';

describe('Controller: JsJqgridControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('wehrApp'));

  var JsJqgridControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    JsJqgridControllerCtrl = $controller('JsJqgridControllerCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
