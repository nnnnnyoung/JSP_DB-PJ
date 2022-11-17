package com.human.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.VO.boardVO;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class boardDAO {
	Connection conn=null;
	
	public boardDAO(){
		//1. 드라이버 로드(한번만) 2. 커넥션 3.쿼리전송 4.리턴값 처리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch(Exception e) {
			System.out.println("로드실패");
		}
		
	}
	
	public boolean connect() { // 
		try {
			// 커넥션을 시도하고 그 결과를 얻어 오는 코드... 
			conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	
	
	public ArrayList<boardVO> selectAll(){
		ArrayList<boardVO> allList=new ArrayList<>();
		String sql="select * from qa";
		if(connect()) {
			ResultSet rs=null;
			try {
				Statement st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()) {
					boardVO bvo=new boardVO();
					bvo.setNum(rs.getInt("num"));
					bvo.setId(rs.getString("id"));
					bvo.setName(rs.getString("name"));
					bvo.setPass(rs.getString("pass"));
					bvo.setTitle(rs.getString("title"));
					bvo.setContent(rs.getString("content"));
					bvo.setIndate(rs.getString("indate"));
					bvo.setChkbox(rs.getString("chkbox"));
					allList.add(bvo);					
				}
				conn.close();
				return allList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public int wrnum() {
		ResultSet rs=null;
		int num=0;
		if(connect()) {
			String sql="select num from qa where rownum =1 order by num desc";
			try {
				Statement st=conn.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()) {
					num=rs.getInt("num");
					conn.close();
					return num;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}
	
	public void insert(boardVO boardvo) { //작성한 게시글을 DB에 저장
		if(connect()) {
			String sql="insert into qa values (qa_cnt.nextval,?,?,?,?,?,default,?)";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, boardvo.getId());
				psmt.setString(2, boardvo.getName());
				psmt.setString(3, boardvo.getPass());
				psmt.setString(4, boardvo.getTitle());
				psmt.setString(5, boardvo.getContent());
				psmt.setString(6, boardvo.getChkbox());
				int r=psmt.executeUpdate();
				System.out.println("입력 성공");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("입력 실패");
			}
		}
	}

	public boardVO selectOne(String num) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		if(connect()) {
			String sql="select * from qa where num="+num;
			try {
				Statement st =conn.createStatement();
				rs=st.executeQuery(sql);
				
				if(rs.next()) {
					boardVO bvo=new boardVO();
					bvo.setName(rs.getString("name"));
					bvo.setChkbox(rs.getString("chkbox"));
					bvo.setIndate(rs.getString("indate"));
					bvo.setTitle(rs.getString("title"));
					bvo.setContent(rs.getString("content"));
					return bvo;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	
}
