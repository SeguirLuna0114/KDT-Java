import java.awt.*; //java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class ItemEventTest2 extends JFrame implements ItemListener {

   JTextField tex;
   JRadioButton m, f;
   JPanel p;
   ButtonGroup gender;

   public ItemEventTest2() {
      super( "라디오버튼에서 ItemEvent 연습" );
      
      setLayout(new GridLayout(2,1));
      
      tex = new JTextField( "성별을 표시합니다." );
      tex.setFont( new Font( "굴림", Font.PLAIN, 16 ) );      

	  p = new JPanel();
      m = new JRadioButton( "남자(Male)" );          
      f = new JRadioButton( "여자(Female)" );

	  gender = new ButtonGroup();
      gender.add( m );
      gender.add( f );

	  p.add( m ); 
      p.add( f );

	  add( tex );
	  add(p);            

      setSize( 250, 100 );
      setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  m.addItemListener( this );
      f.addItemListener( this );
	 }//생성자 end
   
	  public void itemStateChanged( ItemEvent e ) {
         if ( e.getSource() == m ){
            if ( e.getStateChange() == ItemEvent.SELECTED ){
               tex.setText("남자 입니다.");
			}
         }else if ( e.getSource() ==f){
            if ( e.getStateChange() == ItemEvent.SELECTED ){
                tex.setText("여자 입니다.");
			}
		 }
      }

   public static void main( String args[] ) { 
      ItemEventTest2 item = new ItemEventTest2();      
   }

}