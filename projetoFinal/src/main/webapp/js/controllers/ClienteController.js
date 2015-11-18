'use restrict'

function ClienteController($scope, Cliente) {
    
    $scope.gravar = function () {
    
   // if ($scope.cliente.dtCadastro) {
       //     $scope.cliente.dtCadastro = new Date($scope.cliente.dtCadastro).toISOString();
      //  }
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


