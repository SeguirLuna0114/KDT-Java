import java.awt.*;
import java.awt.event.*;

public class LabelTest {
	
    private Frame f;
    // Label 객체 선언
    private Label first, second, third;

    public LabelTest() {
		// 프레임 객체 생성
		f = new Frame( "Label" );

		// 세개의 Label 객체 생성
		// left:0 center:1 right:2
		first = new Label();
		second = new Label( "나이" );
//		third = new Label( "주소", Label.RIGHT ); 
		third = new Label( "주소",2);
	
		// 윈도우 종료 이벤트
		f.addWindowListener( new WindowAdapter() {
		  public void windowClosing( WindowEvent e ) {
		  System.exit( 0 );
		  }
		});

		// 각 Label의 배경색을 지정
//		first.setBackground( Color.pink );
		first.setBackground(new Color(255,0,255));
		second.setBackground( Color.yellow );
		third.setBackground( Color.green );

		first.setText( "이름" );
		second.setAlignment( Label.CENTER );
	
		System.out.println( "Text Of lb2 : " 
								+ second.getText() );
		System.out.println( "Alignment of lb3 : " 
							+ third.getAlignment() );

		// 프레임에 Label 객체를 붙임
		f.add( first, "North" );
		f.add( second, "Center" );
		f.add( third, "South" );

		// 프레임의 사이즈를 결정하고, 화면에 출력
		f.setSize( 300, 100 );
		f.setVisible( true );
	}

    public static void main( String[] args ) {
		LabelTest lt = new LabelTest();
    }
}
