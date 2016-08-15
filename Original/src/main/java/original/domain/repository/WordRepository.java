package original.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import original.domain.model.Word;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word,Integer>{

	@Query(value = "SELECT w FROM Word w WHERE w.userID = :userID and w.language = :language")
	List<Word> findByUserIDAndLanguage(@Param("userID") int userID,@Param("language") String language);

	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Word w SET w.altword = :altword, w.translation = :translation, w.newDate = :newdate WHERE w.wordID = :wordID")
	Integer updateByWordID(@Param("wordID") int wordID, @Param("altword")String word, @Param("translation")String translation,@Param("newdate") Timestamp timestamp);
	
	
}

