package codesandnotes.restsecurity;

//import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


//@Order(SecurityProperties.BASIC_AUTH_ORDER)
@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	//@Autowired
	//private RESTAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private RESTAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	
	   //@Bean
	   // public TokenAuthenticationFilter tokenAuthenticationFilter() {
	     //   return new TokenAuthenticationFilter();
	    //}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("user").password("user").roles("USER")
		.and().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/").permitAll().and()
		http.authorizeRequests().antMatchers("/rest/**").authenticated();
		
		//http.exceptionHandling().authenticationEntryPoint(new RESTAuthenticationEntryPoint());
		//user for formLogin not come
		
		
		 //http.formLogin().loginPage("/kk")
         //.usernameParameter("username").passwordParameter("password");
         
		
		http.formLogin().successHandler(authenticationSuccessHandler);
		//use for automatic login /login post username password
		
		//http.formLogin().failureHandler(authenticationFailureHandler);
		http.logout().logoutSuccessUrl("/");
		
		//http.csrf()
        //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

		// CSRF tokens handling
		//http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
		
		// Add our custom Token based authentication filter
        //http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	//@Override
	//public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
	//	return super.authenticationManagerBean();
	//}
	
	@Bean 
	public NoOpPasswordEncoder noop() {
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}
	
}
