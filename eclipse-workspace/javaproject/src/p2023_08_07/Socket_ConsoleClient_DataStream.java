package p2023_08_07;

/*
 * 클라이언트가 서버에 연결하여 사용자로부터 메시지를 입력받고, 
 * 그 메시지를 서버로 전송하고 서버로부터 메시지를 받아 출력하는 간단한 클라이언트 어플리케이션
 */
import java.io.*;
import java.net.*;

//클라이언트 어플리케이션 - 서버에 접속하여 서버로부터 전송되는 데이터를 받아오는 역할을 수행
public class Socket_ConsoleClient_DataStream {

	public static void main(String[] args) {

//		1. Socket 객체 및 입력 스트림 선언
		// - 서버에 접속(연결)하기 위한 클라이언트의 Socket 객체 선언
		Socket socket = null;
		
		// 서버로 데이터를 보내기 위한 DataOutputStream 객체를 선언하고 초기화
		DataOutputStream dos = null;
		// 서버로부터 데이터를 받기 위한 DataInputStream 객체를 선언하고 초기화
		DataInputStream dis = null;

//		2. 서버에 접속 및 데이터 통신
		try {
			// Socket(String host, int port)생성자로 socket 객체 생성
			// 접속하려는 서버의 IP 주소와 포트 번호를 지정하여 서버에 접속
			socket = new Socket("172.30.1.69", 9876);

			// 서버와 데이터를 주고받기 위한 스트림 형성
			// - 서버로 데이터를 보내기 위한 DataOutputStream 객체를 생성
			dos = new DataOutputStream(socket.getOutputStream());
			// - 서버로부터 데이터를 받기 위한 DataInputStream 객체를 생성
			dis = new DataInputStream(socket.getInputStream());

//			3. 데이터 송수신
			// 무한 루프
			while (true) {
				// 사용자로부터 문자열을 입력받아 message 변수에 저장
				System.out.print("Client input Message : ");
				String message = Socket_TalkStatement_BRreadLine.readString();

				// 입력받은 메시지를 UTF-8 형식으로 인코딩하여 서버에 전송
				dos.writeUTF(message);

				// DataInputStream을 통해 서버로부터 받은 데이터를 읽어와 출력
				System.out.println("Server Message : " + dis.readUTF());
			}

		} catch (Exception e) {
			try {
				// 사용한 스트림과 소켓을 닫아 리소스를 해제
				dos.close();
				dis.close();
				socket.close();
			} catch (IOException io) {
				System.out.println(io);
			}
		} // catch end
	}// main end
}
