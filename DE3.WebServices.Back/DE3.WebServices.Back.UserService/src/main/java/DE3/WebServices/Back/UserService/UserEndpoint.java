package DE3.WebServices.Back.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.AuthenticateUserRequest;
import io.spring.guides.gs_producing_web_service.AuthenticateUserResponse;
import io.spring.guides.gs_producing_web_service.Role;
import io.spring.guides.gs_producing_web_service.User;

@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private UserRepository userRepository;

	@Autowired
	public UserEndpoint(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "authenticateUserRequest")
	@ResponsePayload
	public AuthenticateUserResponse getUser(@RequestPayload AuthenticateUserRequest request) {
		
		AuthenticateUserResponse response = new AuthenticateUserResponse();
		User soapUser = new User();
		UserEntity user = userRepository.findUserByLogin(request.getLogin());
		if (user.authenticate(request.getLogin(), request.getPassword())) {
			soapUser.setIdUser(user.getId());
			soapUser.setFirstname(user.getFirstname());
			soapUser.setLastname(user.getLastname());
			soapUser.setLogin(user.getLogin());
			soapUser.setRole(user.getRole());
		} else {
			soapUser.setIdUser(0L);
			soapUser.setFirstname("");
			soapUser.setLastname("");
			soapUser.setLogin("");
			soapUser.setRole(Role.DEVELOPER);
		}
		response.setUser(soapUser);
		return response;
	}
}