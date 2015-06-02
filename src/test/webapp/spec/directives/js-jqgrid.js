'use strict';

describe('Directive: jsJqGrid', function () {

  // load the directive's module
  beforeEach(module('wehrApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<js-jq-grid></js-jq-grid>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the jsJqGrid directive');
  }));
});
