import java.awt.*;
import java.awt.event.*; 

public class CanvasTest {

	Frame f;
	Canvas canvas;

    public CanvasTest(){
	
	f = new Frame("Canvas Test");
	
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
	    }
	});

	canvas = new Canvas();	
	canvas.setBackground(Color.yellow);	
//	canvas.setBackground(new Color(255,100,100));
	
	f.add(canvas);
	f.setSize(500, 400);  
	f.setLocation(500,150);
	f.setResizable(false);
    f.setVisible(true);
   }

   public static void main(String args[]) {
      CanvasTest mt = new CanvasTest();  
   }
}

