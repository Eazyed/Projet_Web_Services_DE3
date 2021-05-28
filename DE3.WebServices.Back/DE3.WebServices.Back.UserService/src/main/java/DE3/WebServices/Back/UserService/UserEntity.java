package DE3.WebServices.Back.UserService;



import io.spring.guides.gs_producing_web_service.Role;

public class UserEntity {
	private Long id;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String salt;
	private Role role;
	
	UserEntity() {}
	
	UserEntity(String firstname, String lastname, String login, String password, String salt, Role role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.salt = salt;
		this.role = role;
	}
	
	public boolean authenticate(String login, String password) {
		// Non géré pour le moment : hachage du mot de passe avec le sel
		return (login.contentEquals(this.login) && password.concat(this.salt).contentEquals(this.password));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
