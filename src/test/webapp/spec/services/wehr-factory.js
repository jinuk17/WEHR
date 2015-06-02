'use strict';

describe('Service: wehrFactory', function () {

  // load the service's module
  beforeEach(module('wehrApp'));

  // instantiate service
  var wehrFactory;
  beforeEach(inject(function (_wehrFactory_) {
    wehrFactory = _wehrFactory_;
  }));

  it('should do something', function () {
    expect(!!wehrFactory).toBe(true);
  });

});
