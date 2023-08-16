import java.awt.*;
import java.awt.event.*;

public class FlowLayoutTest {
    private Frame f;
    private Button b1, b2, b3, b4, b5;

    public FlowLayoutTest() {
	// 프레임 객체 생성
	f = new Frame( "FlowLayout" );
		
	// 다섯 개의 버튼 객체들을 생성
	b1 = new Button( "Button1" );
	b2 = new Button( "Button2" );
	b3 = new Button( "Button3" );
	b4 = new Button( "Button4" );
	b5 = new Button( "Button5" );

	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    } 
	});

	// Panel을 생성한 후, 버튼들을 Panel에 붙임
	Panel p = new Panel();
	p.add( b1 );
	p.add( b2 );
	p.add( b3 );
	p.add( b4 );
	p.add( b5 );

	// Panel을 Frame의 Center에 붙임
	f.add( p, "Center" );
	
	// Frame의 사이즈를 결정하고 화면에 출력함
	f.setSize( 400, 100 );
	f.setVisible( true );
	}

	public static void main( String[] args ) {
	    FlowLayoutTest ft = new FlowLayoutTest();
	}
}
