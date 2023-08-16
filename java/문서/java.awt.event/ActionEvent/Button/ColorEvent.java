import java.awt.*;
import java.awt.event.*;

class ColorEvent implements  ActionListener {
 
  Frame f;
  Button redBtn, blueBtn; 

  public ColorEvent( ) {
    
	f = new Frame("Event Test");

	f.addWindowListener(new WindowAdapter( ){
      public void windowClosing(WindowEvent e) {          
         System.exit(0); 
      }
    });  

    redBtn = new Button("빨간색");
    blueBtn = new Button("파란색");

    f.setLayout(new FlowLayout());
    f.add(redBtn);  
    f.add(blueBtn);    

    f.setSize(300,200); 
    f.setVisible(true); 

	redBtn.addActionListener(this);
    blueBtn.addActionListener(this);    
  }//생성자 끝

  public void actionPerformed(ActionEvent e){
	 // java.util.EventObject;
	if(e.getSource() == redBtn){	
		f.setBackground(new Color(255,0,0));
	} else if(e.getSource() == blueBtn){
		f.setBackground(Color.blue);
	}

// java.awt.event.ActionEvent; 
/*		if(e.getActionCommand()=="빨간색"){ 
			f.setBackground(Color.red); 
		} else {
			f.setBackground(Color.blue);
		}*/
  }

  public static void main(String[] args) {
      ColorEvent ce = new ColorEvent( );                                 
  }

}       