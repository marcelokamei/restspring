package pt.mmkamei.restspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class RestspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestspringApplication.class, args);
	}

}
