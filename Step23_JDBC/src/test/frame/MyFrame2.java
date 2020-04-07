package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MyFrame2 extends JFrame implements ActionListener {
	private JTextField insert1, insert2, insert3, delete, update;
	private JTextArea ta;
	private BufferedWriter bw;	// 문자열을 출력할 수 있는 객체
	private BufferedReader br;
	public MyFrame2(String title) {
		super(title); // 부모 생성자에 전달한다.
		initUI();// UI 준비하기
	}
	public void initUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// x, y, width, height 를 한번에 지정하기
		setBounds(600, 400, 800, 200);
		// 기본 레이아웃으로 동작하게 하기
		setLayout(new BorderLayout());
		// JTextField 객체의 참조값을 필드에 저장
		insert1=new JTextField(10);
		insert1.setBounds(10, 10, 90, 40);
//		add(insert1);
		insert2=new JTextField(10);
		insert2.setBounds(100, 10, 90, 40);
//		add(insert2);
		insert3=new JTextField(10);
		insert3.setBounds(190, 10, 90, 40);
//		add(insert3);
		// 회원 정보 입력 UI 만들기
		JLabel label1=new JLabel("Num");
		JLabel label2=new JLabel("Name");
		JLabel label3=new JLabel("Adress");
		JPanel jp=new JPanel();
		
		JButton insertBtn=new JButton("insert");
		JButton deleteBtn=new JButton("delete");
		JButton updateBtn=new JButton("update");
		JButton selectBtn=new JButton("select");
		
		// x, y, width, height 를 한번에 지정
		insertBtn.setBounds(290, 10, 100, 40);
		deleteBtn.setBounds(390, 10, 100, 40);
		updateBtn.setBounds(490, 10, 100, 40);
		selectBtn.setBounds(590, 10, 100, 40);
		
		// 버튼을 프레임에 추가 하기
		jp.add(label1);
		jp.add(insert1);
		jp.add(label2);
		jp.add(insert2);
		jp.add(label3);
		jp.add(insert3);
		jp.add(insertBtn);
		jp.add(deleteBtn);
		jp.add(updateBtn);
		jp.add(selectBtn);
		
		add(jp,BorderLayout.NORTH);
		
		// 버튼에 리스너 등록하기
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		selectBtn.addActionListener(this);
		// 버튼에 ActionCommand 추가하기
		insertBtn.setActionCommand("insert");
		deleteBtn.setActionCommand("delete");
		updateBtn.setActionCommand("update");
		selectBtn.setActionCommand("select");
		// JTextArea
		ta=new JTextArea();
		ta.setBounds(10, 50, 680, 500);
		add(ta,BorderLayout.CENTER);
		// 수정이나 포커스를 받지 못하도록 문자열 출력용으로 사용하기 // 커서 안나오고 출력용으로 사용하겠다!
		ta.setEditable(false);
		ta.setFocusable(false);
		//스크롤계층(JScrollPane)
		JScrollPane scPane=new JScrollPane(ta,	//textArea는 스크롤계층에 추가
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,		//수직 스크롤바는 항상
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//수평 스크롤바는 필요하다면
		//스크롤계층을 Frame에 추가
		add(scPane,BorderLayout.CENTER);
		// 화면에 보이게 하기	
		setVisible(true);
	}
	public void send() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("insert")) {
			int num=Integer.parseInt(insert1.getText());
			String name=insert2.getText();
			String addr=insert3.getText();
			MemberDto dto=new MemberDto(num, name, addr);
			test.frame.MemberDao dao=new test.frame.MemberDao();
			boolean isSuccess=dao.insert(dto);

			if(isSuccess) {
				System.out.println("회원 정보를 추가 했습니다.");
				JOptionPane.showMessageDialog(this, "회원 정보 추가 성공");
			}else {
				System.out.println("회원 정보 추가 실패");
				JOptionPane.showMessageDialog(this, "회원 정보 추가 실패");
			}
		}
		if(command.equals("delete")) {
			int num=Integer.parseInt(insert1.getText());
			test.frame.MemberDao dao=new test.frame.MemberDao();
			boolean isSuccess=dao.delete(num);
			
			if(isSuccess) {
				System.out.println("회원 정보를 삭제 했습니다.");
				JOptionPane.showMessageDialog(this, "회원 정보 삭제 성공");
			}else {
				System.out.println("회원 정보 삭제 실패");
				JOptionPane.showMessageDialog(this, "회원 정보 삭제 실패");
			}
		}
		if(command.equals("update")) {
			String num1=insert1.getText();
			int num=Integer.parseInt(num1);
			String name=insert2.getText();
			String addr=insert3.getText();
			MemberDto dto=new MemberDto(num, name, addr);
			test.frame.MemberDao dao=new test.frame.MemberDao();
			boolean isSuccess=dao.update(dto.getNum(), dto.getName(), dto.getAddr());
			
			if(isSuccess) {
				System.out.println("회원 정보를 수정 했습니다.");
				JOptionPane.showMessageDialog(this, "회원 정보 수정 성공");
			}else {
				System.out.println("회원 정보 수정 실패");
				JOptionPane.showMessageDialog(this, "회원 정보 수정 삭제");
			}
		}
		if(command.equals("select")) {
			test.frame.MemberDao dao=new test.frame.MemberDao();
			try {
				ta.setText("");
				ta.append(dao.select());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new MyFrame2("박유석 Frame");
	}
}
