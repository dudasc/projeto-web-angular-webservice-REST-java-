'use strict';

//declara os modulos que serão utilizados na aplicação
//declara os modulos que serão utilizados na aplicação
var app = angular.module('app', [
    'ui.router',
    'rails'
]).config(function ($urlRouterProvider, RailsResourceProvider, railsSerializerProvider) {
    //$urlRouterProvider.when('', '/');
    $urlRouterProvider.otherwise('/home');
    RailsResourceProvider.rootWrapping(false);
    railsSerializerProvider.underscore(angular.identity).camelize(angular.identity);
}).constant('API_URL', 'api/');