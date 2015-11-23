'use restrict'

function ServicoController($scope, Servico,Categoria) {
   
    $scope.limpar = function () {
        $scope.servico = {};
    };
    
   // $scope.listaCategorias = Categoria.listar(); 
   
    
    //lista as categorias para colocar no menu select
    $scope.listarCategorias = function () {
        Categoria.query().then(function (data) {
            $scope.listaCategoriasSelect = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
            
    $scope.listar = function () {
        Servico.query().then(function (data) {
            $scope.listaServicos = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    $scope.gravar = function () {
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
    };
    $scope.deletar = function (servico, confirmation) {

        confirmation = (typeof confirmation !== 'undefined') ? confirmation : true;
        if (confirmDelete(confirmation)) {
            servico.remove().then(function () {
                $scope.msgOk = "Excluído com sucesso";
                $scope.listar();
            }, function (error) {
                $scope.msgErro = "Erro ao excluir contato";
                console.log('error', error);
                alert(error.data);
            });
        }
    };

    var confirmDelete = function (confirmation) {
        return confirmation ? confirm('Deseja excluir?') : true;
    };
    
    $scope.listarCategorias();
    $scope.limpar();
    $scope.listar();
}

function ServicoRoute($stateProvider) {
    $stateProvider.state(
            'listaServicos', {
                url: '/listaServicos',
                templateUrl: 'js/views/listaServicos.html',
                controller: 'ServicoController'
            });
    $stateProvider.state('cadastroCategoria', {
        url: '/cadastroCategoria',
        templateUrl: 'js/views/cadastroCategoria.html',
        controller: 'ServicoController'
    });
    $stateProvider.state('cadastroServico', {
        url: '/cadastroServico',
        templateUrl: 'js/views/cadastroServico.html',
        controller: 'ServicoController'
    });
}

app.config(ServicoRoute)
        .controller('ServicoController', ServicoController);
