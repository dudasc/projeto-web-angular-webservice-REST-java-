'use restrict'

function AgendaController($scope){}

function AgendaRoute($stateProvider) {
    $stateProvider.state('listaAgenda', {
        url: '/listaAgenda',
        templateUrl: 'js/views/listaAgenda.html',
        controller: 'AgendaController'
    });
}

app.config(AgendaRoute)
        .controller('AgendaController', AgendaController);
