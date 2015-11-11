'use strict';

//declara os modulos que serão utilizados na aplicação
//declara os modulos que serão utilizados na aplicação
var app = angular.module('app', [
    'ui.router'
]).config(function ($urlRouterProvider) {
    
        $urlRouterProvider.otherwise('/home');
        /*
    $urlRouterProvider.when('/login', {
        templateUrl: "views/home.html",
        controller: "HomeController"
    });*/

});