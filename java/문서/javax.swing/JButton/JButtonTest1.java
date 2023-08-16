import java.awt.*; //java.awt.FlowLayout; java.awt.Insets;
import javax.swing.*;

public class JButtonTest1 extends JFrame{ 

  JButton b1, b2, b3;

  public JButtonTest1(){
    setLayout(new FlowLayout());

	// 버튼, 클릭한 버튼, Rollover된 버튼 
	b1=new JButton(new ImageIcon("images/b1.jpg"));
	b1.setPressedIcon(new ImageIcon("images/b1p.jpg")); 
 	b1.setRolloverIcon(new ImageIcon("images/b1r.jpg"));
	b1.setMargin(new Insets(0,0,0,10)); 
    add(b1);//Insets(int top, int left, int bottom, int right) 

	b2=new JButton(new ImageIcon("images/b2.jpg"));
	b2.setPressedIcon(new ImageIcon("images/b2p.jpg")); 
 	b2.setRolloverIcon(new ImageIcon("images/b2r.jpg"));
	b2.setMargin(new Insets(0,0,0,0)); 
    add(b2);

	b3=new JButton(new ImageIcon("images/b3.jpg"));
	b3.setPressedIcon(new ImageIcon("images/b3p.jpg")); 
 	b3.setRolloverIcon(new ImageIcon("images/b3r.jpg"));
	b3.setMargin(new Insets(0,0,0,0)); 
    add(b3);

	//풍선 도움말
	b1.setToolTipText("전화");
    b2.setToolTipText("쓰기");
	b3.setToolTipText("브이");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setSize(500, 150); 
    setVisible(true);  
  
  }// 생성자 end


  public static void main(String[] args){
     JButtonTest1 jbt1 = new JButtonTest1( );
  }
}                                                           
