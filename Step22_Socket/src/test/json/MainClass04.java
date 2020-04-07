package test.json;

import org.json.JSONObject;

public class MainClass04 {
	public static void main(String[] args) {
		// json 문자열 만들기
		String json="{\"num\":1,\"name\":\"김구라\", \"isMan\":true}"; // 자바에서 중괄호 안에 ""못 넣으므로 역슬레쉬 사용해줌.
		// json 문자열을 이용해서 JSONObject 만들기
		JSONObject jsonObj=new JSONObject(json);
		int num=jsonObj.getInt("num");
		String name=jsonObj.getString("name");
		boolean isMan=jsonObj.getBoolean("isMan");
		System.out.println(num);
		System.out.println(name);
		System.out.println(isMan);
	}
}
