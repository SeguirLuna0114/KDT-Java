package myspring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.model.Board;

//repository어노테이션
@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;

	public int insert(Board board) {
		// TODO Auto-generated method stub
		return session.insert("insert", board);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return session.selectOne("count");
	}

	public List<Board> getBoardList(int page) {
		// TODO Auto-generated method stub
		return session.selectList("list", page);
	}

}
