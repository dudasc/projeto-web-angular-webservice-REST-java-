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

        if ($scope.cliente.dtCadastro) {
            $scope.cliente.dtCadastro = new Date($scope.cliente.dtCadastro).toISOString();
        }
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

    $scope.editar = function (cliente) {
        $scope.cliente = angular.copy(cliente);
    };

    $scope.deletar = function (cliente, confirmation) {

        confirmation = (typeof confirmation !== 'undefined') ? confirmation : true;
        if (confirmDelete(confirmation)) {
            cliente.remove().then(function () {
                $scope.mensagemOk = "Contato Excluído com sucesso";
                $scope.listar();
            }, function (error) {
                $scope.mensagemErro = "Erro ao excluir contato";
                console.log('error', error);
                alert(error.data);
            });
        }
    };

    var confirmDelete = function (confirmation) {
        return confirmation ? confirm('Deseja excluir o contato?') : true;
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


