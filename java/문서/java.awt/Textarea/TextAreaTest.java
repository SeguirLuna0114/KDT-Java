import java.awt.*;
import java.awt.event.*;

public class TextAreaTest {
    private Frame f;
    private TextArea ta1;
    private TextArea ta2;

    public TextAreaTest() {
	// 프레임 생성
	f = new Frame( "TextArea" );
		
	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
	    }
	});

	// TextArea 객체 생성
	ta1 = new TextArea( 10, 30);
	// TextArea에 한 줄 입력
	ta1.append( "하고 싶은 말이 있어요\n" );
	ta1.append("무엇?");

	ta1.setText("새로운 내용");	

//	ta2 = new TextArea("듣고 싶은 말이 있어요\n",
//					10, 30, TextArea.SCROLLBARS_NONE );	
	ta2 = new TextArea("듣고 싶은 말이 있어요\n",
					10, 30, 0 );	
	// Label과 TextArea를 붙인 Panel 생성
	Panel p1 = new Panel();
	p1.setLayout( new BorderLayout() );
	p1.add( new Label( "하고 싶은말", Label.CENTER ),"North" );
	p1.add( ta1, "Center" );

	Panel p2 = new Panel();
	p2.setLayout( new BorderLayout() );
	p2.add( new Label( "듣고 싶은말", Label.CENTER ),"North" );
	p2.add( ta2, "Center" );

/*	Panel p3 = new Panel();
	p3.add( p1 );
	p3.add( p2 );
*/
	// TextArea에 입력된 Text를 화면으로 출력
	System.out.println("ta1's text:" + ta1.getText());
	System.out.println("ta2's text:" + ta2.getText());

	f.setLayout(new FlowLayout());
	f.add(p1);
	f.add(p2);
//	f.add( p3, "Center" );

	f.setSize( 500, 300 );
	f.setVisible( true );
    }//생성자 end

    public static void main( String[] args ) {
		TextAreaTest tat = new TextAreaTest();
    }
}
