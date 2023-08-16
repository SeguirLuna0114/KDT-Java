import java.awt.*;
import java.awt.event.*;

public class MyButtonHandler implements ActionListener 
{
  TextArea txtState;

  public MyButtonHandler(TextArea ta)
  {
		txtState = ta;
  }

  public void actionPerformed(ActionEvent e) 
  {
  	txtState.setText( txtState.getText() + "버튼을 눌렸어요" + "\n" );
		
  }

}  