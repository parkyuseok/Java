package test.main;

import test.maypac.Computer;
import test.maypac.Cpu;
import test.maypac.HardDisk;
import test.maypac.Memory;
import test.maypac.NoteBook;

public class MainClass03 {
	public static void main(String[] args) {
		// 1. useComputer() 메소드를 호출해 보세요.
		MainClass03.useComputer(new Computer(new Cpu()));
		// 2. useNoteBook() 메소드를 호출해 보세요.
		MainClass03.useNoteBook(new NoteBook(new Cpu(), new Memory(), new HardDisk()));
	}
	
	public static void useComputer(Computer c) {
		System.out.println("useComputer() 호출됨");
	}
	public static void useNoteBook(NoteBook n) {
		System.out.println("useNoteBook() 호출됨");
	}
}
