import javax.swing.*;
import javax.swing.table.*; //javax.swing.table.DefaultTableModel;

public class JTableTest01 extends JFrame {  
  
  public JTableTest01(){
    
    Object [][] data = { {"홍길동", "777-7777", "hong@naver.com"},
						 {"안중근", "222-2222", "ahn@daum.net"},
						 {"이순신", "333-3333", "lee@empal.com"} };
   
    Object [] columnName = { "이름", "전화번호", "E-Mail" };
   
   // DefaultTableModel(Object[][] data, Object[] columnNames) 
	DefaultTableModel model = new DefaultTableModel(data, columnName); 
    JTable table = new JTable(model);
    
    add(new JScrollPane(table),"Center");
    
    setSize(400, 200);
    setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
   }//생성자 end  	

   public static void main(String[] args) {
		JTableTest01 jtt = new JTableTest01();
   }
 
 }
