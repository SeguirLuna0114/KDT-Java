import java.awt.*;
import java.awt.event.*;

public class GridLayoutTest {
    private Frame f;
    private Button b1, b2, b3, b4, b5;

    public GridLayoutTest() {
	// 프레임 객체 생성
	f = new Frame( "GridLayout" );

	// 버튼 생성
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

	// Panel 생성
	Panel p = new Panel();
		
	// Panel의 LayoutManager를 지정한 후 버튼을 붙임
//	GridLayout g = new GridLayout( 2, 2 );
//	p.setLayout(g);
	p.setLayout(new GridLayout( 3, 2 ));
	p.add( b1 );
	p.add( b2 );
	p.add( b3 );
	p.add( b4 );
	p.add( b5 );

	// Panel을 Frame의 중앙에 붙임
	f.add( p, "Center" );
		
	// 프레임의 크기를 결정한후, 화면에 출력
	f.setSize( 300, 200 );
	f.setVisible( true );
	}//생성자 end

	public static void main( String[] args ) {
		GridLayoutTest gt = new GridLayoutTest();
	}
}
