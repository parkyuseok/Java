package test.main;
// DB 연동하기 위한 Class
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // insert, update, delete, select 해주는 객체
import java.sql.ResultSet; // insert, update, delete, select 된 객체를 담아주는 객체

/*
 *  Java DataBase Connectivity (JDBC) 자바 데이터베이스 연결
 *  
 *  - oracle 에 연결하기  위해서는 ojdbc6.jar 파일이 필요하다. // 오라클에서 배포함
 */
public class MainClass01 {
	public static void main(String[] args) {
		//DB 연결객체를 담을 지역변수
		Connection conn=null; // Connection 객체를 얻어와야지만 DB에 연동할 수 있다.
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속 할 DB 정보
			String url="jdbc:oracle:thin:@localhost:1521:xe"; // (java app이 돌아가는 컴퓨터, DB ip주소, 127.0.0.1):port번호:DB명
			// 접속하고 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성송");
		}catch(Exception e) {
			e.printStackTrace();
		}//try~catch
		
		// emp 테이블의 사원번호, 사원이름, 급여 select 해보기
		PreparedStatement pstmt=null; // sql문을 대신 실행해주는 객체 
		ResultSet rs=null;            // PreparedStatement, ResultSet 필요하다.
		try {
			// 실행할 SQL 문
			String sql="SELECT empno, ename, sal FROM emp";
			// Connection 객체의 메소드를 이용해서 PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql); // pstmt는 sql문을 대신 실행해주는 객체
			// select 문 수행하고 결과를 ResultSet 으로 받아오기
			rs=pstmt.executeQuery(); // Select의 결과는 ResultSet에 담긴다. // Select 해주는 메소드 executeQuery
			// 반복문 돌면서 ResultSet 객체에 들어 있는 정보를 출력하기
			while(rs.next()) { // ResultSet의 사용법.
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int sal=rs.getInt("sal");
				System.out.println(empno+"|"+ename+"|"+sal);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
