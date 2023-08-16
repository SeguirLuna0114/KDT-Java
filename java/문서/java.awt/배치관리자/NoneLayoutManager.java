import java.awt.*;
import java.awt.event.*;

public class NoneLayoutManager {
    // 프레임 객체 선언
    Frame f;
    // 프레임에 포함시킬 버튼 객체 선언
    Button b1, b2, b3;

    public NoneLayoutManager() {
	// 프레임 객체 생성
	f = new Frame( "직접 컴포넌트 배치" );
		
	// 버튼 객체 생성
	b1 = new Button( "버턴1" );
	b2 = new Button( "버턴2" );
	b3 = new Button( "버턴3" );

	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    } 
	});

	// 레이아웃 관리자를 사용하지 않음
	f.setLayout( null );

	// 좌표값을 이용해 버튼을 위치시킴
	b1.setBounds( 50, 50, 100, 50 );
	b2.setBounds( 180, 50, 100, 50 );
	b3.setBounds( 310, 50, 100, 50 );

	// 프레임에 각각의 버튼을 포함시킴
	f.add( b1 );
	f.add( b2 );
	f.add( b3 );

	// 프레임의 크기를 정하고 화면에 출력함
	f.setSize( 460, 150 );
	f.setVisible( true );
	} //생성자 end
		
	public static void main( String[] args ) {
		NoneLayoutManager nlm = new NoneLayoutManager();
	}
}
