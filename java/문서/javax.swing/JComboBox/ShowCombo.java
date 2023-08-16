import javax.swing.*;

public class ShowCombo extends JFrame {

	JComboBox combo;    

	public ShowCombo(){    
        
		super("미녀 영화배우");    

		combo = new JComboBox();
        
		combo.addItem("한예슬");
		combo.addItem("김태희");
		combo.addItem("최강희");		

		add(combo,"Center");   
        
//		setSize(200, 50);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}//생성자 end
     
  public static void main(String s[]) {
		ShowCombo sc = new ShowCombo();    
  }//main end

}