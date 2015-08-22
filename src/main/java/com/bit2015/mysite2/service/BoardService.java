package com.bit2015.mysite2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.BoardDao;
import com.bit2015.mysite2.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;
	
	public List<BoardVo> getList() {
		System.out.println("BoardServiceList");
		return boardDao.getList();
	}
	
	public void write(BoardVo boardVo){
		boardDao.insert(boardVo);
	}
	
	public BoardVo getView(long no){
		//System.out.println("service : " + no);
		BoardVo vo = boardDao.getView(no);
		return vo;
	}
	
	public void updateform(long no, BoardVo boardVo){
		//System.out.println("service : " + no);
		boardDao.updateform(no, boardVo);
	}
	
	public void delete(long no, long member_no){
		//System.out.println("service : " + no);
		boardDao.delete(no, member_no);
	}
	
	/*
	public void delete(long no, String password){
		guestBookDao.delete(no, password);
	}*/
	
	
	
	
/*	public void join(UserVo userVo) {
		guestBookDao.insert(userVo);
	}
	
	public UserVo login(UserVo userVo){
		UserVo vo = guestBookDao.get(userVo.getEmail(), userVo.getPassword());
		return vo;
	}
	
	public void update(UserVo userVo){
		System.out.println("UserService : " + userVo);
		guestBookDao.update(userVo);
		
	}*/

}
