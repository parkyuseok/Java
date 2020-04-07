package test.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainClass08 {
	public static void main(String[] args) {
		String info="{\"num\":1, \"friends\": [10, 20, 30]}";
		JSONObject obj=new JSONObject(info);
		JSONArray arr=obj.getJSONArray("friends"); // ("friends") = String key 값
		for(int i=0; i<arr.length(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
