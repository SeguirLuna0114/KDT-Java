import javax.swing.*;
import javax.swing.event.*; //javax.swing.event.ChangeListener;

//사용자에 의해서 탭이 눌러 졌을때 ChangeListener 인터페이스를 이용해서 처리함. 
public class ChangeEvent01 extends JFrame implements ChangeListener{ 
 
  JTabbedPane tab;
        
  public ChangeEvent01(){   
                
	super("ChangeEvent");

    tab = new JTabbedPane(); 
    tab.addTab("첫번째", new JLabel("첫번째 탭 내용"));    
    tab.addTab("두번째", new JLabel("두번째 탭 내용"));    
    tab.addTab("세번째", new JLabel("세번째 탭 내용"));
    
    tab.setSelectedIndex(1); //첫번째 탭이 선택되어서 출력됨    
    
    add(tab,"Center");   
        
    setSize(200, 300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    tab.addChangeListener(this);

  }//생성자 end    
 
    
  public void stateChanged(ChangeEvent e){  
	// JTabbedPane객체의 index번호값을 반환함
    int cur = tab.getSelectedIndex();
    String curPaneTitle = tab.getTitleAt(cur);
        
    System.out.println(curPaneTitle + " 탭이 선택되었습니다");
  }    

  public static void main(String s[]){
		ChangeEvent01 st = new ChangeEvent01();
  }

}