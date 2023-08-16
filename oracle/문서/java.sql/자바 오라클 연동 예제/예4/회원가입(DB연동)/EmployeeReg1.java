package p2018_11_13;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class EmployeeReg1 implements ActionListener {

	Frame f;
	Label name, sex, jumin, hyphen, address, hobby, buseo, intro;
	TextField tfName, tfJumin1, tfJumin2, tfAddress;
	CheckboxGroup fm;
	Checkbox cbMale, cbFemale;
	Checkbox cbSport, cbMusic, cbMovie, cbComp;
	Choice bu;
	TextArea ta;
	Button b1, b2;
	Panel p1, p2, p3, p4, p4_1, p5, p6, p7, p8, p9;
	int cnt;

	public EmployeeReg1() {
		f = new Frame("사원등록");

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		name = new Label("성명");
		sex = new Label("성별");
		jumin = new Label("주민등록번호");
		hyphen = new Label("-");
		address = new Label("주소");
		hobby = new Label("취미");
		buseo = new Label("부서명");
		intro = new Label("자기소개");

		tfName = new TextField(18);
		tfJumin1 = new TextField(13);
		tfJumin2 = new TextField(14);
		tfAddress = new TextField(34);

		fm = new CheckboxGroup();
		cbMale = new Checkbox("남", fm, false);
		cbFemale = new Checkbox("여", fm, false);

		cbSport = new Checkbox("운동", true);
		cbMusic = new Checkbox("음악감상");
		cbMovie = new Checkbox("영화");
		cbComp = new Checkbox("컴퓨터");

		bu = new Choice();
		bu.add("부서명 선택");
		bu.add("기획부");
		bu.add("영업부");
		bu.add("총무부");

		ta = new TextArea(10, 40);

		b1 = new Button("저장");
		b2 = new Button("종료");

		p1 = new Panel();
		p1.setLayout(new GridLayout(5, 1, 0, 20));
		p1.add(name);
		p1.add(jumin);
		p1.add(address);
		p1.add(buseo);
		p1.add(hobby);

		p2 = new Panel();
		p2.add(tfName);
		p2.add(sex);
		p2.add(cbMale);
		p2.add(cbFemale);

		p3 = new Panel();
		p3.add(tfJumin1);
		p3.add(hyphen);
		p3.add(tfJumin2);

		p4 = new Panel();
		p4.add(tfAddress);

		p4_1 = new Panel();
		p4_1.add(bu);

		p5 = new Panel();
		p5.add(cbSport);
		p5.add(cbMusic);
		p5.add(cbMovie);
		p5.add(cbComp);

		p6 = new Panel();
		p6.setLayout(new GridLayout(5, 1, 0, 10));
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(bu);
		p6.add(p5);

		p7 = new Panel();
		p7.add(p1);
		p7.add(p6);

		p8 = new Panel();
		p8.setLayout(new BorderLayout());
		p8.add(intro, "North");
		p8.add(ta, "Center");

		p9 = new Panel();
		p9.add(b1);
		p9.add(b2);

		f.add(p7, "North");
		f.add(p8, "Center");
		f.add(p9, "South");

		f.setSize(400, 600);
		f.setBackground(Color.yellow);
		f.setLocation(400, 100);
		f.setVisible(true);
		f.setResizable(false);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}// 생성자

	// 회원 가입
	public void memberInput() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";

		String gender = null;
		if (cbMale.getState()) {
			gender = "남자";
		} else {
			gender = "여자";
		}
		String sports = null;
		String music = null;
		String movie = null;
		String computer = null;
		if (cbSport.getState())	sports = "운동";
		if (cbMusic.getState())	music = "음악감상";
		if (cbMovie.getState())	movie = "영화";
		if (cbComp.getState())	computer = "컴퓨터";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");

			sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tfName.getText());
			pstmt.setString(2, gender);
			pstmt.setString(3, tfJumin1.getText());
			pstmt.setString(4, tfJumin2.getText());
			pstmt.setString(5, tfAddress.getText());
			pstmt.setString(6, bu.getSelectedItem());
			pstmt.setString(7, sports);
			pstmt.setString(8, music);
			pstmt.setString(9, movie);
			pstmt.setString(10, computer);
			pstmt.setString(11, ta.getText());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(f, "회원가입 성공");
			} else {
				JOptionPane.showMessageDialog(f, "회원가입 실패");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, "데이터베이스 연결 실패");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}

	}

	public int check() {
		cnt = 0;
		if (cbSport.getState())
			cnt++;
		if (cbMusic.getState())
			cnt++;
		if (cbMovie.getState())
			cnt++;
		if (cbComp.getState())
			cnt++;

		return cnt;
	}

	public void memberCheck() {
		if (tfName.getText().equals("")) { // 성명
			JOptionPane.showMessageDialog(f, "성명을 입력 하세요~~!!");
		} else if (cbMale.getState() != true && cbFemale.getState() != true) {
			JOptionPane.showMessageDialog(f, "남자 여자중 하나를 선택하세요~~!!");
		} else if (tfJumin1.getText().equals("")) {
			JOptionPane.showMessageDialog(f, "주민번호 앞자리를 입력하세요");
		} else if (tfJumin1.getText().length() != 6) {
			JOptionPane.showMessageDialog(f, "주민번호 앞자리는 6자리 입니다.");
			tfJumin1.setText("");
		} else if (tfJumin2.getText().equals("")) {
			JOptionPane.showMessageDialog(f, "주민번호 뒷자리를 입력하세요");
		} else if (tfJumin2.getText().length() != 7) {
			JOptionPane.showMessageDialog(f, "주민번호 앞자리는 7자리 입니다.");
			tfJumin2.setText("");
		} else if (tfAddress.getText().equals("")) {
			JOptionPane.showMessageDialog(f, "주소를 입력 하세요~!!");
		} else if (bu.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(f, "부서명을 선택 하세요~~!!");
		} else if (check() < 2) {
			JOptionPane.showMessageDialog(f, "취미는 2개이상 선택 하셔야 합니다.");
		} else if (ta.getText().equals("")) {
			JOptionPane.showMessageDialog(f, "자기 소개를 입력 하세요~~!!");
		} else {
			memberInput();
//			JOptionPane.showMessageDialog(f, "회원가입 성공");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) { // 저장
			memberCheck();
		} else if (e.getSource() == b2) { // 종료
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		EmployeeReg1 er = new EmployeeReg1();
	}
}
