import java.awt.*;
import java.awt.event.*;

public class MouseMotionListenerTest implements MouseMotionListener {
    private Frame f;
    private TextField xField;
    private TextField yField;
    private TextField state;
	private int xValue = 0, yValue = 0;
	
    // 화면 구성
    public MouseMotionListenerTest() {
	f = new Frame( "WindowEvent Test" );
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent we ) {
		System.exit( 0 );
	    }
	});	

	xField = new TextField( 10 );
	yField = new TextField( 10 );
	state = new TextField( 20 );

	Panel p = new Panel();
	p.add( state );
	p.add( new Label( "X좌표", Label.RIGHT ));
	p.add( xField );
	p.add( new Label( "Y좌표", Label.RIGHT ));
	p.add( yField );

	f.add( p, "South" );
		
	f.setSize( 600, 400 );
	f.setVisible( true );

	// Frame 객체에 MouseMotionListener를 등록
	f.addMouseMotionListener( this );

    }//생성자 end

    // 마우스를 드래그할 때 호출되는 메소드
    public void mouseDragged( MouseEvent me ) {
		state.setText( "Mouse Dragged" );

		// 마우스의 x, y 좌표를 읽어옴
		xField.setText( String.valueOf( me.getX()) );
		yField.setText( String.valueOf( me.getY()) );

		xValue=me.getX();
		yValue=me.getY();
//		repaint();
    }

    // 마우스를 움직일 때 호출되는 메소드
    public void mouseMoved( MouseEvent me ) {
		state.setText( "Mouse Moved" );

		xField.setText( String.valueOf( me.getX()) );
		yField.setText( String.valueOf( me.getY()) );		
    }	

    public static void main( String[] args ) {
		MouseMotionListenerTest mmt = new MouseMotionListenerTest();
    }
}
