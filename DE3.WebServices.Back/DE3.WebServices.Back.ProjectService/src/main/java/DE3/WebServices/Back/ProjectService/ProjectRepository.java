package DE3.WebServices.Back.ProjectService;

import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;

@Component
public class ProjectRepository {	
	
	public ProjectRepository() {}
	
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
	
	public ArrayList<ProjectEntity> getAllProjects() {
		String query = "SELECT * FROM projects;";
		ArrayList<ProjectEntity> projects = new ArrayList<ProjectEntity>();
		try {
			Connection conn = this.connect();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
		    {
				projects.add(new ProjectEntity(
						rs.getLong("IdProject"), 
						rs.getString("Label")
				));
		    }
			st.close();
		} 
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return projects;
		
	}
}