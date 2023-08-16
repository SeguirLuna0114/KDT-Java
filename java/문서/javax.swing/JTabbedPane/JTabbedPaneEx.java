import javax.swing.*;

public class JTabbedPaneEx extends JFrame{

	ImageIcon icon1, icon2;	
	JButton b1, b2;
	JTabbedPane tab;
	
	public JTabbedPaneEx(){

		super("JTabbedPane 연습");
			
		icon1=new ImageIcon("baby.gif");
		icon2=new ImageIcon("ahn.jpg");				

		b1=new JButton(icon1);
		b2=new JButton(icon2);
		
		//탭의 위치를 지정(TOP, LEFT, RIGHT, BOTTOM), 기본위치는 TOP으로 설정됨
		//tab=new JTabbedPane(JTabbedPane.LEFT);
		tab=new JTabbedPane();
		
		tab.addTab("탭1", b1);		
		tab.addTab("탭2", b2);
		tab.addTab("탭3", new JTextArea(7,20));

		add(tab,"Center");
		
		setSize(500,500);
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args){
		JTabbedPaneEx jtp = new JTabbedPaneEx();
	}
}

