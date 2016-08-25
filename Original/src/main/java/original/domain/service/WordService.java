package original.domain.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import original.domain.repository.WordRepository;
import original.domain.model.Word;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * 単語永続化のためのサービス
 *
 */
@Service
public class WordService {

	@Autowired
	WordRepository repository;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(int userID,String word,String translate,String language){
		final String sql = "insert into word(userID,word,translation,language) values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{userID,word,translate,language});
	}
	
	public List<Word> findAll(int userID,String language){
		return repository.findByUserIDAndLanguage(userID,language);
	}
	
	public Word findOne(int wordID){
		return repository.findOne(wordID);
	}
	
	public void delete(int wordID){
		repository.delete(wordID);
	}
	
	public int update(int wordID,String word, String translation){
		return repository.updateByWordID(wordID, word, translation, new Timestamp(new Date().getTime()));
	}
	
	
	
}
