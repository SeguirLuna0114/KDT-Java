import javax.swing.*;

public class JTableTest extends JFrame {
  
  public JTableTest(){

    //1. 테이블의 각 셀에 들어갈 내용을 이차원 배열에 넣는다. 
    Object [][] data = { {"홍길동", "777-7777", "hong@naver.com"},
						 {"안중근", "222-2222", "ahn@daum.net"},
						 {"이순신", "333-3333", "lee@empal.com"} };

    //2. 테이블의 열 이름이 들어갈 내용을 일차원 배열에 넣는다. 
    Object [] columnName = { "이름", "전화번호", "E-Mail" };

    //3. JTable(Object[][] rowData , Object columnNames)생성자를 
	// 이용하여 테이블을 만든다. 
    JTable table = new JTable(data, columnName);	
	
    //4. 프레임에 테이블을 붙임
    add(new JScrollPane(table),"Center");
    
    setSize(400, 200);
    setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
   }//생성자 end  	

   public static void main(String[] args) {
		JTableTest jtt = new JTableTest();
   }
 
 }
