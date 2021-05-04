package tse.de3.td_de3_soap.helper;

import io.spring.guides.gs_producing_web_service.PlayerDto;
import tse.de3.td_de3_soap.model.Player;

public class PlayerConversion {
	public static Player AsModel(PlayerDto dto) {
		
		Player player = new Player();
		player.setName(dto.getName());
		player.setRole(dto.getRole());
		player.setTeam(TeamConversion.AsModel(dto.getTeam()));
		return player;
		
	}
	
	public static PlayerDto AsDto(Player player) {
		
		PlayerDto dto = new PlayerDto();
		dto.setName(player.getName());
		dto.setRole(player.getRole());
		return dto;
		
	}
}
