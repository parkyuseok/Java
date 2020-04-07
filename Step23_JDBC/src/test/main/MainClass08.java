package test.main;

import java.util.HashMap;
import java.util.Map;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		// 새로 추가 할 회원의 정보이다.
		int num=10;
		String name="돼지"; 
		String addr="독산동";
		// 3개의 정보를 HashMap 객체에 담기?
		Map<String, Object> map = new HashMap<>();
		// (String Key type, Object Value type)
		// ("a", num); 이렇게 적어도 됨 but 의미있게 지어주는게 좋음
		map.put("num", num);
		map.put("name", name);
		map.put("addr", addr);
		
		// 저장 할 회원의 정보를 MemberDto 객체에 담기
		MemberDto dto=new MemberDto(num, name, addr);
		
		MemberDao dao=new MemberDao();
		// dao.insert(num, name, addr);
		// dao.insert(map);
		
		// insert() 메소드를 이용해서 회원정보를 추가 하고 성공여부를 리턴 받는다.
		boolean isSuccess=dao.insert(dto);
		
		if(isSuccess) {
			System.out.println("회원 정보를 추가 했습니다.");
		}else {
			System.out.println("회원 정보 추가 실패");
		}
	}
}
