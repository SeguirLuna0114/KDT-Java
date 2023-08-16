import java.awt.*;
import java.awt.event.*;

public class WindowEventTest implements WindowListener {
    private Frame f;
	
    public WindowEventTest() {
	f = new Frame( "WindowEvent Test" );

	f.setSize( 400, 300 );
	f.setVisible( true );

	f.addWindowListener( this );
    }// 생성자 end

    // 윈도우가 활성화 되었을 때 호출되는 메소드
    public void windowActivated( WindowEvent we ) {
		System.out.println( "윈도우가 활성화 되었습니다" );
    }

    // 윈도우가 닫힌 후에 호출되는 메소드
    public void windowClosed( WindowEvent we ) {
		System.out.println( "윈도우가 닫혔습니다" );
    }

    // 윈도우의 종료 아이콘을 눌렀을 때 호출되는 메소드
    public void windowClosing( WindowEvent we ) {
		System.out.println( "윈도우가 닫히려 합니다" );
		System.exit( 0 );
    }

    // 윈도우가 비활성화되었을 때 호출되는 메소드
    public void windowDeactivated( WindowEvent we ) {
		System.out.println("윈도우가 비활성화 되였습니다.");
    }

    // 윈도우가 아이콘화 되었다가 다시 활성화되었을 때 호출
	// 되는 메소드
    public void windowDeiconified( WindowEvent we ) {
		System.out.println("윈도우가 작업 표시줄에서 다시 나타났습니다" );
    }

    // 윈도우가 아이콘화되었을 때 호출되는 메소드
    public void windowIconified( WindowEvent we ) {
		System.out.println("윈도우가 작업 표시줄에 숨었습니다");
    }

    // 윈도우가 처음 실행될 때 호출되는 메소드
    public void windowOpened( WindowEvent we ) {
		System.out.println("윈도우가 화면에 처음 나타났습니다");
    }

    public static void main( String[] args ) {
		WindowEventTest wet = new WindowEventTest();
    }
}
