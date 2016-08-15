package original.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import original.domain.model.Memo;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Integer>{	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Memo m SET m.memo = :memo ,m.newDate = :newdate WHERE m.memoID = :memoID" )
	Integer updateMemo(@Param("memo") String memo,@Param("memoID") int memoID, @Param("newdate") Timestamp timestamp);

	
	@Query(value = "SELECT m FROM Memo m WHERE m.userID = :userID and m.language = :language" )
	List<Memo> findByUserIDAndLanguage(@Param("userID") int id,@Param("language")String language);
	
}
