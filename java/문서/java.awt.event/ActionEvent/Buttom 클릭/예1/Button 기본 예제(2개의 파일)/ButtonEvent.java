import java.awt.*;
import java.awt.event.*;

public class ButtonEvent {	   
    private Frame f;   
    private Button push;

    public ButtonEvent() {	
	f = new Frame( "ActionEvent" );	
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});	

	push = new Button( "PUSH" );	

// 버튼에 Event Listener를 등록시킴
	ButtonEventHandler my = new ButtonEventHandler();
	push.addActionListener( my );
	
	f.setLayout( new FlowLayout() );
	f.add( push );	
	f.setSize( 200, 100 );
	f.setVisible( true );
    }

    public static void main( String[] args ) {
		ButtonEvent be = new ButtonEvent();
    }
}
