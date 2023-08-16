import java.awt.*;
import java.awt.event.*;

public class TextA implements ActionListener {

  Frame f; 
  TextArea   txtState;
  TextField  txtF;        
  Button     b;    

  public TextA( ) {
	f = new Frame("TextArea Test");	

	f.addWindowListener(new WindowAdapter( ){
      public void windowClosing(WindowEvent e) {        
        System.exit(0); 
      }
    });

    txtF = new TextField(40);
	txtState = new TextArea();
	txtState.setEditable( false );
    b = new Button("추  가" );

	Panel p = new Panel();
	p.add(txtF);
	p.add(b);

    f.add(txtState, "North"); 
	f.add(p, "Center");   
                   
    f.setSize(400,250); 
    f.setVisible(true); 
	
	//버튼에 발생한 이벤트를 처리할 이벤트 리스너 객체를 연결함 
	b.addActionListener(this);
	txtF.addActionListener(this);
  }//생성자의 끝  

  public void actionPerformed(ActionEvent e){
//텍스트 필드에 문자열을 입력되었다면
//텍스트 필드값을 얻어와서 텍스트 에어리어에 추가
//텍스트 필드의 내용을 초기화한다. 
/*
	if(txtF.getText() != ""){ 
      txtState.append(txtF.getText()+"\n"); 
      txtF.setText("");     
    }*/
  //java.util.EventObject;
	if(e.getSource() == txtF){
		txtState.append(txtF.getText()+"\n"); 
        txtF.setText("");      
	} else if(e.getSource() == b){
		txtState.append(txtF.getText()+"\n"); 
        txtF.setText("");     
	}

  }

  public static void main(String[] args) {
    TextA ta = new TextA( );   
  }
}