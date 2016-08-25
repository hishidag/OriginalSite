package original.domain.service;

import original.domain.model.User;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * SpringSecurityと連携するためのクラス
 *
 */
public class RegistrationUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	User user;
	
	public RegistrationUserDetails(User user){ this.user = user; }
	
	public User getUser(){ return this.user; }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public String getUsername(){
		return this.user.getEmail();
	}
	
	@Override
	public String getPassword(){
		return this.user.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled(){
		return true;
	}
	
}
