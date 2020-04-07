package test.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import test.frame.MemberDto;
import test.util.DBConnect;

/*
 *  Data Access Object (DAO)
 *  
 *  - insert, update, delete, select 작업을 할 클래스 설계
 */
public class MemberDao {
	// MemberDto 객체를 인자로 전달 받는 메소드 (method overloading)
	public boolean insert(test.frame.MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();

			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(?, ?, ?)"; 

			pstmt=conn.prepareStatement(sql);
			// MemberDto 객체의 getter 메소드를 이용해서 필요한 값 얻어오기
			int num=dto.getNum();
			String name=dto.getName();
			String addr=dto.getAddr();
			
			pstmt.setInt(1, num); // 변수에 담지 않고 dto.getNum() 바로 적어줘도 된다. 연습할려고 변수에 담아서 넣은 것 뿐
			pstmt.setString(2, name);
			pstmt.setString(3, addr);

			flag=pstmt.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}	
	}

	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();

			String sql="Delete From member"
					+ " Where num=?"; 

			pstmt=conn.prepareStatement(sql);

			pstmt.setInt(1, num);
			
			flag=pstmt.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}	
	}
	public boolean update(int num, String name, String addr) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="Update member" // 테이블명
					+ " SET name=?, addr=?" // 수정할 데이터
					+ " WHERE num=?"; // 조건절
			pstmt=conn.prepareStatement(sql);
			// ?에 값 바인딩 하기
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, num);
			// 실행
			flag=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close(); // 사용한 객체는 마무리 해줘야 함(얻어 온 순서의 역순)
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		// 위의 작업의 성공 여부를 여기서 알고 싶으면?
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	public List<test.frame.MemberDto> select()  {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null; // 작업한 뒤 close 해주는 것이 좋다.(finally절에서)
		// Select 된 결과를 저장해서 리턴 할 객체를 저장 할 지역변수 선언
		List<test.frame.MemberDto> list=new ArrayList<>(); // list의 사이즈를 보면 알수있다.
		try {
			conn=new DBConnect().getConn();
			// 실행할 SQL 문
			String sql="SELECT num, name, addr"
					+ " FROM member "
					+ " ORDER BY num ASC";
			// Connection 객체의 메소드를 이용해서 PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql); // pstmt는 sql문을 대신 실행해주는 객체
			// select 문 수행하고 결과를 ResultSet 으로 받아오기
			rs=pstmt.executeQuery(); // Select의 결과는 ResultSet에 담긴다. // Select 해주는 메소드 executeQuery
			// 반복문 돌면서 ResultSet 객체에 들어 있는 정보를 출력하기
			while(rs.next()) { // ResultSet의 사용법.
				// Select 된 row 하나당 하나의 MemberDto 객체를 생성해서
				test.frame.MemberDto dto=new test.frame.MemberDto(); // 반복문 돌 때 마다 객체 새로 생성해야됨.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				// row 에 있는 정보를 MemberDto 객체에 setter 메소드를 이용해서 담고
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				// 회원한명의 정보가 담긴 MemberDto 객체의 참조값을 ArrayList 객체에 누적 시키기
				list.add(dto);
//				data+=Integer.toString(num)+"|"+name+"|"+addr+"\n"; // + 안쓰면 한번만 출력됨
//				System.out.println(num+"|"+name+"|"+addr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return list;
	}
}