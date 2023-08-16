import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionEventTest extends JFrame implements ActionListener {
   JLabel la1;
   JTextField in;
   JPanel inputPanel;
   JButton send;
   JTextArea content;

   public ActionEventTest(){
      super( "텍스트필트와 버튼에서 ActionEvent 연습" );

      inputPanel = new JPanel();
	  la1 = new JLabel("내용");
	  in = new JTextField(20);	  	  
	  
	  send = new JButton("전송");
	  
	  inputPanel.add( la1 );
      inputPanel.add( in );
      inputPanel.add( send );

      content = new JTextArea(5,30);
	  JScrollPane s= new JScrollPane(content);
      add(inputPanel,"South");
	  add(s, "Center");

	  setSize( 350, 200 );
	  setVisible(true);	
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);

	  in.addActionListener(this);//이벤트가 발생하면 actionPerformed()메소드를 수행
	  send.addActionListener(this);//이벤트가 발생하면 actionPerformed()메소드를 수행
   }

   public void actionPerformed(ActionEvent e){
	   if(e.getSource()== in || e.getSource()== send){
			content.append(in.getText()+"\n");
			in.setText("");
	   }
   }

   public static void main( String args[] ) { 
      ActionEventTest action = new ActionEventTest();     
   }

}