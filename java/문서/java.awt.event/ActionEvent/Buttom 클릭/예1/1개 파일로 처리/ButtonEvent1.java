import java.awt.*;
import java.awt.event.*;

public class ButtonEvent1 implements ActionListener{	
    
    private Frame f;   
    private Button push;

    public ButtonEvent1() {
	
	f = new Frame( "ActionEvent" );	
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});	

	push = new Button( "PUSH" );
	
// 버튼에 Event Listener를 등록시킴
//	ButtonEventHandler my = new ButtonEventHandler();
//	push.addActionListener( my );	
	
	push.addActionListener( this );
	
	f.setLayout( new FlowLayout());
	f.add( push );	
	f.setSize( 200, 100 );
	f.setVisible( true );
    }//생성자 end

	 public void actionPerformed( ActionEvent ae ) {	
		System.out.println( "버튼이 눌려 졌어요." );
    }

    public static void main( String[] args ) {
		ButtonEvent1 be = new ButtonEvent1();
    }
}
