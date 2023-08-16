import java.awt.*; //java.awt.FlowLayout;
import javax.swing.*;

public class JButtonTest extends JFrame{ 

  JButton b1, b2, b3;
 
  public JButtonTest(){    

    b1=new JButton("버튼1");
	b2=new JButton("버튼2");
	b3=new JButton("버튼3");

	//풍선 도움말
	b1.setToolTipText(" 뭘봐!! ");
	b2.setToolTipText(" 또봐!! ");
	b3.setToolTipText(" 자꾸봐!! ");

	setLayout(new FlowLayout());

    add(b1);
    add(b2);
    add(b3);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setSize(300, 100);  
    setVisible(true);  
  }// 생성자 end

  public static void main(String[] args){
     JButtonTest jbt = new JButtonTest( );
  }

}                                                           
