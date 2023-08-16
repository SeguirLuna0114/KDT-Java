package p2023_08_07;

/*
	클라이언트의 연결을 대기하며 연결이 성립되면 
	클라이언트와 데이터를 주고받는 간단한 서버 애플리케이션
 */
import java.io.*;
import java.net.*;

// 서버 애플리케이션은 클라이언트의 연결을 기다리고, 연결이 성립되면 클라이언트와 데이터를 주고받음
public class ServerSocket_ConsoleServer_DataStream {

	public static void main(String[] args) {

		// 서버에서 클라이언트의 연결을 대기하는데 사용되는 ServerSocket 객체를 선언
		ServerSocket server = null;
		// 클라이언트와의 연결을 담당하는 Socket 객체를 선언
		Socket socket = null;

		// 클라이언트로부터 데이터를 받기 위한 DataInputStream 객체를 선언하고 초기화
		DataInputStream dis = null;
		// 클라이언트로 데이터를 보내기 위한 DataOutputStream 객체를 선언하고 초기화
		DataOutputStream dos = null;

		try {
			// 대표 포트 9876을 지닌 ServerSocket 객체 생성
			server = new ServerSocket(9876);

			System.out.println("Wait Client.........");
			
			// Server.accept() 메소드 => 클라이언트의 접속을 기다림(대기)
			// 클라이언트 접속 시, 해당 클라이언트와의 통신을 위한 Socket 객체를 반환
			socket = server.accept();

			System.out.println("Client Connection Success");
			System.out.println();

			// 클라이언트와 데이터를 주고받기 위한 입출력 스트림 생성
			// InputStream is = socket.getInputStream();
			// OutputStream os = socket.getOutputStream();
			
			// 클라이언트로부터 데이터를 받기 위한 DataInputStream 객체를 생성
			dis = new DataInputStream(socket.getInputStream());
			// 클라이언트로 데이터를 보내기 위한 DataOutputStream 객체를 생성
			dos = new DataOutputStream(socket.getOutputStream());

			// 무한 루프
			while (true) {

				// 클라이언트로부터 받은 데이터를 읽어와 출력
				System.out.println("Client Message : " + dis.readUTF());
				
				// 서버에서 입력할 메시지를 출력
				System.out.print("Server input message : ");
				// 서버에서 키보드로부터 문자열을 입력받아 message 변수에 저장
				String message = Socket_TalkStatement_BRreadLine.readString();

				//  입력받은 메시지를 UTF-8 형식으로 인코딩하여 클라이언트로 전송
				dos.writeUTF(message);
			} // while end

		} catch (Exception e) {

			try {
				// 사용한 스트림과 소켓을 닫아 리소스를 해제
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException io) {
				System.out.println(io);
			} // catch end

		} // catch end

	}// main end
}
