package original.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import original.domain.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Transactional
	@Query("select u from User u where u.email = :email and u.password = :password")
	User findByEmailAndPassword(@Param("email")String email,@Param("password") String password);

	User findByName(String name);
	
	@Query("select u from User u where u.email = :email")
	User findByEmail(@Param("email") String email);

	@Query("select u from User u where u.email = :email and u.userID <> :userid")
	User findByEmailandUserId(@Param("userid") int userid ,@Param("email") String email);

}
