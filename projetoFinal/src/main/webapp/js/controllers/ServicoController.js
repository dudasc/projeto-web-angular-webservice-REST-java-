'use restrict'

function ServicoController($scope) {
}

function ServicoRoute($stateProvider) {
    $stateProvider.state(
        'listaServicos', {
            url: '/listaServicos',
            templateUrl: 'js/views/listaServicos.html',
            //controller: 'ServicoController'
        });
        
        $stateProvider.state('cadastroCategoria', {
            url: '/cadastroCategoria',
            templateUrl: 'js/views/cadastroCategoria.html',
            //controller: 'ServicoController'
        });
        
        $stateProvider.state('cadastroServico', {
            url: '/cadastroServico',
            templateUrl: 'js/views/cadastroServico.html',
            //controller: 'ServicoController'
        });
}

app.config(ServicoRoute)
        .controller('ServicoController', ServicoController);
