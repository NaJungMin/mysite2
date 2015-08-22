package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<GuestBookVo> getList() {
		System.out.println("GuestBookDaoList");
		List<GuestBookVo> list = 
				(List<GuestBookVo>) sqlMapClientTemplate.queryForList("guestbook.list");
		
		return list;
	}
	
	public void insert(GuestBookVo guestBookVo) {
		System.out.println(guestBookVo);
		sqlMapClientTemplate.insert("guestbook.insert", guestBookVo);
	}

	public void delete(long no, String password){
		System.out.println(no + password);
		//두개 이상을 넘길때 Map를 사용해라
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("no", String.valueOf(no));
			map.put("password", password);
		
		
		sqlMapClientTemplate.delete("guestbook.delete", map);
		//String sql = "DELETE FROM guest_table WHERE no=? AND password=?";
	}
	
/*
public GuestBookVo delSelect(String no) throws SQLException {
		
		int ino=Integer.parseInt(no);
		conn = getConnection();
		String sql = "SELECT password FROM guest_table WHERE no=?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, ino);

		rs = pstmt.executeQuery();
		
		GuestBookVo vo = new GuestBookVo();
		
		while(rs.next()){
			String pass=rs.getString(1);
			
			vo.setPassword(pass);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return vo;
	}
	*/
	
	
	
	
}
