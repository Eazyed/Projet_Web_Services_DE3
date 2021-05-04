package tse.de3.td_de3_soap.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tse.de3.td_de3_soap.model.Team;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team,Long> {
	Team findById(long id);
	List<Team> findByMainColour(String colour);
	Team findByName(String name);
	void deleteByName(String name);	
}
