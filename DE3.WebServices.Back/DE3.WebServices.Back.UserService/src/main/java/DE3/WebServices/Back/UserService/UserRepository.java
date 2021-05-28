package DE3.WebServices.Back.UserService;

import org.springframework.stereotype.Component;
import java.sql.*;

import io.spring.guides.gs_producing_web_service.Role;

@Component
public class UserRepository {	
	
	public UserRepository() {}
	
	private Connection connect() throws Exception {
	    try
	    {
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/webservicedb";
			Class.forName(myDriver);
		
			return DriverManager.getConnection(myUrl, "root", "");
		}
	    catch (Exception e)
	    {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			throw e;
	    }
	}
	
	public UserEntity findUserByLogin(String login) {
		String query = "SELECT * FROM users as u WHERE login = '" + login + "';";
		UserEntity user = new UserEntity();
		try {
			Connection conn = this.connect();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			String pwdTmp;
			while (rs.next())
		    {
				user.setId(rs.getLong("IdUser"));
				user.setFirstname(rs.getString("Firstname"));
				user.setLastname(rs.getString("Lastname"));
				user.setLogin(rs.getString("Login"));
				pwdTmp = rs.getString("Password");
				user.setPassword(pwdTmp/*.substring(0, pwdTmp.length() - 8)*/); // on enlève les 8 caractères du sel à la fin de mot de passe
				user.setSalt(rs.getString("Salt"));
				user.setRole(Role.valueOf(rs.getString("Role").toUpperCase()));
		    }
			st.close();
		} 
		catch(Exception e) {
			System.out.println(e.toString());
			user.setId(0L);
			user.setFirstname("");
			user.setLastname("");
			user.setLogin("");
			user.setPassword("");
			user.setSalt("");
			user.setRole(Role.DEVELOPER);
		}
		return user;
		
	}
}