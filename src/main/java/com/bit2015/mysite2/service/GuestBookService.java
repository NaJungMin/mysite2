package com.bit2015.mysite2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.GuestBookDao;
import com.bit2015.mysite2.vo.GuestBookVo;

@Service
public class GuestBookService {

	@Autowired
	GuestBookDao guestBookDao;
	
	public List<GuestBookVo> getList() {
		System.out.println("GuestBookServiceList");
		return guestBookDao.getList();
	}
	
	public void insert(GuestBookVo guestBookVo){
		guestBookDao.insert(guestBookVo);
	}
	
	
	public void delete(long no, String password){
		guestBookDao.delete(no, password);
	}
	
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
