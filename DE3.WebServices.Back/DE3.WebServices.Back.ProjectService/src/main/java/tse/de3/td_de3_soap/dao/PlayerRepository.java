package tse.de3.td_de3_soap.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tse.de3.td_de3_soap.model.Player;

@Repository
@Transactional
public interface PlayerRepository extends CrudRepository<Player,Long> {
	Player findById(long id);
	List<Player> findByRole(String role);
	Player findByName(String name);
	void deleteByName(String name);	
	void deleteById(Long id);
	List<Player> findByTeam(Player player);
	List<Player> findByTeamName(String teamName);
}
