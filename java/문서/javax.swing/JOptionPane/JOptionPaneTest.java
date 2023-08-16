import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JOptionPaneTest extends JFrame implements ActionListener{

	JButton b1, b2, b3, b4;

	public JOptionPaneTest() {
		setLayout(new FlowLayout());
		b1 = new JButton("Message");
		b2 = new JButton("ConFirm");
		b3 = new JButton("Intput");
		b4 = new JButton("Option");

		add(b1);
		add(b2);
		add(b3);
		add(b4);		
  
		setSize(400,100);
		setVisible(true);

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}//생성자 end
 
 public void actionPerformed(ActionEvent e) {
	if(e.getSource() == b1)  {
		JOptionPane.showMessageDialog(this, "메세지만 보여줍니다.");
	} else if(e.getSource() == b2){
		int an = JOptionPane.showConfirmDialog(this, "종료 할까요?");
		if(an == JOptionPane.YES_OPTION) {
			System.exit(0);	
//			System.out.println(an);
		}
	} else if(e.getSource() == b3){
		String str = JOptionPane.showInputDialog(this,
											"대화명을 입력하시오.");
		System.out.println(str);
	} else if(e.getSource() == b4){
		String[] str={"추가", "검색", "종료"}; 
		int an = JOptionPane.showOptionDialog(this,
			"원하는 작업을 선택하시오.", "옵션대화상자", 
			JOptionPane.YES_NO_CANCEL_OPTION, 
			JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
		System.out.println(an);  //추가:0, 검색:1, 종료:2
		if(an == 2){
			System.exit(0);
		}
	}
 }//actionPerformed() end 

 public static void main(String[] args) {
	JOptionPaneTest jop = new JOptionPaneTest ();
 }

}

