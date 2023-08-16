import java.awt.*;
import java.awt.event.*;

public class WindowAdapterTest extends WindowAdapter {
    private Frame f;
	
    public WindowAdapterTest() {
	f = new Frame( "WindowEvent Test" );	

	f.setSize( 400, 300 );
	f.setVisible( true );

	f.addWindowListener( this );
    }
	
    // 윈도우가 활성화 되었을 때 호출되는 메소드
//    public void windowActivated( WindowEvent we ) {
//		System.out.println( "윈도우가 활성화 되었습니다" );
//    }
	// 윈도우의 종료 아이콘을 눌렀을 때 호출되는 메소드
    public void windowClosing( WindowEvent we ) {
		System.out.println( "윈도우가 닫히려 합니다" );
		System.exit( 0 );
    }
    public static void main( String[] args ) {
	  WindowAdapterTest wat = new WindowAdapterTest();
    }
}
