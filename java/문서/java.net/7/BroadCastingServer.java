import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

// 클라이언트의 접속을 받아 들여 모든 클라이언트에게 
// 데이터를 전송시켜 주는 ServerThread 객체를 생성 
public class BroadCastingServer {
	
    // 서버의 폼을 구성하는 Component
    private Frame f;
    private TextArea state;

    // 클라이언트와 소켓을 형성하기 위한 클래스 선언
    private ServerSocket server;
    private Socket socket;

    // 데이터를 주고받을 수 있도록 Thread로 구현한 클래스 선언
    private ServerThread st;


    // 생성자임. GUI 폼 구성
    public BroadCastingServer() {
    	
	f = new Frame( "Server" );
	state = new TextArea( "", 30, 50, TextArea.SCROLLBARS_NONE );
	state.setEditable( false );

	f.add( state, "Center" );

	f.setSize( 300, 400 );
	f.setLocation( 300, 300 );
	f.setResizable( false );	
	f.setVisible( true );
       
        f.addWindowListener( new WindowAdapter() { 
			public void windowClosing( WindowEvent e ) {
	    		System.exit( 0 );
			}
		});	

    }// 생성자 end


    // 서버를 실행시키는 메소드
    public void startServer() {
    	
	try {
	    // 대표 포트 7777을 가지고 클라이언트의 접속을 
		// 기다리는 ServerSocket 객체 생성	    
	    server = new ServerSocket( 6666 );
	    
		while( true ) {

		    // 클라이언트와 접속을 성공시켜 소켓 생성
		    socket = server.accept();

		    // 스트림 형성
		    DataInputStream dis = new DataInputStream( socket.getInputStream() );
		    DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );

		    // 클라이언트가 전송하는 ID 값을 받아 들임
		    String name = dis.readUTF();

		    // broadcasting을 해주는 ServerThread 객체 생성
		    st = new ServerThread( socket, state, dis, dos, name );
		    Thread t = new Thread( st );
		    t.start();
		}//while end
		
	} catch( IOException ie ) {
	    System.out.println( ie.getMessage() );
	}

    }// startServer() end


    public static void main( String[] args ) {
		BroadCastingServer ser = new BroadCastingServer();
		ser.startServer();
    }
}
