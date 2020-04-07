package test.frame5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JTextField inputText;
	public MyFrame(String title) { // 생성자의 인자로 프레임의 제목을 전달받아서
		super(title); // 부모 생성자에 전달한다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// x, y, width, height 를 한번에 지정하기
		setBounds(200, 200, 500, 500);
		// 레이아웃 설정하기
		setLayout(new BorderLayout());
		
		JButton btn1=new JButton("NORTH");
		JButton btn2=new JButton("EAST");
		JButton btn3=new JButton("SOUTH");
		JButton btn4=new JButton("WEST");
		JButton btn5=new JButton("CENTER");
		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.EAST);
		add(btn3, BorderLayout.SOUTH);
		add(btn4, BorderLayout.WEST);
		add(btn5, BorderLayout.CENTER);

		// 화면에 보이게 하기	
		setVisible(true);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame a=this;
		JFrame b=this;
		ActionListener c=this;
		Frame d=this;
		Window g=this;
		Container e2=this;
		Component f=this;
		Object h=this; // this가 받을 수 있는 type
		
		JButton btn=new JButton();
		btn.addActionListener(this);
		
		JOptionPane.showMessageDialog(this, "삭제합니다.");

	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
