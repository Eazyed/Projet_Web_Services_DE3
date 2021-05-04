package tse.de3.td_de3_soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetTeamRequest;
import io.spring.guides.gs_producing_web_service.GetTeamResponse;
import io.spring.guides.gs_producing_web_service.PostTeamRequest;
import io.spring.guides.gs_producing_web_service.PostTeamResponse;
import tse.de3.td_de3_soap.dao.TeamRepository;
import tse.de3.td_de3_soap.helper.TeamConversion;

@Endpoint
public class TeamEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private TeamRepository teamRepository;
	
	@Autowired
	public TeamEndpoint(TeamRepository TeamRepository) {
		this.teamRepository = TeamRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamRequest")
	@ResponsePayload
	public GetTeamResponse getTeamRequest(@RequestPayload GetTeamRequest request) {
		
		GetTeamResponse response = new GetTeamResponse();
		response.setTeam(TeamConversion.AsDto(this.teamRepository.findByName(request.getName())));
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postTeamRequest")
	@ResponsePayload
	public PostTeamResponse postTeamRequest(@RequestPayload PostTeamRequest request) {
		PostTeamResponse response = new PostTeamResponse();
		try {
			this.teamRepository.save(TeamConversion.AsModel(request.getTeam()));
			response.setStatus("OK");
		}
		catch (Exception e)
		{
			response.setStatus("Error : "+e.getMessage());
		}
		return response;		
	}
}
