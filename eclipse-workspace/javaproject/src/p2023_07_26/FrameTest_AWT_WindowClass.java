package p2023_07_26;

// Java AWT(Abstract Window Toolkit) 사용 => GUI 프로그램 생성
// AWT는 Java의 구식 GUI 라이브러리 => 최신의 JavaFX나 Swing라이브러리 사용 권장
import java.awt.Color;		// AWT에서 색상을 다루기 위한 클래스
import java.awt.Frame;		// 윈도우 프레임 생성을 위한 클래스
import java.awt.event.WindowAdapter;	// 윈도우 이벤트 처리를 위한
import java.awt.event.WindowEvent;		// 윈도우 이벤트를 나타내는

// 기본적인 윈도우 생성 및 설정 + 윈도우 프로그램 종료 설정 방법
public class FrameTest_AWT_WindowClass {

	// Frame클래스의 객체 f를 선언 => 윈도우를 생성하고 조작
	private Frame f;

	// 생성자
	public FrameTest_AWT_WindowClass() {
		
		// Frame클래스의 부모 클래스(Window)클래스로 부터 메소드를 상속받아 사용
		// 선언한 Frame클래스의 객체 f를 new연산자를 활용해 생성
		f = new Frame("Frame Test");
		
		// 윈도우 크기(픽셀단위) 설정
		f.setSize(400, 300);
		// 윈도우가 화면에 표시될 위치(좌표) 설정
		f.setLocation(100, 100);
		// 윈도우의 배경색 설정
		f.setBackground(Color.green);
		
		// 윈도우가 화면에 보이게 설정(true)
		f.setVisible(true);
		// 윈도우 크기 변경 불가하게 설정(false)
		f.setResizable(false);

		// 윈도우 닫기 버튼 설정
		f.addWindowListener(new WindowAdapter() {
			// WindowAdapter를 사용하여 필요한 메소드만 오버라이딩
			
			// 윈도우 닫기버튼 클릭시, 호출되는 메소드
			public void windowClosing(WindowEvent e) {
				System.exit(0);	// 프로그램 종료 메소드
			}
		});

	}// 생성자 end

	// 메인 메소드
	public static void main(String[] args) {
		// FrameTest_AWT_WindowClass 클래스의 객체ft선언
		FrameTest_AWT_WindowClass ft = new FrameTest_AWT_WindowClass();
	}
}