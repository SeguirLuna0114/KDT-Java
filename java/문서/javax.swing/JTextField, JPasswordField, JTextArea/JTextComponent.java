import java.awt.*; //java.awt.BorderLayout;
import javax.swing.*;

public class JTextComponent extends JFrame {

		JPanel p1, p2;
		JTextField  namefield, ageField;
		JPasswordField passField;
		JTextArea textA;
		JScrollPane tscroll;
	
	public JTextComponent() {		
		
		super("JTextComponent 테스트");
	
		p1 = new JPanel();		
		namefield = new JTextField(5);
		ageField = new JTextField(2);
		passField= new JPasswordField(5);		

		p1.add(new JLabel("Name : "));
		p1.add(namefield);
		p1.add(new JLabel("Age : "));
		p1.add(ageField);
		p1.add(new JLabel("Password : "));
		p1.add(passField);		

		p2=new JPanel(new BorderLayout());
		textA = new JTextArea(10, 10);
		textA.setLineWrap(true); //자동 줄바꿈

		tscroll = new JScrollPane(textA, 
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		
		p2.add( new JLabel("자기소개"), "North");
		p2.add( tscroll, "Center" );
		
		add( p1, "North");
		add( p2, "Center");
		
		setSize(350, 300);
		setLocation(300,300);		
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}//생성자 end
		

	public static void main(String[] args) {
		 JTextComponent jtc = new JTextComponent();		
	}

}