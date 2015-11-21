'use strict'
//liga o back end com o front-end passando a url do rest


app.factory('Agenda',
        function (railsResourceFactory, API_URL) {           

            var Servico = railsResourceFactory({
                url: API_URL + 'agendamentos'
            });
            
            return Servico;
        });