// Karma configuration
// http://karma-runner.github.io/0.12/config/configuration-file.html
// Generated on 2015-02-26 using
// generator-karma 0.9.0

module.exports = function(config) {
  'use strict';

  config.set({
    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,

    // base path, that will be used to resolve files and exclude
    basePath: '../../',

    // testing framework to use (jasmine/mocha/qunit/...)
    frameworks: ['jasmine'],

    // list of files / patterns to load in the browser
    files: [
      // bower:js
      '../main/webapp/components/modernizr/modernizr.js',
      '../main/webapp/components/es5-shim/es5-shim.js',
      '../main/webapp/components/jquery/dist/jquery.js',
      '../main/webapp/components/angular/angular.js',
      '../main/webapp/components/bootstrap/dist/js/bootstrap.js',
      '../main/webapp/components/angular-animate/angular-animate.js',
      '../main/webapp/components/angular-cookies/angular-cookies.js',
      '../main/webapp/components/angular-resource/angular-resource.js',
      '../main/webapp/components/angular-route/angular-route.js',
      '../main/webapp/components/angular-sanitize/angular-sanitize.js',
      '../main/webapp/components/angular-bootstrap/ui-bootstrap-tpls.js',
      '../main/webapp/components/json3/lib/json3.js',
      '../main/webapp/components/angular-ui-router/release/angular-ui-router.js',
      '../main/webapp/components/angular-gettext/dist/angular-gettext.js',
      '../main/webapp/components/jqgrid/js/i18n/grid.locale-en.js',
      '../main/webapp/components/jqgrid/js/jquery.jqGrid.js',
      '../main/webapp/components/jquery-ui/jquery-ui.js',
      '../main/webapp/components/underscore/underscore.js',
      '../main/webapp/components/jasny-bootstrap/dist/js/jasny-bootstrap.js',
      '../main/webapp/components/angular-ui-select/dist/select.js',
      '../main/webapp/components/select2/select2.js',
      '../main/webapp/components/angular-ui-grid/ui-grid.js',
      '../main/webapp/components/angular-ui-tree/dist/angular-ui-tree.js',
      '../main/webapp/components/angular-mocks/angular-mocks.js',
      // endbower
      'src/main/webapp/scripts/**/*.js',
      'src/test/webapp/mock/**/*.js',
      'src/test/webapp/spec/**/*.js'
    ],

    // list of files / patterns to exclude
    exclude: [
    ],

    // web server port
    port: 8080,

    // Start these browsers, currently available:
    // - Chrome
    // - ChromeCanary
    // - Firefox
    // - Opera
    // - Safari (only Mac)
    // - PhantomJS
    // - IE (only Windows)
    browsers: [
      'PhantomJS'
    ],

    // Which plugins to enable
    plugins: [
      'karma-phantomjs-launcher',
      'karma-jasmine'
    ],

    // Continuous Integration mode
    // if true, it capture browsers, run tests and exit
    singleRun: false,

    colors: true,

    // level of logging
    // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
    logLevel: config.LOG_INFO,

    // Uncomment the following lines if you are using grunt's server to run the tests
    // proxies: {
    //   '/': 'http://localhost:9000/'
    // },
    // URL root prevent conflicts with the site root
    // urlRoot: '_karma_'
  });
};
