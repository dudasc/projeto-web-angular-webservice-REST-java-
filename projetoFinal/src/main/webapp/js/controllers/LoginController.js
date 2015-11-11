'use strict';

function LoginController($scope) {
    $scope.mensagem;
}


function LoginRoute($stateProvider) {
    $stateProvider.state('login', {
        url: '/login',
        templateUrl: 'js/views/login.html',
        controller: 'LoginController'
    });
}


app.config(LoginRoute)
        .controller('LoginController', LoginController);

