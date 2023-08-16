import java.awt.*;
import java.awt.event.*;

public class TextFd { 

  Frame f;
  Panel p1, p2;           
  TextField  txtID;       
  TextField  txtPW;      
   
  public TextFd( ) {
	f = new Frame("TextField Test"); 
	
	f.addWindowListener(new WindowAdapter( ){
      public void windowClosing(WindowEvent e) {         
        System.exit(0); 
      }
    });  

    txtID=new TextField(20);  
    txtPW=new TextField(20);

   // 패스워드를 입력받을 텍스트 필드는 보안을 위해 
   // 입력받은 문자 대신 출력할 문자 지정 
    txtPW.setEchoChar('*');    

	p1=new Panel();   
    p1.add(new Label("아   이  디 : "));   
    p1.add(txtID);   

	p2=new Panel();
    p2.add(new Label("패스 워드 : "));    
    p2.add(txtPW);     

	f.add(p1, "North");    
    f.add(p2, "Center");  

    f.setSize(400,100); 
    f.setVisible(true);
   
  }//생성자의 끝  

  public static void main(String[] args) {
    TextFd tf = new TextFd( );   
  }    
}
