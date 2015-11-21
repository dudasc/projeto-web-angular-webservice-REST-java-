'use restrict'

function ServicoController($scope) {

    $scope.limpar = function () {
        $scope.servico = {};
    };

    $scope.listar = function () {
        Servico.query().then(function (data) {
            $scope.listaServico = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    if ($scope.servico.id) {
        $scope.servico.update().then(function () {
            $scope.msgOk = "Contato alterado com sucesso";
            $scope.limpar();
            $scope.listar();
        }, function (error) {
            $scope.msgErro = "Erro ao alterar contato";
            console.log('error', error);
            alert(error.data);
        });
    } else {
        new Servico($scope.servico).create()
                .then(function () {
                    $scope.msgOk = "Cadastro realizado com sucesso";
                    $scope.limpar();
                }, function (error) {
                    $scope.msgErro = "Erro ao efetuar cadastro";
                    console.log('error', error);
                });
    }
    
    limpar();
    listar();
    
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
