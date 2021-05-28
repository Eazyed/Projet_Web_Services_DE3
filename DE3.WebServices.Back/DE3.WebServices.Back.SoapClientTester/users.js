let soap = require('strong-soap').soap;

var url = 'http://localhost:8092/ws/users.wsdl';

let options = {};

soap.createClient(
    url, 
    options, 
    function(err, client) {
        if(!err){
            let soapRequestParam = {
                authenticateUserRequest: {
                    login: 'jean.pal',
                    password: 'motdepasse'
                }
            };

            client.authenticateUser(
                soapRequestParam, 
                function(err, result, envelope, soapHeader) {

                    console.log(result);
                }
            );
        } else {
            console.error(err);
        }
    }
);