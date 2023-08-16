import java.io.*;
import java.net.*;

public class ConsoleClient {

    public static void main( String[] args ) {
		
	Socket socket = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;

	try {
	    // 서버와 연결하는 소켓 객체 생성
	    socket = new Socket("210.219.237.149", 9876 );

	    // 서버와 데이터를 주고받기 위한 스트림 형성
	    dos = new DataOutputStream( socket.getOutputStream() );
	    dis = new DataInputStream( socket.getInputStream() );

	    // 무한 루프
		while( true ) {
			
		    System.out.print( "Client input Message : " );
		    String message = TalkStatement.readString();
		    
		    // 키보드로부터 읽어 들인 데이터를 서버에게 전송
		    dos.writeUTF( message );
		    
		    // 스트림을 통해 데이터를 읽어 들임
		    System.out.println( "Server Message : " + dis.readUTF() );
		}//while end

	} catch ( Exception e ) {
	    try {
			// 스트림 객체와 소켓 객체 해제
			dos.close();
			dis.close();
			socket.close();
	    } catch ( IOException io ) {
			System.out.println( io );
	    }
	}// catch end
    }// main end
}
