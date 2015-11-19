'use restrict'

function ClienteController($scope, Cliente) {
    $scope.limpar = function () {
        $scope.cliente = {};
    };


    $scope.listar = function () {
        Cliente.query().then(function (data) {
            $scope.listaClientes = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    $scope.gravar = function () {

        // if ($scope.cliente.dtCadastro) {
        //     $scope.cliente.dtCadastro = new Date($scope.cliente.dtCadastro).toISOString();
        //  }
        if ($scope.cliente.id) {
            $scope.cliente.update().then(function () {
                $scope.msgOk = "Contato alterado com sucesso";
                $scope.limpar();
                $scope.listar();
            }, function (error) {
                $scope.msgErro = "Erro ao alterar contato";
                console.log('error', error);
                alert(error.data);
            });
        } else {
            alert($scope.cliente.endereco.pais);
            new Cliente($scope.cliente).create()
                    .then(function () {
                        $scope.msgOk = "Cadastro realizado com sucesso";
                        //$scope.limpar();
                    }, function (error) {
                        $scope.msgErro = "Erro ao efetuar cadastro";

                        console.log('error', error);
                    });
        }
    };
    $scope.limpar();
    $scope.listar();



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


