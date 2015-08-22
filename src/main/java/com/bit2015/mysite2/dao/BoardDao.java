package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	
/*	public int totalPage() throws SQLException{

		String sql = "SELECT count(*) FROM board";

	}*/
	
	public BoardVo getView(long no){
		//System.out.println("BoardDao getView : " + no);
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.getView", no);
		return vo;
		
/*
		String sql = "SELECT no, view_cnt, member_no, member_name, title, content, TO_CHAR (reg_date, 'YYYY-MMDD HH:MM:SS') FROM board where no=?";
*/	
	}

	public List<BoardVo> getList(){
			System.out.println("BoardDaoList");
			List<BoardVo> list = 
					(List<BoardVo>) sqlMapClientTemplate.queryForList("board.list");
			
/*			String sql = "  SELECT no, view_cnt, member_name, title, TO_CHAR (reg_date, 'YYYY-MMDD HH:MM:SS'), member_no FROM board order by my_no desc, order_no";
*/			return list;
	}
	
	public void insert(BoardVo boardVo){
		System.out.println(boardVo);
		sqlMapClientTemplate.insert("board.insert", boardVo);
/*		
		String sql = "insert into board values (board_no_seq.nextval, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)";
*/		
	}
	
	
	public void updateform(long no, BoardVo boardVo){
		System.out.println(boardVo);
		/*public BoardVo getView(long no){
		//System.out.println("BoardDao getView : " + no);
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.getView", no);
		return vo;*/
		
		System.out.println("boardDao : " + boardVo);
		sqlMapClientTemplate.insert("board.updateform", boardVo);
/*		
		String sql = "insert into board values (board_no_seq.nextval, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)";
*/		
	}
	
	public void delete(long no, long member_no){
		System.out.println(no + " : " + member_no);
		//두개 이상을 넘길때 Map를 사용해라
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("no", String.valueOf(no));
		map.put("member_no", String.valueOf(member_no));
	
	System.out.println(map);
	sqlMapClientTemplate.delete("board.delete", map);
	//String sql = "DELETE FROM guest_table WHERE no=? AND password=?";
	
	
		
		/*public BoardVo getView(long no){
		//System.out.println("BoardDao getView : " + no);
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.getView", no);
		return vo;*/
		
		//System.out.println("boardDao : " + boardVo);
		//sqlMapClientTemplate.insert("board.updateform", boardVo);
/*		
		String sql = "insert into board values (board_no_seq.nextval, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)";
*/		
	}
	
/*	
	public List<BoardVo> getList(int num) throws SQLException {

		String sql = "  select * from ( select A.*, rownum as rnum, floor((rownum-1)/5+1) as page, count(*) over() as totcnt from( SELECT * FROM board order by my_no desc, order_no) A) where page = ?";

	}*/

/*	public void insert(BoardVo vo) throws SQLException {

		String sql = "insert into board values (board_no_seq.nextval, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		
	}
	
	public void dapInsert(BoardVo vo) throws SQLException {

		String sql = "insert into board values (board_no_seq.nextval, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		
	}

	public void dapUpdate(long my_no, long order_no) throws SQLException {

		String sql = "UPDATE board set order_no=order_no+1 where my_no =? and order_no!=0 and order_no >=?";
	}

	public void delete(String no) throws SQLException {

		String sql = "DELETE FROM board WHERE no=?";
	}

	public void update(long no, String title, String content) throws SQLException {

		String sql = "UPDATE board SET title=?, content=? WHERE no=?";
	}
	
	public void plusCnt(long no) throws SQLException {
		String sql = "UPDATE board SET view_cnt=view_cnt+1 WHERE no=?";
	}
	
	public List<BoardVo> search(String kwd) throws SQLException {
		
		String sql = "select no, view_cnt, member_name, title, TO_CHAR (reg_date, 'YYYY-MMDD HH:MM:SS'), member_no from board where title like ? or content like ? or member_name like ?";
		//String sql = "select no, view_cnt, member_name, title, TO_CHAR (reg_date, 'YYYY-MMDD HH:MM:SS'), member_no from board where title like '%와아아%' or content like '%와아아%' or member_name like '%?%'";
		
	
	}*/

	
	
	//"select * from ( select A.*, rownum as rnum, floor((rownum-1)/2+1) as page, count(*) over() as totcnt from( SELECT no, view_cnt, member_name, title, TO_CHAR (reg_date, 'YYYY-MM-DD HH:MI:SS'), member_no FROM board ORDER BY reg_date DESC) A) where page =1";
	/*
	 * public BoardVo delSelect(String no) throws SQLException {
	 * 
	 * 
	 * int ino=Integer.parseInt(no); conn = getConnection(); String sql =
	 * "SELECT password FROM guest_table WHERE no=?"; pstmt =
	 * conn.prepareStatement(sql);
	 * 
	 * pstmt.setInt(1, ino);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * BoardVo vo = new BoardVo();
	 * 
	 * while(rs.next()){ String pass=rs.getString(1);
	 * 
	 * vo.setMember_no(pass); }
	 * 
	 * rs.close(); pstmt.close(); conn.close(); return vo; }
	 * 
	 */
	
	
	
	
	
/*	public List<GuestBookVo> getList() {
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
	}*/
	
	
	
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
