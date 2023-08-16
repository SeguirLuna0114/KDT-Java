import java.awt.*;
import java.awt.event.*;

public class ButtonEvent2 implements ActionListener{
  
  Frame f;
  Button redBtn, blueBtn; 

  public ButtonEvent2( ) {
	f = new Frame("Event Test");

	f.addWindowListener(new WindowAdapter( ){
      public void windowClosing(WindowEvent e) {
          f.dispose();
          System.exit(0); 
      }
    });  
    
    redBtn = new Button("빨간 색");
    blueBtn = new Button("파란 색");

	f.setLayout(new FlowLayout());  
    f.add(redBtn); 
    f.add(blueBtn); 
   
    redBtn.addActionListener(this);
    blueBtn.addActionListener(this);

    f.setSize(300,200); 
    f.setVisible(true);
    
  }//생성자 끝

  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand( ));	
//	System.out.println(e.getSource());
  } 

  public static void main(String[] args) {
   ButtonEvent2 fe = new ButtonEvent2( );                                 
  }

}                                                                                            
