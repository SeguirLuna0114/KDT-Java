import java.awt.*;
import java.awt.event.*;

public class FrameTest01 {	

	 public static void main( String[] args ) {		 
    
		Frame f = new Frame( "Frame Test" );	
		f.setSize( 400, 300 );
		f.setLocation( 100, 100 );
		f.setBackground( Color.green );
		f.setResizable(false); 
		f.setVisible( true );		   

		f.addWindowListener( new WindowAdapter() {
		    public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
		    }
    });   
		
    }//main end
}