import java.awt.*;
import java.awt.event.*;	

//public class ListTest implements ItemListener
public class ListTest2 implements ActionListener,ItemListener
{
  Frame f;
  List list;
  String[] item = { "서울", "대전", "대구", "부산" };    
  TextArea textA;
  
 public ListTest2() {

    f = new Frame("ItemEvent");  		

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});
		
  	list = new List(5,false);
	textA = new TextArea();    
        
    for(int i=0; i< item.length; i++){
    	list.add(item[i]);
	}
	
	f.add(list,"North");
    f.add(textA,"Center");

	f.setSize(300,300);
	f.setLocation(500,100);
	f.setResizable(false);
	f.setVisible(true);
	
	list.addItemListener(this);
 	list.addActionListener( this );

  }//생성자 end


 public void actionPerformed( ActionEvent ae ) {	
   	String item = list.getSelectedItem();
   	textA.setText(item + " 선택");
  }
	
  public void itemStateChanged(ItemEvent e)  {
   	String item = list.getSelectedItem();
   	textA.setText(item + " 선택");
  }


   public static void main(String args[])
   {
		ListTest2 lt = new ListTest2();		
   }


}