package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	// 생성자
	public MyFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		setBounds(100, 100, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프레임에 버튼 추가
		JButton downBtn=new JButton("다운로드");
		add(downBtn, BorderLayout.NORTH);
		// 1. 버튼에 ActionListener 등록
		downBtn.addActionListener(this);
	}
	public static void main(String[] args) {
		MyFrame f=new MyFrame("MyFrame"); // 문자를 전달하고 싶을 때 "MyFrame" -> 생성자 필요
	}
	@Override
	public void actionPerformed(ActionEvent arg0) { // mainthread
		// 버튼에 ActionListener 등록하고 버튼을 누르면 실행 순서가 여기로 들어온다.
		JOptionPane.showMessageDialog(this, "다운로드 시작됨");
		// Thread 객체 만들어서 start!
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 새로운 스레드에서 다운로드 작업을 한다.
				String data=download();
				System.out.println("다운로드 결과:"+data);
			}
		}).start();
	}
	// 가상의 다운로드를 하는 메소드
	public String download() {
		// 작업이 끝나는데 10초가 걸린다고 가정하자
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String data="html, css, javascript, image ...";
		return data;
	}
}
