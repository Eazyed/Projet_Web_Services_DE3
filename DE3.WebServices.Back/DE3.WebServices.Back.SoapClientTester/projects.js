let soap = require('strong-soap').soap;

var url = 'http://localhost:8091/ws/projects.wsdl';

let options = {};

soap.createClient(
    url, 
    options, 
    function(err, client) {
        if(!err){
            let soapRequestParam = {
                getAllProjectsRequest: {
                }
            };

            client.getAllProjects(
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