import java.awt.*;
import java.awt.event.*;	

public class EventSelf implements ActionListener{
  Frame f;
  Button b;
  TextArea textA;
  
  public EventSelf()   {
	f = new Frame("ActionEvent");  		

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});
		
	b = new Button("눌러주세요!!");
	textA = new TextArea();	
	
    b.addActionListener(this);
	
    f.add(b,"North");
    f.add(textA,"Center");

	f.setSize(300,300);
	f.setLocation(500,100);
	f.setResizable(false);
	f.setVisible(true);
  } //생성자 end
  
  public void actionPerformed(ActionEvent e){
//  	textA.setText( textA.getText() + 
//							"버튼을 눌렸어요" + "\n" );
	textA.append("버튼을 눌렀어요 \n");
//	textA.setBackground(Color.red); 
	textA.setBackground(new Color(255,100,100));
  }	

  public static void main(String args[]){
	EventSelf et = new EventSelf();		
  }
}