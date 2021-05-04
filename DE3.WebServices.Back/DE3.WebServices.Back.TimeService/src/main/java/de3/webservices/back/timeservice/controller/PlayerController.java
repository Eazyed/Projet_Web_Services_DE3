package de3.webservices.back.timeservice.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Transactional
public class PlayerController {
	
//	@Autowired
//	private TeamRepository teamRepo;
//	@Autowired
//	private PlayerRepository repo;
//
//	@GetMapping("/player")
//	public Iterable<Player> getAll() {
//		return repo.findAll();
//	}
//	
//	@GetMapping("/player/findById/{id}")
//	public Player findById(@PathVariable long id) {
//		return repo.findById(id);
//	}
//	
//	@GetMapping("/player/findByRole")
//	public List<Player> findByRole(@RequestParam(value = "role", defaultValue = "") String role) {
//		return repo.findByRole(role);
//	}
//	
//	@PostMapping("/player")
//	public Player savePlayer(@RequestBody Player player){
//		Player returnPlayer = null;
//		try {
//			returnPlayer = repo.save(player);
//		}catch(Exception e){
//			String message = e.getMessage();
//		}
//		return  returnPlayer;
//	}
//	
//	@DeleteMapping("/player")
//	public void deletePlayer(@RequestParam(value = "id", defaultValue = "") Long id) {
//		repo.deleteById(id);
//	}
//	
//	@PutMapping("/player/assignTeam/{playerId}/{teamName}")
//	public Player assignTeam(@PathVariable String teamName,@PathVariable Long playerId) throws Exception {
//		Team team = teamRepo.findByName(teamName);
//		Optional<Player> nullablePlayer = repo.findById(playerId);
//		if(nullablePlayer.isPresent() && team != null) {
//			Player player = nullablePlayer.get();
//			player.setTeam(team);
//			return repo.save(player);
//		}
//		throw new Exception("Team or player not found");
//	}
	
	

}
