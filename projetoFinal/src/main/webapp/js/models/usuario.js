'use strict'
//liga o back end com o front-end passando a url do rest


app.factory('Usuario',
        function (railsResourceFactory, API_URL) {           

            var Usuario = railsResourceFactory({
                url: API_URL + 'usuarios'
            });
            
            return Usuario;
        });