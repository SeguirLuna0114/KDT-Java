import java.awt.*;
import java.awt.event.*;

public class CheckboxTest implements ItemListener{

  Frame f;
  Panel p;
  Checkbox cb1,cb2; 
  CheckboxGroup cg;
  TextArea	textA;
  
  public CheckboxTest(){
	f = new Frame("ItemEvent");  		

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});

	cg = new CheckboxGroup();

	cb1 = new Checkbox("딸기",cg,true);
  	cb2 = new Checkbox("사과",cg,false);

	textA = new TextArea();

	p = new Panel();
  	p.add(cb1);
  	p.add(cb2);  		      	
  	
  	f.add(p,"North");
	f.add(textA,"Center");
	f.setSize(300,300);
	f.setLocation(500,100);
	f.setResizable(false);
	f.setVisible(true);

	cb1.addItemListener(this);
	cb2.addItemListener(this);

  }//생성자 end
  

  public void itemStateChanged(ItemEvent e) {
 
	Object cb = e.getSource();

    if(cb == cb1){ 
        textA.setText("딸기가 선택되었어요");
		textA.setBackground(new Color(255,0,0));
    } else if(cb == cb2){
        textA.setText("사과가 선택되었어요");
		textA.setBackground(Color.blue);
    }

  } 
  
  public static void main(String args[]){
		CheckboxTest cbt = new CheckboxTest();		
  }

}

