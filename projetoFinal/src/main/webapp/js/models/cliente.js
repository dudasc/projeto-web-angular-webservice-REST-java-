'use strict'
//liga o back end com o front-end passando a url do rest


app.factory('Cliente',
        function (railsResourceFactory, API_URL) {           

            var Cliente = railsResourceFactory({
                url: API_URL + 'clientes'
            });
            
            return Cliente;
        });