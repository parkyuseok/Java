package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

/*
 *  사원 번호, 사원이름, 부서명을 select 해서 콘솔창에 출력해 보세요.
 */

public class MainClass02 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null; // 작업한 뒤 close 해주는 것이 좋다.(finally절에서)
		try {
			conn=new DBConnect().getConn();
			// 실행할 SQL 문
			String sql="SELECT empno, ename, dname"
					+ " FROM emp, dept "
					+ " WHERE EMP.DEPTNO = DEPT.DEPTNO"
					+ " ORDER BY empno ASC";
			// Connection 객체의 메소드를 이용해서 PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql); // pstmt는 sql문을 대신 실행해주는 객체
			// select 문 수행하고 결과를 ResultSet 으로 받아오기
			rs=pstmt.executeQuery(); // Select의 결과는 ResultSet에 담긴다. // Select 해주는 메소드 executeQuery
			// 반복문 돌면서 ResultSet 객체에 들어 있는 정보를 출력하기
			while(rs.next()) { // ResultSet의 사용법.
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String dname=rs.getString("dname");
				System.out.println(empno+"|"+ename+"|"+dname);
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
