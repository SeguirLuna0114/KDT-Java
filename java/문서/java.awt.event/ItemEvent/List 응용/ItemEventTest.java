import java.awt.*;
import java.awt.event.*;

public class ItemEventTest implements ActionListener,
	ItemListener {
    private Frame f;
    private Choice nameChoice;
    private Choice select;
    private List fruitList;
    private TextField tf;
   
	public ItemEventTest() {
	f = new Frame( "Mutiple Event" );
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    }
	});

	nameChoice = new Choice();
	nameChoice.add( "이름을 입력하세요" );
	
	select = new Choice();
	select.add( "name" );
	select.add( "fruit" );

	fruitList = new List( 7 ,true);
	tf = new TextField( 20 );

	Panel p1 = new Panel();
	p1.setLayout( new GridLayout( 2, 1, 0, 10 ));
	p1.add( new Label( "이름", Label.CENTER ));
	p1.add( nameChoice );

	Panel p2 = new Panel();
	p2.setLayout( new BorderLayout() );
	p2.add( new Label( "과일", Label.CENTER ), "North" );
	p2.add( fruitList, "Center" );

	Panel p3 = new Panel();
	p3.add( p1 );
	p3.add( p2 );

	Panel p4 = new Panel();
	p4.add( select );
	p4.add( tf );

	f.add( p3, "Center" );
	f.add( p4, "South" );

	f.setSize( 400, 220 );
	f.setVisible( true );
	
//	registerationEventListener();

	tf.addActionListener( this );
//	select.addItemListener( this );
	nameChoice.addItemListener( this );
	fruitList.addItemListener( this );
    }//생성자 end

    // 컴포넌트에 EventListener를 등록시키는 method
//    public void registerationEventListener() {
/*		tf.addActionListener( this );
		select.addItemListener( this );
		nameChoice.addItemListener( this );
		fruitList.addItemListener( this );
*/
//    }

    // TextField에서 발생하는 Event를 처리하는 method
    public void actionPerformed( ActionEvent ae ) {
	
	String where = select.getSelectedItem();
	System.out.println( where );

	// name과 fruit에 따라 item을 등록시킴
	if( where == "name" ) {
	    nameChoice.add( tf.getText() );
   	    tf.setText( "" );
	} else {
	    fruitList.add( tf.getText() );
	    tf.setText( "" );
	}
    }

    // Choice와 List에서 ItemEvent가 발생하면 처리하는 
	// Handler Method
    public void itemStateChanged( ItemEvent ie ) {
		Object o = ie.getSource();
		String item = null;

	// Choice인지 List인지를 구별해서 TextField에 값을 세팅시킨다. 
		if( o == nameChoice ) {
		   item = nameChoice.getSelectedItem();
 		   tf.setText( item );
		} else if( o == fruitList ){
		   item = fruitList.getSelectedItem();
		   tf.setText( item );
		}
    }

    public static void main( String[] args ) {
		ItemEventTest it = new ItemEventTest();
    }
}
