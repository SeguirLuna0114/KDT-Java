import java.awt.*;
import javax.swing.*;

public class JButtonTest2 extends JFrame{
	
	public JButtonTest2(){
		super("JFrame 테스트");

		JButton bt1=new JButton("Hello Swing North");
		JButton bt2=new JButton("Hello Swing Center");
		
		Container cp = getContentPane();

//		cp.add(bt1, "North");
		add(bt1,"North");
		add(bt2,"Center");
		bt2.setBackground(new Color(255,0,0));
				
		setSize(200,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
		
	public static void main(String[] args){
		JButtonTest2 jbt = new JButtonTest2();
	}
}
