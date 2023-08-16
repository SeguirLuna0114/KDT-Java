import java.awt.*;
import java.awt.event.*;

public class TextFieldTest {
    private Frame f;
    private TextField nameField;
    private TextField ageField;

    public TextFieldTest() {
	// 프레임 객체 생성
	f = new Frame( "TextField" );
		
	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
	    }
	});
		
	// 두 개의 TextField 객체 생성
	nameField = new TextField( 15 );
	ageField = new TextField( "나이를 입력하세요",15 );	
//  nameField.setEchoChar('*'); 

	nameField.setText("안화수");

	// Label만을 포함하는 Panel을 생성후, 
	// Label 두 개를 Panel에 붙임
	Panel p1 = new Panel();
	p1.setLayout( new GridLayout( 2, 1, 0, 10 ));
	p1.add( new Label( "이름", Label.RIGHT ));
	p1.add( new Label( "나이", Label.RIGHT ));

	// TextField 두 개를 GridLayout을 사용해 Panel에 붙임
	Panel p2 = new Panel();
	p2.setLayout( new GridLayout( 2, 1, 0, 10 ));
	p2.add( nameField );
	p2.add( ageField );

	// 두 개의 Panel을 FlowLayout으로 붙이는 패널
	Panel p3 = new Panel();
	p3.add( p1 );
	p3.add( p2 );

	// 최종적으로 붙어 있는 패널을 프레임에 붙임
	f.add( p3, "Center" );

	// TextField에 현재 입력된 문자열을 화면에 출력
	System.out.println( "nameField's Text : " 
							+ nameField.getText() );
	System.out.println( "ageField's Text : " 
							+ ageField.getText() );
	f.setSize( 300, 100 );
	f.setVisible( true );
    }//생성자 end

    public static void main( String[] args ) {
		TextFieldTest tft = new TextFieldTest();
    }
}