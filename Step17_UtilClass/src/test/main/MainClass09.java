package test.main;

import java.util.HashSet;
import java.util.Iterator;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 *  HashSet
		 *  
		 *  - 중복을 허용하지 않는다.
		 *  - 인덱스도 없고, 키값도 없다.
		 *  - 순서도 없다.
		 *  - 어떤 데이터를 중복을 허용하지 않는 묶음(집합)으로 관리 하고 싶을 때 사용한다.
		 *  - 자주 사용하진 않음.
		 */
		HashSet<String> lunch=new HashSet<>();
		lunch.add("자장면");
		lunch.add("샌드위치");		
		lunch.add("마라탕");		
		lunch.add("갈비");		
		lunch.add("김치찌게");		
		lunch.add("마라탕"); // 중복 허용하지 않으므로 5개만 들어간다.
		
		// 저장된 item 의 갯수
		int size=lunch.size();
		// Iterator 순서에 상관없이 cursor | 뒤에 데이터가 있으면 하나씩 빼낸다.
		Iterator<String> it=lunch.iterator();
		// 다음 데이터가 있으면
		while(it.hasNext()) { // 데이터가 있으면 true를 반환함.
			// 커서를 이동해서 해당 커서에 위치한 데이터 얻어오기
			String tmp=it.next();
			System.out.println(tmp);;
		}
	}
}
