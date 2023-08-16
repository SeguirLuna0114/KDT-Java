import java.awt.*;
import java.awt.event.*;

// List의 Item을 선택(click)할때 ItemEvent 발생함. 
// List의 Item을 double click할때는 ActionEvent 발생함.
public class ListEvent2 implements ItemListener {
    private Frame f;
    private List list;
    private TextField tf;

    public ListEvent2() {	
	f = new Frame( "List Event" );
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    }
	});
	tf = new TextField( 20 );
	// List 객체 생성 및 Item 등록
	list = new List();
	list.add( "gemini" );
	list.add( "johnharu" );
	list.add( "gracedew" );	
	
	f.add( list, "Center" );
	f.add( tf, "South" );
	f.setSize( 300, 200 );
	f.setVisible( true );

	// List 객체에 ItemListener를 등록시킴
	list.addItemListener( this );
//	list.addActionListener( this );

    }//생성자 end

    // Item의 상태가 변화했을 때
    public void itemStateChanged( ItemEvent ie ) {
		// 현재 선택된 Item을 리턴 받아 변수에 저장
		String item = list.getSelectedItem();
		// TextField에 값을 세팅시킴
		tf.setText( item );	
    }

	public static void main( String[] args ) {
		ListEvent2 le = new ListEvent2();
    }
}