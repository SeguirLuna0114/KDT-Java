package p2023_08_07;

/* 	클라이언트를 구현하여 지정한 서버에 접속하고 서버로부터 전송된 데이터를 받아 출력하는 프로그램
	클라이언트는 서버로 아이디를 보내고 서버로부터 메시지와 날짜 정보를 받아와 출력
	
	데이터를 객체 단위로 주고받을 때에는 
	ObjectInputStream과 ObjectOutputStream을 사용하여 직렬화된 데이터를 다룸
*/
import java.net.*;
import java.io.*;
import java.util.Date;

// 클라이언트 서버 - 서버에 접속하여 서버로부터 전송되는 데이터를 받아오는 역할을 수행
public class Socket_SimpleClient2_ObjectStream {
	public static void main(String[] args) throws Exception {
		// Server Socket 객체생성시 발생할 수 있는 예외처리(throws Exception)

//		1. Socket 객체 및 입력 스트림 선언
		// - 서버에 접속하기 위한 클라이언트의 Socket 객체 선언
		Socket socket;

		// Object로 데이터를 주고 받기 위한 스트림 객체 선언
		// 서버로부터 객체를 받기 위한 ObjectInputStream 객체를 선언
		// - ObjectInputStream은 직렬화된 객체를 읽어오기 때문에 
		// 	 해당 객체의 클래스 구조나 직렬화 버전 등의 일치가 필요
		ObjectInputStream ois;
		// 서버로 객체를 보내기 위한 ObjectOutputStream 객체를 선언
		ObjectOutputStream oos;

		// 서버로부터 받은 메시지를 저장할 변수를 선언
		String serverMsg = null;

		// 서버에 보낼 아이디를 정의
		String ID = "gemini";

		// Socket(String host, int port)생성자로 socket 객체 생성
		// : 지정된 IP 주소와 포트 번호를 가진 서버에 접속하기 위한 Socket 객체를 생성
		// - 서버의 접속정보를 갖고있음
		socket = new Socket("172.30.1.69", 1234);	// 본인 IPv4 주소(172.30.1.69)
		System.out.println("Server Connection Success");

		// 서버와 ObjectInputStream, ObjectOutputStream 스트림 형성
		// 서버로부터 객체를 받기 위한 ObjectInputStream 객체를 생성
		ois = new ObjectInputStream(socket.getInputStream());
		//  서버로 객체를 보내기 위한 ObjectOutputStream 객체를 생성
		oos = new ObjectOutputStream(socket.getOutputStream());

		// 클라이언트의 아이디를 서버로 전송
		oos.writeObject(ID);

		// 서버로부터 받은 객체를 문자열로 변환하여 serverMsg 변수에 저장
		serverMsg = new String(ois.readObject().toString());
		// 서버로부터 받은 객체를 Date 객체로 변환하여 d 변수에 저장
		Date d = (Date) ois.readObject();

		// 서버로부터 받은 메시지 출력
		System.out.println("서버에서 전송된 메시지");
		System.out.println(serverMsg);
		System.out.println(d.toString());
		System.out.println(ois.readObject().toString());

		// 스트림 및 소켓 해제(데이터 수신이 끝나면 입력 스트림을 닫음)
		// 스트림 객체 해제( 통신에 사용된 객체 스트림을 닫음)
		oos.close();
		ois.close();
		// 소켓 객체 해제(클라이언트와 서버의 연결을 종료)
		socket.close();
	}// main() end
}