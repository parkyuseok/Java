package test.json;

public class MainClass05 {
	public static void main(String[] args) {
		String info="num:1, name:김구라, addr:노량진";
		// 위의 문자열에서 회원의 정보를 추출해서 변수에 담아 보세요.
		int num=0;
		String name=null;
		String addr=null;
		
		String[] result=info.split(","); // , 기준으로 0,1,2번방으로 나눔
		
		num=Integer.parseInt(result[0].split(":")[1]); // : 기분으로 0,1 번방 나눔
		name=result[1].split(":")[1];
		addr=result[2].split(":")[1];
	}
}
