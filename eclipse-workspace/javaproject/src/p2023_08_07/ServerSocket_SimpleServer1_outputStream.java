package p2023_08_07;

// 간단한 서버를 구현하여, 클라이언트로부터 연결을 받고, 메시지를 전송하는 프로그램
import java.net.*;
import java.io.*;

// 서버를 작성하는 SimpleServer 클래스 - 클라이언트와의 간단한 네트워크 통신을 수행
public class ServerSocket_SimpleServer1_outputStream {
	public static void main(String[] args) {

		// 서버 정보를 간직하고 제어하는 ServerSocket 객체를 선언
		// - 클라이언트의 연결을 받을 때 사용
		ServerSocket server = null;

		// 접속에 관한 정보를 간직하고 제어하는 Socket 객체 선언
		// - 클라이언트와의 실제 연결을 나타내는 객체
		Socket socket = null;

		// 클라이언트에게 데이터를 전송하기 위한 스트림 선언
		OutputStream os;
		DataOutputStream dos;

		// 클라이언트에게 보낼 메시지
		String msg = "Hello, Client";

		try {
//			ServerSocket 생성 및 대기
			// ServerSocket(int port) 생성자 사용
			// 대표 포트 7777을 가진 서버 객체를 생성
			server = new ServerSocket(7777);
			System.out.println("Wait Client......");

			// Socket accept() throws IOException 메소드:
			// Server.accept() 메소드 => 클라이언트의 접속을 기다림.
			// 클라이언트 접속 시, 해당 클라이언트와의 통신을 위한 Socket 객체를 반환
			socket = server.accept();
			
//			클라이언트 접속 정보 출력
			System.out.println("Client Connection Success");
			// 클라이언트의 IP 주소를 얻어옴
			System.out.println("server socket : " + socket.getInetAddress().getHostAddress());

//			데이터 전송
			// DataOutputStream을 사용하여 데이터를 전송
			// 지금 현재 접속한 클라이언트에게 데이터를
			// 전송하기 위해서 출력 스트림을 형성
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			// writeUTF(msg) 메소드를 사용하여 msg 변수에 저장된 메시지를 클라이언트에게 전송
			dos.writeUTF(msg);

//			 스트림 및 소켓 해제
			// 스트림을 해제
			dos.close();
			// 서버와 클라이언트의 연결을 맺고 있는 Socket을
			// .close()를 사용하여 서버와 클라이언트와의 연결을 끊고 Socket 객체를 해제
			socket.close();

		} catch (Exception e) {
			// 네트워크 통신 도중 발생하는 예외를 처리하여 프로그램이 비정상적으로 종료되지 않도록
			e.printStackTrace();
		}
	}
}