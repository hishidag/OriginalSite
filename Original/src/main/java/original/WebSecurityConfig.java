package original;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import original.domain.service.RegistrationUserDetailsService;

/**
 * 
 * 認証についての設定をするクラス
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	RegistrationUserDetailsService userDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			//premitAll()が与えられたurlはログインしていない状態でも遷移可能
			.antMatchers("/js/**","/css/**").permitAll()
			.antMatchers("/","/loginForm","/Registration/**","/newslink","/news/**"
					,"/input","/result","/contact/**","/description","/translator").permitAll()
			.antMatchers("/**").authenticated()
			//認証方式をform認証へ
		.and().formLogin()
			//loginのページ
			.loginPage("/loginForm")
			//login処理をするページ。SpringSecurityに委譲
			.loginProcessingUrl("/login")
			//loginのページのフォームのパラメータ
			.usernameParameter("email")
			.passwordParameter("password")
			.defaultSuccessUrl("/",false)
			.failureUrl("/loginForm?error=true").permitAll()
		.and().logout()
			//logout処理のページ
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true).permitAll();			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
		
}
