package codesandnotes.restsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@Controller
public class Application {

	//@Bean
	//public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
		//return new ApplicationSecurity();
	//}

	public static void main(String[] args) {
		//SpringApplication application = new SpringApplication(Application.class);
		//application.run(args);
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/mylogin")
	public String mylogin() {
		return "login";
	}
}
