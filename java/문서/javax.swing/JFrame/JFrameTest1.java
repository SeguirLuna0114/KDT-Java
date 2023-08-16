import java.awt.*;
import javax.swing.*;

public class JFrameTest1 extends JFrame{
	
	public JFrameTest1() {

		super(" JFrame Test!! ");

		Container cp = getContentPane();
		setSize( 200, 200 );
		setLocation( 400, 200 );
		setResizable( false );
		cp.setBackground(new Color(255,0,0));
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public static void main( String[] args ) {
		JFrameTest1 jf = new JFrameTest1();
	}
}