import java.awt.*; //java.awt.Color;
import java.awt.event.*; //java.awt.event.ActionListener
import javax.swing.*;

public class JColorChooserEx extends JFrame implements ActionListener{
	
	JMenuBar mb;
	JMenu selectMenu;
	JMenuItem colorItem;
	JLabel l;
	JTextArea ta;
			
	public JColorChooserEx(){

		super("JColorChooser 테스트");
	
		mb =new JMenuBar();
		selectMenu = new JMenu("선택");
		colorItem=new JMenuItem("색샹");
		l=new JLabel("출력창");
		ta=new JTextArea();
			
		selectMenu.add(colorItem);
		
		mb.add(selectMenu);
		
		setJMenuBar(mb);
		
		add(l, "North");
		add(ta, "Center");
		
		setSize(300, 200);		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		colorItem.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == colorItem){
			JColorChooser jcc = new JColorChooser();
			//showDialog(컴포넌트, 타이틀, 초기색깔)
			Color col = jcc.showDialog(this,"색상을 고르세요",Color.blue);
			l.setText("선택한 색상은"+col);
			ta.setBackground(col);
		}
	}
	
	public static void main(String[] args){
		JColorChooserEx jcc = new JColorChooserEx();
	}

}