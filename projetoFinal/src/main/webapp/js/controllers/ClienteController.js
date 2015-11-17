'use restrict'

function ClienteController($scope) {
    
     
}

function HomeRoute($stateProvider) {
    $stateProvider.state('listaClientes', {
        url: '/listaClientes',
        templateUrl: 'js/views/listaClientes.html',
        controller: 'ClienteController'
    });
    
    $stateProvider.state('cadastroCliente', {
        url: '/cadastroCliente',
        templateUrl: 'js/views/cadastroCliente.html',
        controller: 'ClienteController'
    });

}

app.config(HomeRoute)
        .controller('ClienteController', ClienteController);
