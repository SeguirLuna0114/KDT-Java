import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main( String[] args ) {
       
        // 서버 정보를 간직하고 제어하는 ServerSocket 
		// 객체를 선언
        ServerSocket server = null;
        
        // 접속에 관한 정보를 간직하고 제어하는 Socket 객체 선언
        Socket socket = null;

        // 클라이언트에게 데이터를 전송하기 위한 스트림 선언
        OutputStream os;
        DataOutputStream dos;

        // 클라이언트에게 보낼 메시지
        String msg = "Hello, Client";
		
        try {
	    // 대표 포트 7777을 가진 서버 객체를 생성
	    server = new ServerSocket( 7777 );
	    System.out.println( "Wait Client......" );

	    // 클라이언트의 접속을 기다림
	    socket = server.accept();
	    System.out.println( "Client Connection Success" );
	    System.out.println( "server socket : " + 
				socket.getInetAddress().getHostAddress() );

	    // 지금 현재 접속한 클라이언트에게 데이터를 
	    // 전송하기 위해서 출력 스트림을 형성 
	    os = socket.getOutputStream();
	    dos = new DataOutputStream( os );
	    dos.writeUTF( msg );

	    // 스트림을 해제
	    dos.close();
	    // 서버와 클라이언트의 연결을 맺고 있는 Socket을 
	    // Close 해서 연결을 끊음
	    socket.close();
	    
        } catch ( Exception e ) {
			e.printStackTrace();
        }
    }
}