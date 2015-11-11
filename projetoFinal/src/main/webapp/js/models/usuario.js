'use strict'
//liga o back end com o front-end passando a url do rest


app.module('usuario')
        .factory('Usuario',
                function (railsResourceFactory, API_URL) {
                    var Contato = railsResourceFactory({
                        url: API_URL + 'usuario'
                    });

                    return Usuario;
                });