'use strict'
//liga o back end com o front-end passando a url do rest


app.factory('Servico',
        function (railsResourceFactory, API_URL) {           

            var Servico = railsResourceFactory({
                url: API_URL + 'servicos'
            });
            
            return Servico;
        });