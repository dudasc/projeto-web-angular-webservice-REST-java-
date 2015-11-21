'use restrict'

function CategoriaController($scope, Categoria) {
    
    $scope.limpar = function () {
        $scope.categoria = {};
    };

    $scope.listar = function () {
        Categoria.query().then(function (data) {
            $scope.listaCategorias = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    
    $scope.gravar = function () {
        new Categoria($scope.categoria).create()
                .then(function () {
                    $scope.msgOk = "Cadastro realizado com sucesso";
                    //$scope.limpar();
                }, function (error) {
                    $scope.msgErro = "Erro ao efetuar cadastro";
                    console.log('error', error);
                });
    };
    
    $scope.limpar();
    $scope.listar();
}
app.controller('CategoriaController', CategoriaController);
