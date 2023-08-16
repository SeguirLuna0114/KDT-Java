import java.awt.*;
import java.awt.event.*;

public class CheckboxTest1 implements ItemListener {  
  Frame f;
  Checkbox cb1, cb2, cb3;
  CheckboxGroup colorGrp;

  public CheckboxTest1( ) {
	f = new Frame("Checkbox 연습");   
	
	f.addWindowListener(new WindowAdapter( ){
      public void windowClosing(WindowEvent e) {         
        System.exit(0); 
     }
    }); 

    colorGrp=new CheckboxGroup( );
    
    cb1 = new Checkbox("빨간색", colorGrp, false);  
    cb2 = new Checkbox("초록색", colorGrp, false);
    cb3 = new Checkbox("파란색", colorGrp, false);
    
	f.setLayout(new FlowLayout( ));
	f.add(cb1);
    f.add(cb2);  
    f.add(cb3);                                                               
    f.setSize(400,200); 
//	f.setBackground(new Color(255,0,0));
	f.setBackground(Color.red);
    f.setVisible(true);      

	//체크박스에 아이템 이벤트 처리 리스너 객체(this) 등록함
    cb1.addItemListener(this);
    cb2.addItemListener(this);
    cb3.addItemListener(this);
  }//생성자 end

 
  //아이템(체크 박스)의 상태가 변했을 때 호출되는 메서드
  public void itemStateChanged(ItemEvent e){
	Object obj = e.getSource();

	if(obj == cb1){
      f.setBackground(Color.red);
//	  f.setBackground(new Color(255,0,0));
    }else if(obj == cb2){
      f.setBackground(Color.green);
    }else if(obj == cb3){
      f.setBackground(Color.blue);
	}
/*
	Object obj = e.getItem();
	if(obj == "빨간색"){
      f.setBackground(Color.red);
//	  f.setBackground(new Color(255,0,0));
    }else if(obj == "초록색"){
      f.setBackground(Color.green);
    }else if(obj == "파란색"){
      f.setBackground(Color.blue);
	}*/
  }

  public static void main(String[] args) {
    CheckboxTest1 ct1 = new CheckboxTest1( );  
  }    
}           