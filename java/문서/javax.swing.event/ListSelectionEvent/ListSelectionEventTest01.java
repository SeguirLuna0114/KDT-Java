import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*; //java.util.Vector;

public class ListSelectionEventTest01 extends JFrame {
   JLabel la1;
   JTextField in, out;
   JPanel inputPanel, p1, p2;
   JButton send;
   JList list;
   JTextArea textA;
   Vector v;

   public ListSelectionEventTest01(){
      super( "텍스트필트와 버튼에서 ActionEvent 연습" );

      inputPanel = new JPanel();
	  la1 = new JLabel("입력");
	  in = new JTextField(20);	  
	  send = new JButton("전송");   
	  
	  inputPanel.add( la1 );
      inputPanel.add( in );
      inputPanel.add( send );
	  
	  out = new JTextField(20);	
	  
	  p1 = new JPanel(new GridLayout(2,1));
	  p1.add(inputPanel);
	  p1.add(out);
	  
	  p2 = new JPanel();
	  v = new Vector();
	  list = new JList();
	  JScrollPane sp01 = new JScrollPane(list);

	  textA = new JTextArea(7,10);
	  JScrollPane sp02 = new JScrollPane(textA);
	  p2.add(sp01);
	  p2.add(sp02);

	  add(p2, "Center");
      add(p1,"South");	  

	  setSize( 400, 250 );
	  setVisible(true);	
	  
	  setDefaultCloseOperation(EXIT_ON_CLOSE);

//	  in.addActionListener(this);	 
   }//생성자 end

	  
   public static void main( String args[] ) { 
      ListSelectionEventTest01 action = new ListSelectionEventTest01();     
   }

}