package test.main;

import java.util.HashMap;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 *  회원 한명의 번호, 이름, 주소를 하나의 객체로 관리 하고 싶다면?
		 */
		HashMap<String, Object>mem=new HashMap<>(); // javascript에서 var mem={};과 같다.
		// key, value 의 쌍으로 데이터를 저장하고
		mem.put("num", 1);							// mem.num=1;
		mem.put("name", "김구라");					// mem.name="김구라";
		mem.put("addr", "노량진");					// mem.addr="노량진";
		// 불러올때는 Object type으로 리턴이 되니 원래 type 으로 Casting 한다.
		int num1=(int)mem.get("num");
		String name1=(String)mem.get("name");
		String addr1=(String)mem.get("addr");		
	}
}
