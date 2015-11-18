'use restrict'
function UsuarioController($scope, Usuario, $rootScope) {
    
    $scope.limpar = function () {
        $scope.usuario = {};
    };

    $scope.gravar = function () {
        
        
  
        var data = new Date();
        var dia = data.getDate();
        var mes = data.getMonth() + 1;
        var ano = data.getFullYear();
        var dataHoje = [ano, mes, dia].join('-');

       // if ($scope.usuario.dtCadastro) {
            $scope.usuario.dtCadastro = dataHoje;
        //}
        alert($scope.usuario.dtCadastro);
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
                    alert($scope.usuario.nome);
                    console.log('error', error);
                });
        // }

    };

}

app.controller('UsuarioController', UsuarioController);

