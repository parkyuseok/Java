package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * member 테이블의 모든정보를 콘솔창에 출력해 보세요.
		 * 단, 회원번호에 대해서 오름차순 정렬해서
		 */
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			// 실행할 SQL 문
			String sql="select * From member"
					+ " Order by num ASC";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// sql문 수행하고 select 결과값을 ResultSet으로 받아오기
			rs=pstmt.executeQuery();
			while(rs.next()) { // ResultSet의 사용법.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println(num+"|"+name+"|"+addr);
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
	}
}
