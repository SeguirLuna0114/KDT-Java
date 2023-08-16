import java.awt.*;
import java.awt.event.*;	

public class ChoiceTest1 implements ItemListener {

  Frame f;
  Choice c;
  String[] item = { "서울", "대전", "대구", "부산" };  
//  TextArea textA;
  List li = new List(20);
  
  public ChoiceTest1(){
	f = new Frame("ItemEvent");  		

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});	
	
	c = new Choice();
//	textA = new TextArea();	

    for(int i=0; i< item.length; i++){
      c.add(item[i]);	 
	}

	f.add(c,"North");
    f.add(li,"Center");
    
	f.setSize(300,300);
	f.setLocation(500,100);
	f.setResizable(false);
	f.setVisible(true);

	c.addItemListener(this);

  } //생성자 end   
 
    public void itemStateChanged(ItemEvent e){
//    textA.append(c.getSelectedItem() + " 선택 \n");
	  li.add(c.getSelectedItem() + " 선택");
    }

	public static void main(String args[]){
		ChoiceTest1 ct = new ChoiceTest1();		
	}
  
}