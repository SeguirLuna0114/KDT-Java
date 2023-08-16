import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class InetAddressTest implements ActionListener {
    private Frame f;
    private List list;
    private TextField tf;
    private InetAddress address;
    
    // constructor
    public InetAddressTest() {
	f = new Frame( "InetAddress" );
	list = new List( 10 );
	tf = new TextField( 25 );
	
	// window 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit(0);
	    }
	});

	Panel p = new Panel();
	p.add( new Label( "HOST", Label.CENTER ));
	p.add( tf );
	
	f.add( list, "Center" );
	f.add( p, "South" );	
	f.setSize( 300, 300 );
	f.setLocation(300, 300);
	f.setResizable( false );
	f.setVisible( true );
	tf.addActionListener( this );
    }//생성자 end

    // 버튼 이벤트를 처리하는 메소드
    public void actionPerformed( ActionEvent ae ) {
	list.removeAll();
	// 텍스트 필드에 입력된 내용을 저장
	String name = tf.getText();//kbs.co.kr
	System.out.println( "name = " + name );

	try {
	    // Host 명을 받아들여 InetAddress 클래스 객체 생성
	    address = InetAddress.getByName( name );
	} catch ( UnknownHostException e ) {
	    System.out.println( e );
	}
		
	// InetAddress 클래스에 정의된 메소드
	list.add( "InetAddress : " + address );
	list.add( "Host Name : " + address.getHostName() );
	list.add( "Host Address : " + address.getHostAddress() );

	try {
	    list.add( "" );
		list.add( "LocalHost : " + InetAddress.getLocalHost() );
		list.add( "LocalHost Name : " + 
				InetAddress.getLocalHost().getHostName() );
	    list.add( "LocalHost address : " + 
				InetAddress.getLocalHost().getHostAddress() );
	} catch ( UnknownHostException ue ) {
	    System.out.println( ue );
	}
		
	// 텍스트 필드에 값을 입력한 후 엔터를 치고 난 후 텍스트 필드를
	//	 깨끗이 지우고 포커스를 텍스트 필드에 맞춘다. 
	tf.setText( "" );
	tf.requestFocus();
    }
	
	public static void main( String[] args ) {
	    InetAddressTest it = new InetAddressTest();
	}
}

