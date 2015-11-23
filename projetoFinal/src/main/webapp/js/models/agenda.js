'use strict'
//liga o back end com o front-end passando a url do rest


app.factory('Agenda',
        function (railsResourceFactory, API_URL) {           

            var Agenda = railsResourceFactory({
                url: API_URL + 'agendamentos'
            });
            
            return Agenda;
        });