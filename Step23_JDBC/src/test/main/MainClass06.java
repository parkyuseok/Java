package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		// 삭제할 회원의 정보라고 하자
		int num=1; // primary key로 삭제해야 함!
		
		// 위의 정보대로 회원정보를 수정하기
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="Delete From member"
					+ " Where num=?";
			pstmt=conn.prepareStatement(sql);
			// ?에 값 바인딩 하기
			pstmt.setInt(1, num);
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
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
}
