package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		// 한명의 회원 정보를 얻어오고 싶다. SELECT!!! -> ResultSet이 필요하다
		int num=1; // 1번 회원

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="Select num, name, addr"
					+ " From member"
					+ " Where num=?";
			pstmt=conn.prepareStatement(sql);
			// ?에 값 바인딩 하기
			pstmt.setInt(1, num);
			// sql 문 수행하고 select 결과값을 ResultSet 으로 받아오기
			rs=pstmt.executeQuery();
			while(rs.next()) {
				// 커서가 위치한 곳에서 "name" 칼럼에 있는 문자열 읽어오기
				String name=rs.getString("babo"); // (칼럼명) // 만약에  as 칼럼명을 바꾸면 getString("별칭")
				// 커서가 위치한 곳에서 "addr" 칼럼에 있는 문자열 읽어오기
				String addr=rs.getString("addr");
				
				System.out.println(num+"|"+name+"|"+addr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close(); // 사용한 객체는 마무리 해줘야 함(얻어 온 순서의 역순)
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
	}
}
