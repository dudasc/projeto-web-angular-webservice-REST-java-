'use restrict'

function HomeController($scope){}

function HomeRoute($stateProvider) {
    $stateProvider.state('home', {
        url: '/home',
        templateUrl: 'js/views/home.html',
        controller: 'HomeController'
    });
}

app.config(HomeRoute)
        .controller('HomeController', HomeController);
