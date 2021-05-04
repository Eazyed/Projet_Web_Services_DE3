package tse.de3.td_de3_soap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetPlayerRequest;
import io.spring.guides.gs_producing_web_service.GetPlayerResponse;
import io.spring.guides.gs_producing_web_service.GetTeamRequest;
import io.spring.guides.gs_producing_web_service.GetTeamResponse;
import io.spring.guides.gs_producing_web_service.PlayerDto;
import io.spring.guides.gs_producing_web_service.PostPlayerRequest;
import io.spring.guides.gs_producing_web_service.PostPlayerResponse;
import tse.de3.td_de3_soap.dao.PlayerRepository;
import tse.de3.td_de3_soap.dao.TeamRepository;
import tse.de3.td_de3_soap.helper.PlayerConversion;
import tse.de3.td_de3_soap.helper.TeamConversion;
import tse.de3.td_de3_soap.model.Player;
import tse.de3.td_de3_soap.model.Team;

@Endpoint
public class PlayerEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private PlayerRepository playerRepository;
	private TeamRepository teamRepository;
	
	@Autowired
	public PlayerEndpoint(PlayerRepository playerRepository, TeamRepository teamRepository) {
		this.playerRepository = playerRepository;
		this.teamRepository = teamRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerRequest")
	@ResponsePayload
	public GetPlayerResponse getPlayerRequest(@RequestPayload GetPlayerRequest request) {
		
		GetPlayerResponse response = new GetPlayerResponse();
		try {
			String name = request.getName();
			Player player = this.playerRepository.findByName(name);
			PlayerDto playerDto = PlayerConversion.AsDto(player);
			
			response.setPlayer(playerDto);
			
		}catch(Exception e) {
			;
		}
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postPlayerRequest")
	@ResponsePayload
	public PostPlayerResponse postPlayerRequest(@RequestPayload PostPlayerRequest request) {
		PostPlayerResponse response = new PostPlayerResponse();
		try {
			this.playerRepository.save(PlayerConversion.AsModel(request.getPlayer()));
			response.setStatus("OK");
		}
		catch (Exception e)
		{
			response.setStatus("Error : "+e.getMessage());
		}
		return response;		
	}
}
