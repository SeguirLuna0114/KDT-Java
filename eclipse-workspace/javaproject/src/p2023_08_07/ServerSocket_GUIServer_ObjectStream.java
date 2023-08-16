package p2023_08_07;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*; //java.util.Date;
import java.net.*;

public class ServerSocket_GUIServer_ObjectStream {

	Frame f;
	TextArea view;
	ServerSocket serversocket;
	Socket socket;

	// 클라이언트에 전송할 메시지
	String msg = "Hello, Client";

	// 클라이언트와 스트림을 형성할 객체 선언
	ObjectOutputStream dos;
	ObjectInputStream dis;

	// 생성자 메소드이므로 제일 먼저 실행됨
	// Server의 GUI 폼을 화면에 출력함
	public ServerSocket_GUIServer_ObjectStream() {

		f = new Frame("Server");
		view = new TextArea();

		// Window의 종료 이벤트 처리
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.add(view, "Center");
		f.setSize(400, 150);
		f.setLocation(300, 300);
		f.setVisible(true);
	}// 생성자 end

	// server를 실제로 구동시키는 메소드
	public void startServer() throws Exception {

		// 대표 포트로 2222번을 지니는 ServerSocket 객체 생성
		serversocket = new ServerSocket(2222);

		// 무한 루프를 돌면서 클라이언트의 접속을 기다림
		while (true) {
			view.append("Client의 접속을 기다립니다....\n");

			// 클라이언트의 접속을 처리하는 부분
			socket = serversocket.accept();

			// 클라이언트가 접속한 서버의 IP를 TextArea에 출력
			view.append("IP:" + socket.getInetAddress().getHostAddress() + "\n");

			// 스트림 형성
			// InputStream is = socket.getInputStream();
			// OutputStream os = socket.getOutputStream();
			dis = new ObjectInputStream(socket.getInputStream());
			dos = new ObjectOutputStream(socket.getOutputStream());

			// 클라이언트가 전송하는 ID를 TextArea에 출력
//	    	view.append( "[" +dis.readObject().toString() + "]" + 
			view.append("[" + dis.readObject() + "]" + " 님이 접속하셨습니다.\n");

			// 클라이언트에 Object 전송
			dos.writeObject(msg);
			dos.writeObject(new Date());

			// 스트림과 Socket 해제
			dos.close();
			dis.close();
			socket.close();
		} // while end
	}// startServer() end

	public static void main(String[] args) { // throws Exception {
		ServerSocket_GUIServer_ObjectStream server = new ServerSocket_GUIServer_ObjectStream();

		try {
			server.startServer();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}// main() end
}