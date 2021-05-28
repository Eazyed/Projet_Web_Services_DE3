package DE3.WebServices.Back.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import io.spring.guides.gs_producing_web_service.GetAllProjectsRequest;
import io.spring.guides.gs_producing_web_service.GetAllProjectsResponse;
import io.spring.guides.gs_producing_web_service.Project;

@Endpoint
public class ProjectEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectEndpoint(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProjectsRequest")
	@ResponsePayload
	public GetAllProjectsResponse getAllProjects(@RequestPayload GetAllProjectsRequest request) {
		
		GetAllProjectsResponse response = new GetAllProjectsResponse();
		ArrayList<ProjectEntity> projects = projectRepository.getAllProjects();
		Project current = new Project();
		for(int i = 0; i < projects.size(); i++) {
			response.getProjects().add(new Project());
			current = response.getProjects().get(i);
			current.setIdProject(projects.get(i).getId());
			current.setLabel(projects.get(i).getLabel());
		}
		return response;
	}
}