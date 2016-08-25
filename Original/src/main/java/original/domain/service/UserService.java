package original.domain.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import original.domain.repository.UserRepository;
import original.domain.model.User;

/**
 *
 * ユーザ永続化のためのサービス
 *
 */
@Service
public class UserService {	
	@Autowired
	UserRepository repository;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public User login(User user){
		return repository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}
	
	public void create(User user){
		final String sql = "insert into user(name,password,email) values(?,?,?)";
		jdbcTemplate.update(sql,new Object[]{user.getName(),user.getPassword(),user.getEmail()});
	}
	
	public void update(User user){
		repository.save(user);
	}
	
	public void delete(int userID){
		repository.delete(userID);
	}
	
	public boolean isDuplicateEmail(String email){
		if(repository.findByEmail(email) != null) return true;
		return false;
	}
	
	public boolean isDuplicateEmailandUserid(int userid,String email){
		if(repository.findByEmailandUserId(userid, email) != null) return true;
		return false;
	}
	
}
