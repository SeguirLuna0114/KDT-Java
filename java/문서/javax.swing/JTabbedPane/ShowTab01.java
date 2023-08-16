import javax.swing.*;

public class ShowTab01 extends JFrame { 
 
  JTabbedPane tab;
        
  public ShowTab01(){   
                
	super("탭 연습");

	//탭의 위치를 지정(TOP, LEFT, RIGHT, BOTTOM), 기본위치는 TOP으로 설정됨
	tab=new JTabbedPane(JTabbedPane.LEFT);
    //tab = new JTabbedPane(); 	

    tab.addTab("첫번째", new JLabel("첫번째 탭 내용"));    
    tab.addTab("두번째", new JLabel("두번째 탭 내용"));    
    tab.addTab("세번째", new JLabel("세번째 탭 내용"));
    
    tab.setSelectedIndex(1); //첫번째 탭이 선택되어서 출력됨    
    
    add(tab,"Center");   
        
    setSize(200, 300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }//생성자 end      

  public static void main(String s[]){
		ShowTab01 st = new ShowTab01();
  }

}