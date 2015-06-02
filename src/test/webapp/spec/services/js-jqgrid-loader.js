'use strict';

describe('Service: jsJqgridLoader', function () {

  // load the service's module
  beforeEach(module('wehrApp'));

  // instantiate service
  var jsJqgridLoader;
  beforeEach(inject(function (_jsJqgridLoader_) {
    jsJqgridLoader = _jsJqgridLoader_;
  }));

  it('should do something', function () {
    expect(!!jsJqgridLoader).toBe(true);
  });

});
