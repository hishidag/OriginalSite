package original.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import original.domain.repository.MemoRepository;
import original.domain.model.Memo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

/**
 *
 * メモ永続化のためのサービス
 *
 */
@Service
@Transactional
public class MemoService {
	@Autowired
	MemoRepository repository;
	JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Memo findOne(Integer memoid){
		return repository.findOne(memoid);
	}
	
	public List<Memo> findAll(int userid,String language){
		return repository.findByUserIDAndLanguage(userid,language);
	}

	public void insert(Integer userID,String memo,String language){
		jdbcTemplate.update("insert into memo(userID,memo,language) values(?,?,?)",userID,memo,language);
	}
	
	public void update(String memo,int memoID){
		repository.updateMemo(memo,memoID,new Timestamp(new Date().getTime()));
	}
	
	public void delete(Integer memoid){
		repository.delete(memoid);
	}
	
}
