import java.awt.event.*; //java.awt.event.MouseListener, java.awt.MouseEvent
import javax.swing.*;

public class MouseEventTest1 extends JFrame implements MouseListener {
   JLabel statusBar;
   
   public MouseEventTest1(){
      super( "MouseEvent에서  MouseListener 사용" );

      statusBar = new JLabel();	  
	  add(statusBar, "South");     

      setSize( 300, 150 );  
      setVisible(true);  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  addMouseListener(this);
   }

   public void mouseClicked( MouseEvent e ){
      statusBar.setText( "[" + e.getX() +
                         ", " + e.getY() + "] 지점에서 마우스 Click" );
   }

   public void mousePressed( MouseEvent e ){
      statusBar.setText( "[" + e.getX() +
                         ", " + e.getY() + "] 지점에서 마우스 Press" );
   }

   public void mouseReleased( MouseEvent e ){
      statusBar.setText( "[" + e.getX() +
                         ", " + e.getY() + "] 지점에서 마우스 Release" );
   }

   public void mouseEntered( MouseEvent e ){
      statusBar.setText( "마우스 포인터가  해당  윈도우안에 들어옴" );
   }

   public void mouseExited( MouseEvent e ){
      statusBar.setText( "마우스 포인터가  해당  윈도우밖으로 나감" );
   }

   public static void main( String args[]){
      MouseEventTest1 mouse = new MouseEventTest1();
   }
}
