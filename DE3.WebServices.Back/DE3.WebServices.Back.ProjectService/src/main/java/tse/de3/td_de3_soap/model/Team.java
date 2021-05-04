package tse.de3.td_de3_soap.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	public Team(String name, String mainColour) {
		super();
		this.name = name;
		this.mainColour = mainColour;
	}
	public Team() {
		super();
	}
	@Column(unique = true)
	private String name;
	private String mainColour;
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Player> players;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMainColour() {
		return mainColour;
	}
	public void setMainColour(String mainColour) {
		this.mainColour = mainColour;
	}
	public Long getId() {
		return this.id;
	}
}
