package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	// get emaillist check
	public UserVo get(String email){
/*
		String sql = "select no, name, email, password, gender from member where email=?";
*/		
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put( "email", email );
		
		System.out.println("emaillist check : " + email);
		UserVo vo = (UserVo) sqlMapClientTemplate.queryForObject("user.emailCheck", map);
		return vo;
	}
	
	
	public UserVo get( String email, String password ) {
		Map<String, String> map = new HashMap<String, String>();
		map.put( "email", email );
		map.put( "password", password );
		
		UserVo vo = (UserVo)sqlMapClientTemplate.queryForObject( "user.getByEmailAndPassword", map );
		return vo;
	}
	
	//insert
	public void insert( UserVo vo ) {
		sqlMapClientTemplate.insert( "user.insert", vo );
	}	
	
	//update
	public void update(UserVo userVo) {
		System.out.println("UserDao : " + userVo);
		//Map<String, String> map = new HashMap<String, String>();
		
		sqlMapClientTemplate.insert("user.insert",userVo);
	}
	
	/*
	 * //delete public void delete( UserVo vo ) throws SQLException { Connection
	 * conn = getConnection();
	 * 
	 * String sql = "delete from user where no=? and password=?";
	 * PreparedStatement pstmt = conn.prepareStatement( sql );
	 * 
	 * pstmt.setLong( 1, vo.getNo() ); pstmt.setString( 2, vo.getPassword() );
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * pstmt.close(); conn.close(); }
	 * 
	 * //getList public List<UserVo> getList() throws SQLException {
	 * List<UserVo> list = new ArrayList<UserVo>();
	 * 
	 * Connection conn = getConnection(); Statement stmt =
	 * conn.createStatement();
	 * 
	 * String sql = "   select no," + "          name," + "          password,"
	 * + "          message," +
	 * "          to_char(reg_date, 'YYYY-MM-DD HH:MM:SS')" + "     from user" +
	 * " order by reg_date desc"; ResultSet rs = stmt.executeQuery( sql );
	 * 
	 * while( rs.next() ) { long no = rs.getLong( 1 ); String name =
	 * rs.getString( 2 ); String email = rs.getString( 3 ); String password =
	 * rs.getString( 4 ); String gender = rs.getString( 5 );
	 * 
	 * UserVo vo = new UserVo(); vo.setNo(no); vo.setName( name );
	 * vo.setEmail(email); vo.setPassword(password); vo.setGender(gender);
	 * 
	 * list.add( vo ); }
	 * 
	 * rs.close(); stmt.close(); conn.close();
	 * 
	 * return list; }
	 */
	
	
}
