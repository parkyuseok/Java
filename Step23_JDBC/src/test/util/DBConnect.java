package test.util;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 *  Connection 객체의 참조값을 얻어와서 리턴해주는 객체를 생성하기 위한 클래스
 */
public class DBConnect {
	// 필드
	private Connection conn;  //
	// 생성자
	public DBConnect() { // new 할 때 여기로 실행 순서 들어옴
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속 할 DB 정보
			String url="jdbc:oracle:thin:@localhost:1521:xe"; // localhost(내 컴퓨터, ip주소):port번호:DB명
			// 접속하고 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger"); // 생성 할 때 필드에 저장된다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}//try~catch
	}
	// Connection 객체를 리턴해주는 메소드
	public Connection getConn() { // return type Connection
		return conn;
	}
}
