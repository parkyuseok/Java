package test.main;

public class MainClass05 {
	public static void main(String[] args) {
		// 1. 정수를 저장할수 있는 방 100개짜리 배열을 만들고
		int[] nums=new int[100];
		// 2. 반복문을 활용해서 배열의 방에 1~100까지 순서대로 정수를 저장하고
		for(int i=0; i<100; i++) {
			nums[i]=i+1;
			// 3. 반복문을 활용해서 배열에 저장된 정수 중에서 7의 배수를 모두 출력해 보세요.
				}
		for(int tmp:nums) {
			if(tmp%7==0) {
				System.out.println("7의 배수:"+tmp);
			}		
		}
	}
}
