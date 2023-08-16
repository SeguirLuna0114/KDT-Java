import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JOptionPaneEx extends JFrame implements ActionListener{
	
	JButton b1, b2, b3, b4;
	String[] str={"로그인", "회원가입"};

	public JOptionPaneEx(){

		super("JOptionPane 테스트");
		setLayout(new FlowLayout());
		
		b1=new JButton("MessageDialog");	
		b2=new JButton("ConfirmDialog");
		b3=new JButton("InputDialog");
		b4=new JButton("OptionDialog");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		pack();
		setLocation(300,300);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==b1){
			JOptionPane.showMessageDialog(this,"메세지다이얼로그박스","메세지",JOptionPane.INFORMATION_MESSAGE);
		} else if(e.getSource()==b2){
			JOptionPane.showConfirmDialog(this,"확인다이얼로그박스","확인",JOptionPane.YES_NO_CANCEL_OPTION);
		} else if(e.getSource()==b3){
			JOptionPane.showInputDialog(this,"입력다이얼로그박스","입력",JOptionPane.YES_NO_OPTION);
		} else if(e.getSource()==b4){
			JOptionPane.showOptionDialog(this,"옵션다이얼로그박스","옵션",JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0] );
		}
	}
	
	public static void main(String[] args){
		JOptionPaneEx jop = new JOptionPaneEx();
	}
}