import java.awt.*;
import java.awt.event.*;

public class ScrollbarTest {
    Frame f;
    Scrollbar hbar1, hbar2, hbar3, vbar1, vbar2;

    public ScrollbarTest() {

	// 프레임 생성및 윈도우 종료 이벤트
	f = new Frame( "Scrollbar" );

	f.addWindowListener( new WindowAdapter() {
		public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
		} 
     });

// Scrollbar ( 방향(수평0,수직1),
		    // 스크롤바의 초기 위치,
		    // 스크롤바의 길이,
		    // 스크롤바가 움직일수 있는 최소값,
		    // 스크롤바가 움직일수 있는 최대값)
hbar1 = new Scrollbar( 0, 50, 100, 0, 300 );
hbar2 = new Scrollbar( Scrollbar.HORIZONTAL, 0, 30, 0, 300 );
hbar3 = new Scrollbar( Scrollbar.HORIZONTAL, 0, 30, 0, 300 );
vbar1 = new Scrollbar( Scrollbar.VERTICAL, 0, 100, 0, 250 );
vbar2 = new Scrollbar( Scrollbar.VERTICAL, 0, 20, 0, 250 );

	// 동, 서, 남, 북에 스크롤 바를 붙임
	f.add( hbar1, "North" );
	f.add( hbar2, "South" );
	f.add( hbar3, "Center" );
	f.add( vbar1, "East" );
	f.add( vbar2, "West" );	

	f.setSize( 500, 300 );
	f.setVisible( true );
    }//생성자 end
	
    public static void main( String[] args ) {
		ScrollbarTest st = new ScrollbarTest();
    }
}
