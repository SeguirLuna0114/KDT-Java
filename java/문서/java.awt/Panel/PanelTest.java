import java.awt.*;
import java.awt.event.*;

public class PanelTest {
	
	private  Frame f;
	private Panel p;

	public PanelTest() {
		
		f = new Frame( "Panel Test" );
		p = new Panel();

		// 윈도우의 종료 이벤트
		f.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent we ) {
				System.exit(0);
			}
		});

		// 프레임의 배경색을 green으로 설정
		f.setBackground( Color.green );
		// Panel의 배경색을 blue로 설정
		p.setBackground( Color.blue );

		// 프레임과 Panel의 사이즈 설정
		f.setSize( 300, 200 );
		p.setSize( 100, 100 );

		f.setLayout( null );//배치관리자를 사용하지 않음.

		// 프레임에 Panel을 붙임
		f.add( p );
		// 프레임을 화면에 보여줌
		f.setVisible( true );
	}
	
	public static void main( String[] args ) {
		PanelTest pt = new PanelTest();
	}
}
