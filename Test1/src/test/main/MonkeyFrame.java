package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MonkeyFrame extends JFrame implements ActionListener{
	// 생성자
	public MonkeyFrame(String title) {
		super(title);
		// 프레임의 x, y, width, height
		setBounds(200, 200, 300, 300);
		// 프레임이 화면에 보이도록
		setVisible(true);
		// 프레임을 닫았을 때 프로세스 종료 되도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 레이아웃 법칙 지정하기
		setLayout(new BorderLayout());
		
		JButton btn=new JButton("삭제");
		add(btn, BorderLayout.EAST);
		// 버튼에 액션 리스너 등록하기
		btn.addActionListener(this);
		// 버튼에 액션 command 등록
		btn.setActionCommand("delete");
	}
	public static void main(String[] args) {
		new MonkeyFrame("원숭이");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("delete")) {
			
		}else if(command.equals("update")) {
			
		}
	}
}
