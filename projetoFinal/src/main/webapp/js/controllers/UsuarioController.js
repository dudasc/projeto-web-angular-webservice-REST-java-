'use restrict'
function UsuarioController($scope, Usuario) {

    $scope.limpar = function () {
        $scope.usuario = {};
    };

    $scope.gravar = function () {
        var data = new Date();
        var dia = data.getDate();
        var mes = data.getMonth() + 1;
        var ano = data.getFullYear();
        var dataHoje = [ano, mes, dia].join('-');
        $scope.usuario.dtCadastro = dataHoje;

        new Usuario($scope.usuario).create()
                .then(function () {
                    $scope.msgOk = "Cadastro realizado com sucesso";
                    $scope.limpar();
                }, function (error) {
                    $scope.msgErro = "Erro ao efetuar cadastro";
                    alert($scope.usuario.nome);
                    console.log('error', error);
                });
    };

}

app.controller('UsuarioController', UsuarioController);

