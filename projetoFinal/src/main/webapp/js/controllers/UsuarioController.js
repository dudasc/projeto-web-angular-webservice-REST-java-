function UsuarioController($scope, Usuario){
    $scope.gravar = function () {
        if ($scope.usuario.dataNascimento) {
            $scope.usuario.dataNascimento = new Date($scope.usuario.dataNascimento).toISOString();
        }
        if ($scope.usuario.id) {
            $scope.usuario.update().then(function () {
                $scope.mensagemOk = "Contato alterado com sucesso";
                $scope.limpar();
                $scope.listar();
            }, function (error) {
                $scope.mensagemErro = "Erro ao alterar contato";
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Usuario($scope.usuario).create()
                    .then(function () {
                        $scope.mensagemOk = "Cadastro realizado com sucesso";
                        $scope.limpar();
                        $scope.listar();
                    }, function (error) {
                        $scope.mensagemErro = "Erro ao efetuar cadastro";
                        console.log('error', error);
                        alert(error.data);
                    });
        }
    };
}

app.controller('UsuarioController', UsuarioController);

