import java.awt.*;
import java.awt.event.*;

public class MouseAdapterTest extends MouseAdapter {
    private Frame f;
    private Button button;

    public MouseAdapterTest() {

	f = new Frame( "MouseAdapter Test" );
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) { 
		System.exit( 0 );
	    }
	});

	button = new Button( "확인" );	

	f.add( button, "Center" );

	f.setSize( 200, 100 );
	f.setVisible( true );

	// 버튼 객체에 EventListener를 등록 시킴
	button.addMouseListener( this );
    }//생성자 end

    // 마우스를 이용해 버튼을 눌렀을 때 호출되는 메소드
    public void mousePressed( MouseEvent me ) {
		System.out.println( button.getLabel() + 
								" 버튼이 눌려 졌음" );
    }

    public static void main( String[] args ) {
		MouseAdapterTest mat = new MouseAdapterTest();
    }
}
