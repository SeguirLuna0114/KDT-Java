import javax.swing.*;

public class JTabbedPaneTest extends JFrame{

     JTabbedPane tab;
     JTable table01, table02;
	 JScrollPane sp01, sp02;	 

     public JTabbedPaneTest(){
         super("JTabbedPane 연습");

		 //탭의 위치를 설정(상단에 위치)
		 // JTabbedPane.TOP:상단, JTabbedPane.BOTTOM:하단, JTabbedPane.LEFT:좌측, JTabbedPane.RIGHT:우측
         tab = new JTabbedPane(JTabbedPane.LEFT);

		 // 첫번째 탭의 내용 부분		
		 String title01[] = {"번호", "이름", "입사일"};
         String data01[][] = { {"1","홍길동", "2000-03-10"},
							 {"2","안중근", "2001-10-07"},
							 {"3","이순신", "2002-05-20"} };

         table01 = new JTable(data01, title01);
         sp01 = new JScrollPane(table01);

		 //두번째 탭의 내용부분	
		 String title02[] = {"번호", "부서", "직급"};
         String data02[][] = { {"1","기획부", "과장"},
							 {"2","홍보부", "대리"},
							 {"3","개발부", "대리"} };

         table02 = new JTable(data02, title02);
         sp02 = new JScrollPane(table02);

		 //탭에 내용부분을 부착
		 tab.addTab("인사관리(기본)", sp01);
         tab.addTab("인사관리(세부)", sp02);

		 add(tab, "Center");
         setSize(500,200);
         setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
     }//생성자 end

     public static void main(String args[]){
         JTabbedPaneTest jt= new JTabbedPaneTest();		 
     }

 }           								
