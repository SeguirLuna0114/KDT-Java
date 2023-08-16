import java.awt.*;
import java.awt.event.*;

public class DialogTest implements ActionListener {
    private Frame f;
    private Button exit;

    private Dialog dialog;

    public DialogTest() {
	
	f = new Frame( "Dialog Test" );
	
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
 	    }
	});	
		
	exit = new Button( "종료" );	

	f.setLayout( new FlowLayout() );
	f.add( exit );
		
	f.setSize( 400, 200 );
	f.setVisible( true );

	exit.addActionListener( this );

    }// 생성자 end


    // 버튼이 눌려졌을 경우 처리하는 메소드
    public void actionPerformed( ActionEvent ae ) {
		// modal Dialog 객체 생성
		dialog = new Dialog( f, "Dialog 입니다.", true );

		//dialog 종료 처리 부분
		dialog.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				dialog.dispose();
//				System.exit( 0 );
 			}
		});
		
		// dialog에 Label을 붙임
	dialog.setLayout( new FlowLayout() );
	dialog.add( new Label( "Dialog 입니다", Label.CENTER ));
		
		// Dialog의 size를 설정하고, 화면에 출력
		dialog.setSize( 300, 100 );
		dialog.setVisible( true );
    }

    public static void main( String[] args ) {
		DialogTest dt = new DialogTest();
    }
}