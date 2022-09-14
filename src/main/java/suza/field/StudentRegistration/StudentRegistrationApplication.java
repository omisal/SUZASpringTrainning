package suza.field.StudentRegistration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import suza.field.StudentRegistration.repos.StudentRepo;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title = "Stude",description = "dafa"))
public class StudentRegistrationApplication {
	public static void main(String[] args) {

		SpringApplication.run(StudentRegistrationApplication.class, args);
	}

}
