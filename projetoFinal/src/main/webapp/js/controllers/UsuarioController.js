'use restrict'
function UsuarioController($scope, Usuario, $rootScope) {
    
    $scope.limpar = function () {
        $scope.usuario = {};
    };

    $scope.gravar = function () {

        if ($scope.usuario.dtCadastro) {
            $scope.usuario.dtCadastro = new Date($scope.usuario.dtCadastro).toISOString();
        }
        /*  if ($scope.usuario.id) {
         $scope.usuario.update().then(function () {
         $scope.mensagemOk = "Contato alterado com sucesso";
         $scope.limpar();
         $scope.listar();
         }, function (error) {
         $scope.mensagemErro = "Erro ao alterar contato";
         console.log('error', error);
         alert(error.data);
         });
         } else {*/
        new Usuario($scope.usuario).create()
                .then(function () {
                    $scope.msgOk = "Cadastro realizado com sucesso";
                    $scope.limpar();
                }, function (error) {
                    $scope.msgErro = "Erro ao efetuar cadastro";
                    console.log('error', error);
                });
        // }

    };

}

app.controller('UsuarioController', UsuarioController);

