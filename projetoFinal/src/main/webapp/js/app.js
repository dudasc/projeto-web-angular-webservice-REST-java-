'use strict';

//declara os modulos que serão utilizados na aplicação
//declara os modulos que serão utilizados na aplicação
var app = angular.module('app', [
     //'ngRoute',
    'ui.router',
    'ui.bootstrap',
    'rails'
   
]).config(function ($urlRouterProvider, RailsResourceProvider, railsSerializerProvider) {

    /* $routeProvider

            // utilizando o ngRoute:
            // para a rota '/', carregaremos o template home.html e o controller 'HomeCtrl'
           .when('/cadastroCliente', {
                templateUrl: 'js/views/cadastroCliente.html',
                controller: 'ClienteController'
            })
            .when('/listaClientes', {
                templateUrl: 'js/views/listaClientes.html',
                controller: 'ClienteController'
            })

            .otherwise('/home');*/

    //$urlRouterProvider.when('', '/');
    $urlRouterProvider.otherwise('/listaAgenda');
    RailsResourceProvider.rootWrapping(false);
    railsSerializerProvider.underscore(angular.identity).camelize(angular.identity);
}).constant('API_URL', 'api/');





/*
 
 angular.module('contatos', [
 'ui.router',
 'ui.bootstrap',
 'rails'
 ]).config(function ($urlRouterProvider, RailsResourceProvider, railsSerializerProvider) {
 $urlRouterProvider.when('', '/');
 $urlRouterProvider.otherwise('/error?code=404');
 RailsResourceProvider.rootWrapping(false);
 railsSerializerProvider.underscore(angular.identity).camelize(angular.identity);
 }).constant('API_URL', 'api/');
 */