'use strict'
//liga o back end com o front-end passando a url do rest


app.factory('Categoria',
        function (railsResourceFactory, API_URL) {

            var Categoria = railsResourceFactory({
                url: API_URL + 'categorias'
            });

            return Categoria;
        });