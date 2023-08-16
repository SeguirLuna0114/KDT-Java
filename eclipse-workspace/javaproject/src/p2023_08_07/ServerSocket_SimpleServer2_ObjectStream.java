package p2023_08_07;

//간단한 서버를 구현하여, 클라이언트로부터의 연결을 기다리고, 
// 클라이언트가 서버에 연결하면 서버는 초기 메시지와 다양한 객체를 클라이언트로 전송하는 프로그램
import java.io.*;
import java.net.*;
import java.util.*; //java.util.Date;

public class ServerSocket_SimpleServer2_ObjectStream {
	public static void main(String[] args) throws Exception {
		// throws Exception은 메서드 내에서 발생하는 예외를 처리하기 위해 예외 처리를 위임

		// 서버에서 클라이언트의 연결을 대기하는데 사용되는 ServerSocket 객체를 선언
		// - 대표 포트를 지니는 ServerSocket 객체 선언
		ServerSocket serverSocket = null;

		// 접속에 관한 정보를 간직하고 제어하는 Socket 객체 선언
		// - 클라이언트와의 실제 연결을 나타내는 객체
		Socket socket = null;
		
		// 클라이언트에게 전송할 메시지
		String msg = "Hello, Client";

		// Object 타입으로 데이터를 주고받기 위한 스트림 객체 선언
		// 객체를 클라이언트로 보내기 위한 ObjectOutputStream 객체를 선언
		ObjectOutputStream oos = null;
		// 클라이언트로부터 객체를 받기 위한 ObjectInputStream 객체를 선언
		ObjectInputStream ois = null;

//		ServerSocket 생성 및 대기
		// ServerSocket(int port) 생성자 사용
		// 대표 포트 1234를 지니는 ServerSocket 객체 생성
		serverSocket = new ServerSocket(1234);

		// 서버는 계속해서 클라이언트의 연결을 대기하며, 연결이 성립되면 아래의 코드 블록을 실행
		while (true) {

			System.out.println("Wait Client ..........");

			// Server.accept() 메소드 => 클라이언트의 접속을 기다림.
			// 클라이언트 접속 시, 해당 클라이언트와의 통신을 위한 Socket 객체를 반환
			socket = serverSocket.accept();

//			클라이언트 접속 정보 출력 및 통신
			// Socket 클래스의 메소드를 이용해
			// 연결된 클라이언트의 IP 주소를 얻어와서 출력
			System.out.println("Clinet IP : " + socket.getInetAddress().getHostAddress());
			System.out.println(socket);

			// ObjectOutputStream,InputStream 객체 생성
			// 클라이언트로 객체를 보내기 위한 ObjectOutputStream 객체를 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			// 클라이언트로부터 객체를 받기 위한 ObjectInputStream 객체를 생성
			ois = new ObjectInputStream(socket.getInputStream());

			// 클라이언트로부터 받은 객체를 읽어와 문자열로 변환한 후, 해당 문자열을 출력
			System.out.println(ois.readObject().toString() + "님이 접속하셨습니다");

//			클라이언트로 데이터를 전송
			// 초기 메시지를 클라이언트로 전송
			oos.writeObject(msg);
			// 현재 날짜를 객체로 만들어 클라이언트로 전송
			oos.writeObject(new Date());
			// 문자열 객체를 클라이언트로 전송
			oos.writeObject(new String("Java Network Programming"));

//			 스트림 및 소켓 해제
			// 통신에 사용된 객체 스트림 해제
			oos.close();
			ois.close();
			// 소켓 객체 해제(클라이언트와의 연결을 종료)
			socket.close();
		}
	}
}
