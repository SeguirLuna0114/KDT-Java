import java.awt.*;
import java.awt.event.*;	

public class EventTest 
{
  Frame f;
  Button b;
  TextArea	textA;
  
  public EventTest() 
  {
	f = new Frame("ActionEvent");  		

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});
		
	b = new Button("눌러주세요!!");
	textA = new TextArea();
	
	MyButtonHandler myHandler = new MyButtonHandler(textA);	
    b.addActionListener(myHandler);
	
    f.add(b,"North");
    f.add(textA,"Center");

	f.setSize(300,300);
	f.setLocation(500,100);
	f.setResizable(false);
	f.setVisible(true);

  } 
  
  public static void main(String args[])
	{
		EventTest et = new EventTest();		
	}

}