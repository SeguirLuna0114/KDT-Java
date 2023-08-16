import javax.swing.*;

public class JFrameTest {
	JFrame f;

	public JFrameTest() {
		f = new JFrame( "JFrame Test" );
		Container cp = f.getContentPane();
		f.setSize( 200, 200 );
		f.setLocation( 400, 200 );
		f.setResizable( false );		
		f.setVisible( true );
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public static void main( String[] args ) {
		JFrameTest jf = new JFrameTest();
	}
}