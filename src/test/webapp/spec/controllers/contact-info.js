'use strict';

describe('Controller: ContactInfoCtrl', function () {

  // load the controller's module
  beforeEach(module('wehrApp'));

  var ContactInfoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ContactInfoCtrl = $controller('ContactInfoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
