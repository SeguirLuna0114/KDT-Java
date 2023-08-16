import java.io.*;
import java.net.*;

public class SimpleClient  {
    public static void main( String[] args ) {
    	
        // 접속에 관한 정보를 간직하고 제어하는 Socket 
		// 객체 선언
        Socket socket = null;

        // 서버에서 전송하는 데이터를 받기 위한 스트림 
		// 객체 선언         
        InputStream is = null;
        DataInputStream dis = null;

        // 서버에서 전송하는 데이터를 저장하기 위한 
		// 변수 선언
		String serverMsg = null;

	try {
	    // 접속하려는 서버의 IP와 Port를 argument로
	    //  Socket 객체 생성
	    socket = new Socket( "210.219.237.149", 7777 );
	    System.out.println( "Server Connection Success" );
	    System.out.println( "client Socket : " + socket );

	    // 현재 접속한 서버와 스트림 형성
	    is = socket.getInputStream();
	    dis = new DataInputStream( is );
	    serverMsg = new String( dis.readUTF() );

	    System.out.println( "서버에서 전송된 메시지 : " 
										+ serverMsg );
			
	    // 스트림을 해제
	    dis.close();
	    // 서버와 연결을 해제
	    socket.close();
	    
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }//main() end
}