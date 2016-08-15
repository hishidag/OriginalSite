package original.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import original.domain.model.User;
import original.domain.repository.UserRepository;

@Service
public class RegistrationUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repository;

	//このuserの取得法を変えるとログインに必要な要素を変更できる
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		if(user == null){ throw new UsernameNotFoundException("user is not found."); }
		return new RegistrationUserDetails(user);
	}
}
