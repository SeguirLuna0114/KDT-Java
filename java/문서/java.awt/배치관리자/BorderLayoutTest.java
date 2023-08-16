import java.awt.*;
import java.awt.event.*;

public class BorderLayoutTest {
    private Frame f;
    private Button b1, b2, b3, b4, b5;

    public BorderLayoutTest() {
	// Frame 객체 생성
	f = new Frame( "버튼" );

	// 버튼 컴포넌트 생성
	b1 = new Button( "Button1" );
	b2 = new Button( "Button2" );
	b3 = new Button( "Button3" );
	b4 = new Button( "Button4" );
	b5 = new Button( "Button5" );

	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit(0);
	    }
	});

	// 버튼을 프레임에 붙임
	f.add( b1, "East" );
	f.add( b2, BorderLayout.WEST );
	f.add( b3, BorderLayout.NORTH );
	f.add( b4, BorderLayout.SOUTH );
	f.add( b5, BorderLayout.CENTER );

	// 프레임의 크기를 설정하고, 화면에 출력함
	f.setSize( 300, 300 );
	f.setVisible( true );
    }// 생성자 end

	public static void main( String[] args ) {
		BorderLayoutTest fb = new BorderLayoutTest();
	}
}
