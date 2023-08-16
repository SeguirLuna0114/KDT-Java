import java.awt.event.*;
import javax.swing.*;

public class ShowComboEvent extends JFrame implements ItemListener{

	JComboBox combo; 
	JTextArea textA;
	JScrollPane jsp;

	public ShowComboEvent(){    
        
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
		
		combo.addItemListener(this);
	}//생성자 end

	public void itemStateChanged(ItemEvent e){
		System.out.println(combo.getSelectedItem());
		textA.setText((String)combo.getSelectedItem()+" 선택 \n");
    }
     
  public static void main(String s[]) {
		ShowComboEvent sc = new ShowComboEvent();    
  }//main end

}