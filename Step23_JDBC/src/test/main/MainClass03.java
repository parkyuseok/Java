package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass03 {
	public static void main(String[] args) {
		int num=3;
		String name="원숭이";
		String addr="상도동";
		// 위의 정보를 member 테이블에 insert 하기
		// 필요한 객체를 import하고 선언해주기.
		Connection conn=null;
		PreparedStatement pstmt=null;
		// ResultSet rs=null;은 select를 안하므로 안해줘도됨.
		int flag=0;
		try {
			//DB 연결
			conn=new DBConnect().getConn();
			// 실행할 sql 문의 뼈대 구성하기
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(?, ?, ?)"; // 무조건 물음표만 가능
			// sql 문을 수행할 PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql); // (준비된 스테이트먼트의 참조값을 넣어준다.)
			// 미완성 된 sql문이므로 ?에 필요한 값 바인딩 하기
			pstmt.setInt(1, num); // 첫번째 ?에 문자를 바인딩 하겠다. 	//실수는 setdouble
			pstmt.setString(2, name);
			pstmt.setString(3, addr); // 숫자는 물음표 앞에서 부터 순서
			// sql 문 실행하기 
			// executeUpdate() 메소드는 변화된 row의 갯수를 return한다.
			flag=pstmt.executeUpdate(); // insert하거나 delete하면 row의 갯수가 변화 한다. // 영향받은 갯수가 없으면 0이 return이 된다.
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) { // 성공 // 영향받은 갯수가 없으면 0이 return이 된다.
			System.out.println("회원정보를 성공적으로 추가 했습니다.");
		}else { // 실패
			System.out.println("회원정보를 추가하는데 실패했습니다.");
		}
	}
}
