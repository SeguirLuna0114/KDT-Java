import java.awt.event.*;

import javax.swing.*;

public class ShowComboEvent1 extends JFrame implements ActionListener{

	JComboBox combo; 
	JTextArea textA;
	JScrollPane jsp;

	public ShowComboEvent1(){    
        
		super("미녀 영화배우");    

		combo = new JComboBox();
        
		combo.addItem("한예슬");
		combo.addItem("김태희");
		combo.addItem("최강희");
		
		textA = new JTextArea();
		jsp = new JScrollPane(textA);

		add(combo, "North");
		add(jsp, "Center");  
        
//		setSize(200, 300);
		setBounds(300, 300, 200, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
//		combo.addItemListener(this);
		combo.addActionListener(this);
	}//생성자 end

	public void actionPerformed(ActionEvent arg0) {
		System.out.println(combo.getSelectedItem());
		textA.setText(combo.getSelectedItem()+" 선택 \n");
		
	}
/*
	public void itemStateChanged(ItemEvent e){
		System.out.println(combo.getSelectedItem());
		textA.setText(combo.getSelectedItem()+" 선택 \n");
    }
*/     
  public static void main(String s[]) {
		ShowComboEvent1 sc = new ShowComboEvent1();    
  }//main end

}