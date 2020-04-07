package test.member.dto;
/*
 *  Data Transfer Object
 */
public class MemberDto {
	//데이터를 저장할 필드를 private로 선언
	private int num;
	private String name;
	private String addr;
	
	// 디폴트 생성자
	public MemberDto() {}
	// 모든 필드의 값을 생성자의 인자로 전달 받은 생정자 generate! // 마우스 우클릭 -> Source -> Generate Constructor using Fields -> Check 후 Generate
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	// field가 private 이므로
	// (접근 메소드) Generate 해야함.
	// 번호 값을 넣어주는 메소드 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	// Getters and Setters
}
