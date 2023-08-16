import java.awt.*;
import java.awt.event.*;

// ActionEvent가 발생하기 때문에, ActionListenr를 
//implements 해서, Event를 처리해 주는 Handler 
//method인 actionPeformed 메소드를 overriding 
//해주어야 함. 

public class TextFieldEvent implements ActionListener {
    private Frame f;
    private TextField nameField;

    public TextFieldEvent() {
	
	f = new Frame( "TextField Event" );
	
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    }
	});
	
	nameField = new TextField( 15 );	
	
	f.setLayout( new FlowLayout() );
	f.add( new Label( "이름", Label.RIGHT ));
	f.add( nameField );
	
	f.setSize( 300, 70 );
	f.setVisible( true );
	
	nameField.addActionListener( this );

    }//생성자 end

    // TextField에서 ActionEvent가 발생하는 
	// ActionListner에 의해서 넘어오는 ActionEvent를 
	// 넘겨 받아 이를 처리해주는 Handler method
    public void actionPerformed( ActionEvent ae ) {
		String inputString = nameField.getText();
		System.out.println( inputString );
		nameField.setText( " " );
    }

    public static void main( String[] args ) {
		TextFieldEvent tf = new TextFieldEvent();
    }
}