'use restrict'

function AgendaController($scope) {
  /*  $scope.limpar = function () {
        $scope.agenda = {};
    };

    $scope.listar = function () {
        Agenda.query().then(function (data) {
            $scope.listaAgendamento = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.gravar = function () {

        if ($scope.agenda.id) {
            $scope.agenda.update().then(function () {
                $scope.msgOk = "Agenda alterada com sucesso";
                $scope.limpar();
                $scope.listar();
            }, function (error) {
                $scope.msgErro = "Erro ao alterar agenda";
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Agenda($scope.agenda).create()
                    .then(function () {
                        $scope.msgOk = "Cadastro realizado com sucesso";
                        //$scope.limpar();
                    }, function (error) {
                        $scope.msgErro = "Erro ao efetuar cadastro";
                        console.log('error', error);
                    });
        }
    };

    $scope.editar = function (agenda) {
        $scope.agenda = angular.copy(agenda);
    };

    $scope.deletar = function (agenda, confirmation) {
        confirmation = (typeof confirmation !== 'undefined') ? confirmation : true;
        if (confirmDelete(confirmation)) {
            agenda.remove().then(function () {
                $scope.mensagemOk = "Agendamento Excluído com sucesso";
                $scope.listar();
            }, function (error) {
                $scope.mensagemErro = "Erro ao excluir agendamento";
                console.log('error', error);
                alert(error.data);
            });
        }
    };

    var confirmDelete = function (confirmation) {
        return confirmation ? confirm('Deseja excluir o agendamento selecionado?') : true;
    };
*/

  //  $scope.limpar();
    //$scope.listar();
}

function AgendaRoute($stateProvider) {
    $stateProvider.state('listaAgenda', {
        url: '/listaAgenda',
        templateUrl: 'js/views/listaAgenda.html',
       // controller: 'AgendaController'
    });
}

app.config(AgendaRoute)
        .controller('AgendaController', AgendaController);
