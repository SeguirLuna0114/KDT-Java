import java.awt.*;
import java.awt.event.*;

public class GridLayoutTest1 {
    private Frame f;
    private Button b1, b2, b3, b4;

    public GridLayoutTest1() {
	// 프레임 객체 생성
	f = new Frame( "GridLayout" );

	// 버튼 생성
	b1 = new Button( "Button1" );
	b2 = new Button( "Button2" );
	b3 = new Button( "Button3" );
	b4 = new Button( "Button4" );

	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    } 
	});

	// Panel 생성
	Panel p = new Panel();
		
	// Panel의 LayoutManager를 지정한 후 버튼을 붙임
	p.setLayout( new GridLayout( 2, 2, 10, 10 ));
	p.add( b1 );
	p.add( b2 );
	p.add( b3 );
	p.add( b4 );

	// Panel을 Frame의 중앙에 붙임
	f.add( p, "Center" );
		
	// 프레임의 크기를 결정한후, 화면에 출력
	f.setSize( 300, 200 );
	f.setVisible( true );
	}

	public static void main( String[] args ) {
		GridLayoutTest1 gt = new GridLayoutTest1();
	}
}
