package naddym.nifi.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This SpringBoot Application demonstrates OAuth Token Generation
 * and Parsing.
 *
 * @author naddym
 */
@SpringBootApplication
public class OauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}
}
