package test.maypac;

public class Pen {
	// field
	private String color;
	// constructor
	public Pen(String color) {
		this.color=color;
	}
	// method
	public void write() {
		System.out.println(this.color+" 색 펜으로 필기를 해요!");
	}
}
