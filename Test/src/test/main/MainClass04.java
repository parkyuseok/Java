package test.main;

import java.util.ArrayList;

public class MainClass04 {
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i=0; i<100; i++) {
			al.add(i+1);
			System.out.println(al);
		}
	}
}
