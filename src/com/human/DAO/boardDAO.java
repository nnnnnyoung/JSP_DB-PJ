package com.human.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.util.digester.SystemPropertySource;

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
			String sql="insert into qa values (?,?,?,?,?,?,default,?)";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				System.out.println(boardvo.getNum());
				psmt.setInt(1, boardvo.getNum());
				psmt.setString(2, boardvo.getId());
				psmt.setString(3, boardvo.getName());
				psmt.setString(4, boardvo.getPass());
				psmt.setString(5, boardvo.getTitle());
				psmt.setString(6, boardvo.getContent());
				psmt.setString(7, boardvo.getChkbox());
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
					bvo.setNum(rs.getInt("num"));
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

	public ArrayList<boardVO> selectC(String wno) {
		// TODO Auto-generated method stub
		ArrayList<boardVO> clist=new ArrayList<>();
		ResultSet rs=null;
		if(connect()) {
			String sql="select * from comm where num=?";
			try {
				PreparedStatement psmt =conn.prepareStatement(sql);
				psmt.setInt(1, Integer.parseInt(wno));
				rs=psmt.executeQuery();
				while(rs.next()) {
					boardVO bvo=new boardVO();
					bvo.setId(rs.getString("id"));
					bvo.setName(rs.getString("name"));
					bvo.setContent(rs.getString("content"));
					bvo.setIndate(rs.getString("indate"));
					clist.add(bvo);
				}
				conn.close();
				return clist;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return null;
	}

	public void comIn(boardVO bvo) {
		if(connect()) {
			String sql="insert into comm values(?,?,?,?,default)";
			try {
				PreparedStatement pt=conn.prepareStatement(sql);
				pt.setInt(1, bvo.getNum());
				pt.setString(2, bvo.getId());
				pt.setString(3, bvo.getName());
				pt.setString(4, bvo.getContent());
				int r=pt.executeUpdate();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void del(int del) {
		// TODO Auto-generated method stub
		if(connect()) {
			String sql="delete from qa where num=?";
			try {
				PreparedStatement pt=conn.prepareStatement(sql);
				pt.setInt(1, del);
				int r=pt.executeUpdate();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public boardVO modiform(int modi) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		if(connect()) {
			String sql="select * from qa where num=?";
			try {
				PreparedStatement pt=conn.prepareStatement(sql);
				pt.setInt(1, modi);
				rs=pt.executeQuery();
				if(rs.next()) {
					boardVO bvo=new boardVO();
					bvo.setNum(rs.getInt("num"));
					bvo.setId(rs.getString("id"));
					bvo.setPass(rs.getString("pass"));
					bvo.setName(rs.getString("name"));
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

	public void update(boardVO boardvo) {
		// TODO Auto-generated method stub
		if(connect()) {
			String sql="update qa set id=?,name=?,pass=?,title=?,content=?,chkbox=? where num =?";
			try {
				PreparedStatement pt=conn.prepareStatement(sql);
				pt.setString(1, boardvo.getId());
				pt.setString(2, boardvo.getName());
				pt.setString(3, boardvo.getPass());
				pt.setString(4, boardvo.getTitle());
				pt.setString(5, boardvo.getContent());
				pt.setString(6, boardvo.getChkbox());
				pt.setInt(7, boardvo.getNum());
				int r=pt.executeUpdate();
				System.out.println(r);
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	
}
