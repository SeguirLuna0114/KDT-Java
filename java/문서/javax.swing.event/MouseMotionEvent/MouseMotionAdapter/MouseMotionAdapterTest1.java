import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseMotionAdapterTest1 extends JFrame{
   private int xValue = 0, yValue = 0;

   public MouseMotionAdapterTest1(){
      super( "MouseEvent에서  MouseMotionListener 사용" );

      addMouseMotionListener(
         new MouseMotionAdapter() {
            public void mouseDragged( MouseEvent e ) {
               xValue = e.getX();
               yValue = e.getY();
               repaint();
            }           
         }
      );
 
	  setBounds(300, 300, 500, 500);
      setVisible(true);  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void paint( Graphics g ){
      g.fillRect( xValue, yValue, 3, 3 );
   }

   public static void main( String args[] ){
      MouseMotionAdapterTest1 mouse = new MouseMotionAdapterTest1();      
   }

}