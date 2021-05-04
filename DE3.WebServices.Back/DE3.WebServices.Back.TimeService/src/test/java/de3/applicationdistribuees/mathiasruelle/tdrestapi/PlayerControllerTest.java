package de3.applicationdistribuees.mathiasruelle.tdrestapi;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import org.hamcrest.Matchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PlayerControllerTest {
	
//	@Autowired
//	private MockMvc mvc;
//	
//	@Autowired
//	private PlayerRepository playerRepository;
//	
//	@Autowired
//	private TeamRepository teamRepository;
//
//	@Test
//	public void testAll() throws Exception {
//		Team team = new Team("ASSE","vert");
//		Player player = new Player("Marky Mark","Striker",null);
//		ObjectMapper mapper = new ObjectMapper();
//		byte[] teamAsBytes = mapper.writeValueAsBytes(team);
//		byte[] playerAsBytes = mapper.writeValueAsBytes(player);
//		mvc.perform(
//				MockMvcRequestBuilders
//				.post("/team/save")
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON).content(teamAsBytes))					
//				.andExpect(status().isOk());
//		
//		mvc.perform(
//				MockMvcRequestBuilders
//				.post("/player")
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON).content(playerAsBytes))					
//				.andExpect(status().isOk());
//		assertEquals(1,playerRepository.count());	
//		
//		player = playerRepository.findByName("Marky Mark");
//		mvc.perform(
//				MockMvcRequestBuilders
//				.put("/player/assignTeam/"+player.getId()+"/ASSE"))
//				.andExpect(status().isOk()
//				);
//		player = playerRepository.findByName("Marky Mark");
//		team = teamRepository.findByName("ASSE");
//		assertEquals(team,player.getTeam());
//		mvc.perform(
//				MockMvcRequestBuilders
//				.delete("/player")
//				.param("id", player.getId().toString()))
//				.andExpect(status().isOk()
//				);		
//		assertEquals(0,playerRepository.count());
//		mvc.perform(
//		MockMvcRequestBuilders
//		.delete("/team")
//		.param("name", "ASSE"))
//		.andExpect(status().isOk()
//		);		
//		assertEquals(0,teamRepository.count());
//		
//	}
//
//	@Test
//	void contextLoads() {
//	}

}
