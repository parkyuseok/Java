package test.json;

import org.json.JSONObject;

public class MainClass02 {
	public static void main(String[] args) {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("num", 1);
		jsonObj.put("name", "김구라");
		jsonObj.put("isMan", true);
		
		String result=jsonObj.toString(); // jsonObj에 모아 놓은  obj 스트링화 시키는 것 
		System.out.println(result);
	}
}
