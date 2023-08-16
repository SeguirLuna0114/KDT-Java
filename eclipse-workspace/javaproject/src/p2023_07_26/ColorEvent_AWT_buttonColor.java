package p2023_07_26;

import java.awt.*;
import java.awt.event.*;

// Java AWT를 사용하여 두개의 버튼을 가진 윈도우 생성
// 버튼 클릭하여 윈도우의 배경색 변경 예제
class ColorEvent_AWT_buttonColor implements ActionListener {

	// Frame클래스의 객체f 선언 => 윈도우 생성 및 조작
	Frame f;
	// 버튼 객체 선언
	Button redBtn, blueBtn;

	// 생성자 - 클래스가 객체화 될 때 호출됨
	public ColorEvent_AWT_buttonColor() {
		
		// Frame객체(f)를 생성하여 윈도우 만들고 설정
		f = new Frame("Event Test");

		// 윈도우 닫기버튼 누르면 프로그램 종료하도록
		f.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		redBtn = new Button("RED");
		blueBtn = new Button("BLUE");

		// 윈도우 레이아웃을 FlowLayout으로 설정하여 버튼이 순서대로 배치되게 함
		f.setLayout(new FlowLayout());
		f.add(redBtn);
		f.add(blueBtn);

		// 윈도우 크기 설정 및 화면에 보이게 설정
		f.setSize(300, 200);
		f.setVisible(true);

		// 두개의 버튼에 addActionListener()메서드를 호출하여 이벤트 처리하도록
		// this를 매개변수로 넘겨줘 현재 클래스의 객체가 액션이벤트 처리 가능하게
		redBtn.addActionListener(this);
		blueBtn.addActionListener(this);
	}// 생성자 끝

	// ActionListener 인터페이스 구현한 메소드
	public void actionPerformed(ActionEvent e) {
		// java.util.EventObject;
		
		// e.getSource()를 통해 이벤트가 발생한 객체 가져옴
		if (e.getSource() == redBtn) {
			// 빨간 버튼 클릭시
			f.setBackground(new Color(255, 0, 0));
		} else if (e.getSource() == blueBtn) {
			// 파란버튼 클릭시
			f.setBackground(Color.blue);
		}

// java.awt.event.ActionEvent; 
		/*
		 * if(e.getActionCommand()=="빨간색"){ f.setBackground(Color.red); } else {
		 * f.setBackground(Color.blue); }
		 */
	}

	// 메인메소드
	public static void main(String[] args) {
		// ColorEvent_Implement_ActionListener의 인스턴스를 생성하여 GUI 프로그램을 시작
		ColorEvent_AWT_buttonColor ce = new ColorEvent_AWT_buttonColor();
	}

}