package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import test.frame.MemberDao;
import test.frame.MemberDto;

public class MyFrame2 extends JFrame implements ActionListener, ListSelectionListener {
	private JTextField inputNum, inputName, inputAddr, delete, update;
	private JTextArea ta;
	JTable table;
	DefaultTableModel model;
	
	// 생성자
	public MyFrame2(String title) {
		super(title); // 부모 생성자에 전달한다.
		initUI(); // UI 준비하기
	}
	public void initUI() {
		// x, y, width, height 를 한번에 지정하기
		setBounds(600, 400, 800, 200);
		// 기본 레이아웃으로 동작하게 하기 (레이아웃 법칙 설정)
		setLayout(new BorderLayout());
		// main frame을 닫았을 때 process 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 테이블
		table=new JTable();
		// 칼럼명을 배열에 미리 준비하기
		String[] colNames= {"Num", "Name", "Addr"};
		// 모델(adapter 역활)
		model=new DefaultTableModel(colNames, 0) {
			@Override // isCell Ctrl+Space
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		// 모델을 테이블에 연결하기
		table.setModel(model);
		// 테이블을 감싸는 스크롤 계층을 만들고
		JScrollPane scPane=new JScrollPane(table);
		// 스크롤 계층을 프레임의 가운데에 붙이기
		add(scPane, BorderLayout.CENTER);
		
		ListSelectionModel selectionModel=table.getSelectionModel();
		selectionModel.addListSelectionListener(this); // actionListener 와 같은 역활
		
		// 회원 정보 입력 UI 만들기
		JLabel label1=new JLabel("Num");
		JLabel label2=new JLabel("Name");
		JLabel label3=new JLabel("Adress");
		
		// JTextField 객체의 참조값을 필드에 저장
		inputNum=new JTextField(10);
		inputName=new JTextField(10);
		inputAddr=new JTextField(10);
		// JTextFieid에 위치와 크기 설정
		inputNum.setBounds(10, 10, 90, 40);
		inputName.setBounds(100, 10, 90, 40);
		inputAddr.setBounds(190, 10, 90, 40);
		
		JButton insertBtn=new JButton("insert");
		JButton deleteBtn=new JButton("delete");
		JButton updateBtn=new JButton("update");
		JButton selectBtn=new JButton("select");
		
		// Button의 x, y, width, height 를 한번에 지정
		insertBtn.setBounds(290, 10, 100, 40);
		deleteBtn.setBounds(390, 10, 100, 40);
		updateBtn.setBounds(490, 10, 100, 40);
		selectBtn.setBounds(590, 10, 100, 40);
		
		
		// Panel 을 만들고
		JPanel jp=new JPanel();
		// (페널에 UI 나열하고) 버튼을 프레임에 추가 하기
		jp.add(label1);
		jp.add(inputNum);
		jp.add(label2);
		jp.add(inputName);
		jp.add(label3);
		jp.add(inputAddr);
		jp.add(insertBtn);
		jp.add(deleteBtn);
		jp.add(updateBtn);
		jp.add(selectBtn);
		// 페널을 프레임의 상단에 배치
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
//		ta=new JTextArea();
//		ta.setBounds(10, 50, 680, 500);
//		add(ta,BorderLayout.CENTER);
		// 수정이나 포커스를 받지 못하도록 문자열 출력용으로 사용하기 // 커서 안나오고 출력용으로 사용하겠다!
//		ta.setEditable(false);
//		ta.setFocusable(false);
//		//스크롤계층(JScrollPane)
//		JScrollPane scPane=new JScrollPane(ta,	//textArea는 스크롤계층에 추가
//				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,		//수직 스크롤바는 항상
//				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//수평 스크롤바는 필요하다면
//		//스크롤계층을 Frame에 추가
//		add(scPane,BorderLayout.CENTER);
//		
		// 화면에 보이게 하기 (마지막에 배치)	
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 command 문자열을 읽어와서
		String command=e.getActionCommand();
		if(command.equals("insert")) { // insert 버튼을 눌렀다면
			// 입력한 번호, 이름, 주소 읽어오기
			// 읽어 올려면 Textfield의 참조값 필요함
			int num=Integer.parseInt(inputNum.getText());
			String name=inputName.getText();
			String addr=inputAddr.getText();
			// MemberDto 객체에 담고
			MemberDto dto=new MemberDto(num, name, addr);
			// MemberDao 객체를 이용해서 DB에 저장하기
			test.frame.MemberDao dao=new test.frame.MemberDao();
			// 작업 성공 여부가 리턴된다.
			boolean isSuccess=dao.insert(dto);

			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "회원 정보 추가 성공");
			}else {
				JOptionPane.showMessageDialog(this, "회원 정보 추가 실패");
			}
		}
		if(command.equals("delete")) {
			int num=Integer.parseInt(inputNum.getText());
			test.frame.MemberDao dao=new test.frame.MemberDao();
			boolean isSuccess=dao.delete(num);
			
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "회원 정보 삭제 성공");
			}else {
				JOptionPane.showMessageDialog(this, "회원 정보 삭제 실패");
			}
		}
		if(command.equals("update")) {
			String num1=inputNum.getText();
			int num=Integer.parseInt(num1);
			String name=inputName.getText();
			String addr=inputAddr.getText();
			MemberDto dto=new MemberDto(num, name, addr);
			test.frame.MemberDao dao=new test.frame.MemberDao();
			boolean isSuccess=dao.update(dto.getNum(), dto.getName(), dto.getAddr());
			
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "회원 정보 수정 성공");
			}else {
				JOptionPane.showMessageDialog(this, "회원 정보 수정 삭제");
			}
		}
		if(command.equals("select")) {
				//DefaultTableModel 객체의 메소드를 이용해서 Table 에 출력된
				//데이터를 일단 모두 삭제한다.
				model.setRowCount(0);
				// 회원 목록 출력하기
				test.frame.MemberDao dao=new test.frame.MemberDao();
				List<test.frame.MemberDto> list=dao.select();
				for(test.frame.MemberDto tmp:list) {
					//MemberDto 에 들어있는 정보를 Vector<Object>  객체에 담는다.
					Vector<Object> v=new Vector<>();
					v.add(tmp.getNum());
					v.add(tmp.getName());
					v.add(tmp.getAddr());
					// Vector 객체를 DefaultTableMode1 객체에 전달해서 row를 추가
					model.addRow(v); // 반복문이 돌 때 마다 Vector 객체가 생성되서 Num, Name, Addr가 Row에 담긴다.
//				ta.setText("");
//				ta.append(dao.select());
				} 
			}
		}
	public static void main(String[] args) {
		new MyFrame2("박유석 Frame");
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// 선택된 row 의 인덱스 값 읽어오기
		int selectedRow=table.getSelectedRow();
		if(selectedRow==-1) {
			return;
		}
		int num=(int)table.getValueAt(selectedRow, 0);
		String name=(String)table.getValueAt(selectedRow, 1);
		String addr=(String)table.getValueAt(selectedRow, 2);
		// JTextField에 출력하기
		inputNum.setText(Integer.toString(num));
		inputName.setText(name);
		inputAddr.setText(addr);
	}
}