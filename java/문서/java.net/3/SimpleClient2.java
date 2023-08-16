import java.net.*;
import java.io.*;
import java.util.Date;

public class SimpleClient2 {
    public static void main( String[] args ) throws Exception {
    	
        // 서버에 접속하기 위한 Socket 객체 선언
        Socket socket;

        // Object로 데이터를 주고 받기 위한 스트림 객체 선언
        ObjectInputStream ois;
        ObjectOutputStream oos;

        // 서버에서 전송하는 데이터를 저장하기 위한 변수 선언
        String serverMsg = null;
        
        // 서버에게 전송할 아이디를 저장하는 변수
        String ID = "gemini";

        // 서버에 접속하는 Socket 객체 생성
        // 서버 접속 정보를 지님
        socket = new Socket( "210.219.237.149",1234 );
        System.out.println( "Server Connection Success" );
		
        // 서버와 ObjectInputStream, ObjectOutputStream 스트림
		// 형성
        ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());

		//서버측으로 ID 전송
		oos.writeObject( ID );

		// 서버에서 전송하는 메시지를 받음
		serverMsg = new String( ois.readObject().toString() );
		Date d = (Date)ois.readObject();

		// 메시지 출력
		System.out.println( "서버에서 전송된 메시지" );
		System.out.println( serverMsg );
		System.out.println( d.toString() );
		System.out.println( ois.readObject().toString() );

		// 스트림 객체 해제
		oos.close();
		ois.close();
		// 소켓 객체 해제
		socket.close();
    }//main() end
}