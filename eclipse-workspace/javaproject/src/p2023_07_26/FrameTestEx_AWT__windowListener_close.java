package p2023_07_26;

import java.awt.*;
import java.awt.event.*;

// Java의 AWT(Abstract Window Toolkit)를 사용하여 기본적인 창(Frame)을 생성
//  Frame 클래스 : 윈도우 시스템에서의 기본적인 창을 나타내는 클래스

// FrameTestEx클래스는 'Frame'클래스를 상속받음
// => 부모 클래스(Frame클래스)의 모든 기능과 속성을 상속받아 사용 가능
public class FrameTestEx_AWT__windowListener_close extends Frame {

	// 생성자
	public FrameTestEx_AWT__windowListener_close() {	// 객체 생성시 호출되는 코드
		// 해당 창의 기본설정과 동작을 정의
		
		// 자신의 부모 클래스가 "Frame"클래스 이기에, 자신의 부모클래스를 호출하라는 의미
//		f = new Frame( "Frame Test" );
		
		super("Frame Test");

		// addWindowListener 메서드 - 창의 이벤트를 처리하는 리스너 추가
		addWindowListener(new WindowAdapter() {
			// WindowAdapter클래스를 익명 내부 클래스로 생성
			// WindowAdapter
			// : WindowListener 인터페이스의 추상 메서드들을 미리 빈 메서드로 구현한 클래스
			// 	 따라서 필요 메서드만 재정의해 사용가능하게 해줌
			
			// windowClosing 메서드는 창이 닫히는 이벤트 처리
			public void windowClosing(WindowEvent e) {
				// 사용자가 창을 닫을 때 windowClosing 이벤트가 발생
				// Syste.exit(0)을 호출하여 프로그램 종료
				System.exit(0);
			}
		});

		// 창 설정
		// setSize 메서드: 창의 크기를 해당 픽셀로 설정
		setSize(400, 300);
		// setLocation 메서드: 창이 화면에 표시될 위치 설정
		setLocation(100, 100);
		// setBackground 메서드: 창의 배경색을 설정
		setBackground(Color.green);
		
		// setVisible(true)를 호출 => 창을 화면에 표시
		setVisible(true);
		
	}// 생성자 end

	
	// 메인 메서드
	public static void main(String[] args) {
		
		// FrameTestEx 클래스의 객체를 생성하여 실행
		FrameTestEx_AWT__windowListener_close ft = new FrameTestEx_AWT__windowListener_close();
		// setVisible(true)에 의해 창이 화면에 표시됨
		
	}
}