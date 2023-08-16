import java.awt.*; //java.awt.Graphics
import java.awt.event.*; //java.awt.event.MouseMotionAdapter, java.awt.event.MouseEvent
import javax.swing.*;

public class MouseMotionEventTest1 extends JFrame implements MouseMotionListener{
   private int xValue = 0, yValue = 0;

   public MouseMotionEventTest1(){
      super( "MouseEvent에서  MouseMotionListener 사용" );

      addMouseMotionListener(this);

	  setBounds(300, 300, 500, 500);
      setVisible(true);  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void mouseDragged( MouseEvent e ) {
//       xValue = e.getX();
//       yValue = e.getY();
//       repaint();
   }

   public void mouseMoved( MouseEvent e){
	  xValue = e.getX();
      yValue = e.getY();
      repaint();
   }

   public void paint( Graphics g ){
	  g.setColor(Color.green);
      g.fillRect( xValue, yValue, 10, 10 );
//	  g.fillOval( xValue, yValue, 30, 30);
   }

   public static void main( String args[] ){
      MouseMotionEventTest1 mouse = new MouseMotionEventTest1();      
   }

}