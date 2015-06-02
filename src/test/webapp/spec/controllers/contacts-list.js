'use strict';

describe('Controller: ContactsListCtrl', function () {

  // load the controller's module
  beforeEach(module('wehrApp'));

  var ContactsListCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ContactsListCtrl = $controller('ContactsListCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
