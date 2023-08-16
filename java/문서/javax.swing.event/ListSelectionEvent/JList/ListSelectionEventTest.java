import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

// ListSelectionEvent는 JList의 아이템을 선택할때 발생함
public class ListSelectionEventTest extends JFrame implements ListSelectionListener{
   JList list;
   JLabel label;
 
   String imageNames[] = { "blue.jpg", "black.jpg","red.jpg", "green.jpg","pink.jpg" };
   String listNames[]={"blue","black","red","green","pink"};
   Icon icons[];
   
   public ListSelectionEventTest(){
      super( "JLIst에서 ListSelectionEvent 연습" );
      
      setLayout( new GridLayout(1,2) );

      list = new JList( listNames );
      list.setVisibleRowCount( 5 );
      
	  // 리스트의 목록을 선택할때 단일 선택모드로 설정
      list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

	  icons = new ImageIcon[imageNames.length];//5

      for(int i=0;i<icons.length;i++){
		  icons[i]=new ImageIcon( imageNames[i] );
	  }

      label = new JLabel(icons[0]);

	  add( new JScrollPane( list ) );
	  add(label);

      setSize( 350, 150 );
      setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  list.addListSelectionListener( this );
   } //생성자 end

      public void valueChanged( ListSelectionEvent e ) {
         label.setIcon( icons[ list.getSelectedIndex() ] );
      }        

   public static void main( String args[] ){ 
      ListSelectionEventTest list = new ListSelectionEventTest();
   }

}
