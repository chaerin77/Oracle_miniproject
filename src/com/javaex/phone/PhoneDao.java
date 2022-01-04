package com.javaex.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {

	// 필드
	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String driver ="oracle.jdbc.driver.OracleDriver";
    private String url ="jdbc:oracle:thin:@localhost:1521:xe";
    private String id ="phonedb";
    private String pw ="phonedb";
	
	// 생성자

	// 메소드 g/s

	// 메소드 일반
	public void getConnection() { 

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);
			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	public void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	
	public void pInsert(PersonVo personVo) {
		
		getConnection();
		try {
			// 3. SQL문 준비
			String query ="";
			query += " insert into person ";
			query += " values(seq_person_id.nextval, ?, ?, ?) ";
			
			//문자열 쿼리문으로 바꾸기
			pstmt = conn.prepareStatement(query);
			
			// 바인딩 
			
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			
			// 실행
			pstmt.executeUpdate();
			
			// 4.결과처리
			//System.out.println(count + "건이 추가되었습니다.");
			
		}catch (SQLException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		}
		close();
	} 
	
	
	public void pUpdate(PersonVo personVo) {
		getConnection();
		try {
			//3.SQL문 준비
			String query = "";
			query += " update person ";
			query += " set name = ?, ";
			query += "     hp = ?, ";
			query += "     company = ? ";
			query += " where person_id = ? ";
			
			//문자열 쿼리문으로 바꾸기
			pstmt = conn.prepareStatement(query);
			
			//바인딩
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setInt(4, personVo.getPersonId());
			
			//실행
            pstmt.executeUpdate();
			
			//4.결과처리
			//System.out.println(count + "건이 수정되었습니다.");
            
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
	}
	
	
	public void pDelete(int personId) {
		getConnection();
		
		try {
			//3.SQL문 준비
			String query = "";
			query += " delete from person ";
			query += " where person_id = ? ";
			
			//문자열 쿼리문으로 바꾸기
			pstmt = conn.prepareStatement(query);
			
			//바인딩
			pstmt.setInt(1, personId);
			
			//실행
			pstmt.executeUpdate();
			
			//4.결과처리
			//System.out.println(count + "건이 삭제되었습니다.");
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}
	
	
	public List<PersonVo> PersonSelect(){
		List<PersonVo> pList = new ArrayList<PersonVo>();
	    getConnection();
	    try {
	    	//SQL문 준비
	    	String query = "";
	    	query += " select * ";
	    	query += " from person ";
	    	
	    	//문자열 쿼리문으로 바꾸기
	    	pstmt = conn.prepareStatement(query);
	    	
	    	//실행
	    	rs = pstmt.executeQuery();
	    	
	    	//4.결과처리
	    	while(rs.next()) {
	    		int personId = rs.getInt("person_Id");
	    		String name = rs.getString("name");
	    		String hp = rs.getString("hp");
	    		String company = rs.getString("company");
	    		
	    		PersonVo vo = new PersonVo(personId,name,hp,company);
	    		pList.add(vo);		
	    	}
	    	
	    } catch (SQLException e) {
	    	System.out.println("error:" + e);
	    }
	    close();
		return pList;
	}
	
	
	public List<PersonVo> PersonSearch(String search){
		   List<PersonVo> pslist = new ArrayList<PersonVo>();
		
		   getConnection();
		   
		   try {
			   //3.문자열 만들기 --쿼리문고치기.. person_id 안써서안나왔나
			   String query = "";
			   query += " select person_id, ";
			   query += "        name, ";
			   query += "        hp, ";
			   query += "        company ";
			   query += " from person ";
			   query += " where name like ? ";
			   query += " or hp like ? ";
			   query += " or company like ? ";
			   
			   //문자열 쿼리문으로 바꾸기
			   pstmt = conn.prepareStatement(query);
			  
			   //바인딩
			   /*
			   pstmt.setString(1, '%'+search+'%'); //'%유%'
			   pstmt.setString(2, '%'+search+'%'); //'%5%'
			   pstmt.setString(3, '%'+search+'%'); //'%1%'*/
			   
			   pstmt.setString(1, "%"+search+"%"); //'%유%'
			   pstmt.setString(2, "%"+search+"%"); //'%5%'
			   pstmt.setString(3, "%"+search+"%"); //'%1%'
			   
			   //실행
			   rs = pstmt.executeQuery();
			   
			   //4.결과처리
			   while(rs.next()) {
				   int pid = rs.getInt(1);
				   String name = rs.getString(2);
				   String hp = rs.getString(3);
				   String company = rs.getString(4);
				   
				   PersonVo vo = new PersonVo(pid,name,hp,company);
				   pslist.add(vo);
			   }
			   
		   }catch (SQLException e) {
		    	System.out.println("error:" + e);
		   }
		   close();
		   return pslist;
	}
}
