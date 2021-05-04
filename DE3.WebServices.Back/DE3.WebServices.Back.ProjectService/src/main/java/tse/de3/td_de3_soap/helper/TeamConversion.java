package tse.de3.td_de3_soap.helper;

import io.spring.guides.gs_producing_web_service.TeamDto;
import tse.de3.td_de3_soap.model.Team;

public class TeamConversion {
	public static Team AsModel(TeamDto dto) {
		Team team = new Team();
		team.setMainColour(dto.getMainColour());
		team.setName(dto.getName());
		return team;
	}
	
	public static TeamDto AsDto(Team team) {
		TeamDto dto = new TeamDto();
		dto.setMainColour(team.getMainColour());
		dto.setName(team.getName());
		return dto;
	}
}
