package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.BoardDao;
import com.example.demo.model.Board;

@Service
public class BoardServiceImpl{

	@Autowired
	private BoardDao dao;

	public int insert(Board board) {
		return dao.insert(board);
	}

	public int getCount() {
		return dao.getCount();
	}

	public List<Board> getBoardList(int page) {
		return dao.getBoardList(page);
	}

	public void updatecount(int no) {
		dao.updatecount(no);
	}

	public Board getBoard(int no) {
		return dao.getBoard(no);
	}

	public int update(Board board) {
		return dao.update(board);
	}

	public int delete(int no) {
		return dao.delete(no);
	}
}
