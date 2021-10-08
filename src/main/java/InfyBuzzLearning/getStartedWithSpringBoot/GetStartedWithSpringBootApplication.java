package InfyBuzzLearning.getStartedWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"src/main/java/controller", "src/main/java/service"})
@EntityScan("src/main/java/entity")
@EnableJpaRepositories("src/main/java/repository")
public class GetStartedWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetStartedWithSpringBootApplication.class, args);
	}

}
