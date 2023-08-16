import java.io.*;
import java.net.*;
import java.util.*; //java.util.Date;

public class SimpleServer2 {
   public static  void main( String[] args ) throws Exception {	
    	
    // 대표 포트를 지니는 ServerSocket 객체 선언
	ServerSocket serverSocket = null;
	
	// 접속 정보를 지니는 Socket 객체 선언
	Socket socket = null;
	String msg = "Hello, Client";

	// Object 타입으로 데이터를 주고받기 위한 스트림 객체 선언
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	// 대표 포트 1234를 지니는 ServerSocket 객체 생성
	serverSocket = new ServerSocket( 1234 );

	while( true ) {
		
	    System.out.println( "Wait Client .........." );
	    
	    // 클라이언트의 접속을 기다림
	    socket = serverSocket.accept();

	    // Socket 클래스의 메소드를 이용해 
	    // 클라이언트가 접속한 클라이언트의 IP 주소를 얻어옴
	    System.out.println( "Clinet IP : " 
			    + socket.getInetAddress().getHostAddress() );
		 System.out.println(socket);

	    // ObjectOutputStream,InputStream 객체 생성
	    oos = new ObjectOutputStream(socket.getOutputStream());
	    ois = new ObjectInputStream(socket.getInputStream());
			
	    // 클라이언트로 부터 데이터를 읽어 들임 
	    System.out.println( ois.readObject().toString() 
			                     + "님이 접속하셨습니다" );

	    // 클라이언트로 데이터를 전송
	    oos.writeObject( msg );
	    oos.writeObject( new Date() );
	    oos.writeObject( new String( "Java Network Programming" ) );

	    // 스트림 객체 해제
	    oos.close();
	    ois.close();
	    // 소켓 객체 해제
	    socket.close();
	}//while end
    }
}
			

