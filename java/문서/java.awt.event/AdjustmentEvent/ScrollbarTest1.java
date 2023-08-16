import java.awt.*;
import java.awt.event.*;

public class ScrollbarTest1 implements AdjustmentListener {
  
  Frame f;
  Panel p1, p2, p3, p4;
  Scrollbar sb1, sb2, sb3;
  TextArea textA;
  
  public ScrollbarTest1() {
	f = new Frame("AdjustmentEvent");  		

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});

	sb1 = new Scrollbar(0,100,10,0,255);
	sb2 = new Scrollbar(Scrollbar.HORIZONTAL,100,10,0,255);
	sb3 = new Scrollbar(Scrollbar.HORIZONTAL,100,10,0,255);

	textA = new TextArea(10,30);

/*
	p1 = new Panel();
	p1.add(sb1);

	p2 = new Panel();
	p2.add(sb2);

	p3 = new Panel();
	p3.add(sb3);
*/
	p4 = new Panel();
	p4.setLayout(new GridLayout(3,1,0,10));
  	p4.add(sb1);
  	p4.add(sb2);
	p4.add(sb3);  		
  	
  	f.setLayout(new GridLayout(1,2,20,0));		
	f.add(p4);
	f.add(textA);

	f.setSize(350,250);
	f.setLocation(500,100);
	f.setResizable(false);
	f.setVisible(true);

	sb1.addAdjustmentListener(this);
	sb2.addAdjustmentListener(this);
	sb3.addAdjustmentListener(this);

  }//생성자 end  

  public void adjustmentValueChanged(AdjustmentEvent e) {

	Object o = e.getSource();		

    if( o == sb1){		
//		textA.setBackground(Color.red);
		Color c = new Color(255,0,0);
		textA.setBackground(c);		
    }else if(o == sb2){
        textA.setBackground(new Color(0,255,0));
    }else if(o == sb3){
       textA.setBackground(new Color(0,0,255));
	}
  } 

  public static void main(String args[]) {
		ScrollbarTest1 check = new ScrollbarTest1();		
  }

}

