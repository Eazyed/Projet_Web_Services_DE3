package tse.de3.td_de3_soap.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.CascadeType;
import javax.persistence.Entity;


@Entity
@Table(name = "players")
public class Player {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	public Player(String name, String role, Team team) {
		super();
		this.name = name;
		this.role = role;
		this.team=team;
	}
	public Player() {
		super();
	}
	private String name;
	private String role;
	@ManyToOne(fetch = FetchType.EAGER, optional = true,cascade = {CascadeType.ALL})
    @JoinColumn(name = "team_id", nullable = true)
	@Autowired
	private Team team;
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team){
		this.team=team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
}
