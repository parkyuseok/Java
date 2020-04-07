package test.frame2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener {
	private JButton saveBtn, deleteBtn; // 같은 타입으면 ,로 한줄에 선언 가능
	public MyFrame(String title) { // 생성자의 인자로 프레임의 제목을 전달받아서
		super(title); // 부모 생성자에 전달한다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// x, y, width, height 를 한번에 지정하기
		setBounds(200, 200, 300, 300);
		// 기본 레이아웃으로 동작하게 하기
		setLayout(null);
		// 화면에 보이게 하기	
		setVisible(true);
		
		// 버튼
		saveBtn=new JButton("저장");
		deleteBtn=new JButton("삭제");		
		// x, y, width, height 를 한번에 지정
		saveBtn.setBounds(10, 10, 100, 40);
		deleteBtn.setBounds(110, 10, 100, 40);
		// 버튼을 프레임에 추가 하기
		add(saveBtn);
		add(deleteBtn);
		// 버튼에 리스너 등록하기
		saveBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 메소드에 전달된 ActionEvent 객체에 발생한 이벤트의 정보가 들어 있다.
		if(e.getSource()==saveBtn) {
			JOptionPane.showMessageDialog(this, "저장합니다.");
		}else if(e.getSource()==deleteBtn) {
			JOptionPane.showMessageDialog(this, "삭제합니다.");			
		}
		// Object obj=e.getSource(); // 눌러진 버튼의 참조값이 리턴된다.
	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
