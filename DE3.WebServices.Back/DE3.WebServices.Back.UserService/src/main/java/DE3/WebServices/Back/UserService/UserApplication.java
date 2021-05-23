package DE3.WebServices.Back.UserService;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import DE3.WebServices.Back.UserService.UserEntity;
import DE3.WebServices.Back.UserService.UserRepository;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
