package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dao.BoardDao;
import myspring.model.Board;

// 서비스 어노테이션
@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;

	public int insert(Board board) {
		// TODO Auto-generated method stub
		return dao.insert(board);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}

	public List<Board> getBoardList(int page) {
		// TODO Auto-generated method stub
		return dao.getBoardList(page);
	}

}
