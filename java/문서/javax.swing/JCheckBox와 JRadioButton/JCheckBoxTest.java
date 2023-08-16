import javax.swing.*;

public class JCheckBoxTest extends JFrame{ 
  JCheckBox cb1, cb2, cb3;
  JRadioButton rb1, rb2, rb3, rb4, rb5;
  JPanel p1, p2, p3;

  public JCheckBoxTest(){

    p1=new JPanel(); //체크 박스 등록
    cb1=new JCheckBox("C", true);
    cb2=new JCheckBox("C++", false);
    cb3=new JCheckBox("자바", false);
    p1.add(cb1);  
	p1.add(cb2);  
	p1.add(cb3);
    
    p2=new JPanel(); //성별 구분을 위한 라디오 버튼 등록
	ButtonGroup bg1 = new ButtonGroup();
    rb1=new JRadioButton("남자", true);    
    rb2=new JRadioButton("여자", false);    
    bg1.add(rb1);    
	bg1.add(rb2);
    p2.add(rb1);      
	p2.add(rb2);

    p3=new JPanel(); //라디오 버튼 등록
    ButtonGroup bg2 = new ButtonGroup();
    rb3=new JRadioButton("군필", true);    
    rb4=new JRadioButton("미필", false);    
    rb5=new JRadioButton("면제", false);    
    bg2.add(rb3);    
	bg2.add(rb4);    
	bg2.add(rb5);

    p3.add(rb3);  
	p3.add(rb4);  
	p3.add(rb5);

	add(p1, "North");
	add(p2, "Center");
	add(p3, "South");
    
    setSize(300, 150); 
    setVisible(true);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }// 생성자 end
 
   public static void main(String[] args){
     JCheckBoxTest jcb = new JCheckBoxTest( );
  } 
}          