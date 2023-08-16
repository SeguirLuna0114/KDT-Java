import java.awt.*;
import java.awt.event.*;

public class MouseEventTest implements MouseListener {
    private Frame f;
    private Button button;

    public MouseEventTest() {
	f = new Frame( "Mouse Event" );
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) { 
	        System.exit( 0 );
	    }
	});

	button = new Button( "Button" );	

	f.add( button, "Center" );
	f.setSize( 200, 100 );
	f.setVisible( true );

	// 버튼 객체에 EventListener를 등록시킴
	button.addMouseListener( this );
    }//생성자 end

    // 마우스가 클릭된 다음에 호출되는 메소드
    public void mouseClicked( MouseEvent me ) {
		System.out.println( "Mouse Cliceked" );
    }

    // 마우스가 컴포넌트 안으로 들어 왔을 때 호출되는 메소드
    public void mouseEntered( MouseEvent me ) {
		System.out.println( "Mouse Entered" );
    }

    // 마우스가 컴포넌트 밖으로 나갔을 때 호출되는 메소드
    public void mouseExited( MouseEvent me ) {
		System.out.println( "Mouse Exited" );
    }

    // 마우스로 컴포넌트를 눌렀을 때 호출되는 메소드
    public void mousePressed( MouseEvent me ) {
		System.out.println( "Mouse Pressed" );
    }

    // 마우스로 컴포넌트를 누른 후에 떼었을 때 호출되는 메소드
    public void mouseReleased( MouseEvent me ) {
		System.out.println( "Mouse Released" );
    }

    public static void main( String[] args ) {
		MouseEventTest met = new MouseEventTest();
    }
}
