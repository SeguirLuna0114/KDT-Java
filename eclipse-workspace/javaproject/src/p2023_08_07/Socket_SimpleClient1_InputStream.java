package p2023_08_07;

/* 	클라이언트를 구현하여 지정한 서버에 접속하고 서버로부터 전송된 데이터를 받아 출력하는 프로그램
	단순한 바이트 데이터를 다루는 경우
 	InputStream과 DataInputStream을 사용하여 바이트 단위의 입출력을 수행
*/
import java.io.*;
import java.net.*;

// 클라이언트 서버 - 서버에 접속하여 서버로부터 전송되는 데이터를 받아오는 역할을 수행
public class Socket_SimpleClient1_InputStream {
	public static void main(String[] args) {

//		1. Socket 객체 및 입력 스트림 선언
		// 접속에 관한 정보를 간직하고 제어하는 Socket 객체 선언
		// - 서버에 접속하기 위한 클라이언트의 소켓 객체
		Socket socket = null;

		// 서버에서 전송되는 데이터를 받기 위한 입력 스트림 객체 선언
		// - InputStream은 그냥 바이트 데이터를 읽어오는 용도로 사용되므로 
		// 클래스나 객체의 구조에 대한 특별한 제약
		InputStream is = null;
		DataInputStream dis = null;

//		2. 서버로부터 전송된 데이터를 저장하기 위한 변수 선언
		String serverMsg = null;

//		3. 서버에 접속 및 데이터 수신
		try {
			// Socket(String host, int port)생성자로 socket 객체 생성
			// 접속하려는 서버의 IP 주소와 포트 번호를 지정하여 서버에 접속
			socket = new Socket("172.30.1.69", 7777);	// 본인 IPv4 주소(172.30.1.69)
			System.out.println("Server Connection Success");
			System.out.println("client Socket : " + socket);

			// 현재 접속한 서버와 스트림 형성
			// socket.getInputStream()메소드: 클라이언트 소켓과 연결된 입력 스트림을 생성
			is = socket.getInputStream();
			// DataInputStream 객체를 생성하여 데이터를 받기 위한 준비
			dis = new DataInputStream(is);
			// String readUTF()메소드: 서버에서 전송된 UTF-8 인코딩의 데이터를 읽어와 serverMsg 변수에 저장
			serverMsg = new String(dis.readUTF());
			
//			4. 서버에서 받은 데이터 출력
			System.out.println("서버에서 전송된 메시지 : " + serverMsg);

//			5. 스트림 및 소켓 해제(데이터 수신이 끝나면 입력 스트림을 닫음)
			// 스트림을 해제
			dis.close();
			// 서버와의 연결을 끊고 클라이언트 소켓을 해제
			socket.close();

		} catch (Exception e) {
			// 네트워크 통신 도중 발생하는 예외를 처리하여 프로그램이 비정상적으로 종료되지 않도록
			e.printStackTrace();
		}
	}// main() end
}