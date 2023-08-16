import java.awt.*;
import java.awt.event.*;

public class ChoiceTest {
    Frame f;
    Choice choice;

    public ChoiceTest() {
	// 프레임 생성
	f = new Frame( "choice" );
		
	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
	    } 
	});

	// choice 객체 생성후, item을 추가
	choice = new Choice();
	choice.add( "gemini" );
	choice.add( "johnharu" );
	choice.add( "gracedew" );

	// Panel에 추가
//	Panel p = new Panel();
//	p.setLayout( new BorderLayout() );

//	p.add( new Label( "이름을 선택하세요",Label.CENTER ), "North" );
//	p.add( choice, "Center" );

	//프레임의 레이 아웃 관리자를 FlowLayout관리자로 
	//변환후에 Panel을 프레임에 부착한다.
	 
//	f.setLayout( new FlowLayout() );
//	f.add(p,"Center");
	f.add(new Label( "이름을 선택하세요",Label.CENTER ), "North");
	f.add( choice , "Center");
	f.setSize( 300, 100 );
	f.setVisible( true );
    }//생성자 end

    public static void main( String[] args ) {
		ChoiceTest ct = new ChoiceTest();
    }
 }