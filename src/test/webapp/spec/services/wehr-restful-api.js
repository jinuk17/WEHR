'use strict';

describe('Service: wehrRestfulApi', function () {

  // load the service's module
  beforeEach(module('wehrApp'));

  // instantiate service
  var wehrRestfulApi;
  beforeEach(inject(function (_wehrRestfulApi_) {
    wehrRestfulApi = _wehrRestfulApi_;
  }));

  it('should do something', function () {
    expect(!!wehrRestfulApi).toBe(true);
  });

});
