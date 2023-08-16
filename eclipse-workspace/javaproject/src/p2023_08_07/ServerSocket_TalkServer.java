package p2023_08_07;

/*
	채팅 서버 애플리케이션
	- 클라이언트와 서버 간에 텍스트 메시지를 주고받을 수 있는 기능을 제공
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*; //java.util.StringTokenizer;
import java.net.*;

public class ServerSocket_TalkServer implements ActionListener {

	Frame serverTalk;
	TextArea view;
	TextField message;

	// 서버와 클라이언트 간의 연결을 관리하기 위한 소켓 관련 클래스 선언
	ServerSocket serverSocket;
	Socket socket;

	// 데이터를 송수신하기 위한 입출력 스트림 클래스 선언
	DataInputStream dis;
	DataOutputStream dos;

	// 생성자 - 제일 먼저 실행되며, 대화를 보내고 화면에 출력시키는 화면 구성
	public ServerSocket_TalkServer() {

		serverTalk = new Frame("Server");

		view = new TextArea(" ", 30, 50, TextArea.SCROLLBARS_NONE);
		view.setEditable(false); // 수정 불가능

		// 생성자에서 클라이언트의 메시지 입력 이벤트를 처리하기 위해 
		// message 텍스트 필드의 ActionListener를 현재 클래스로 설정
		message = new TextField(27);

		Panel p = new Panel();
		p.add(new Label("Message", Label.LEFT));
		p.add(message);

		serverTalk.add(view, "Center");
		serverTalk.add(p, "South");

		// 서버 창의 종료 이벤트를 처리하기 위한 WindowAdapter가 등록
		serverTalk.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		serverTalk.setSize(350, 400);
		serverTalk.setLocation(300, 300);
		serverTalk.setResizable(false);
		serverTalk.setVisible(true);

		message.addActionListener(this);

	}// 생성자 end

	// 클라이언트와 접속 후 소켓을 생성시키는 메소드
	public void waitClient() {

		try {
			// 대표 포트 3333으로 생성된 ServerSocket 객체
			serverSocket = new ServerSocket(3333);
			view.append("Wait Client..........\n");

			// 서버 소켓을 생성하고 대기 상태로 전환하여 클라이언트의 접속을 기다림
			// 클라이언트가 접속하면 해당 클라이언트와의 소켓 연결을 설정
			socket = serverSocket.accept();
			view.append("Clinet Connect........\n");

			// 입출력 스트림 생성
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			// 클라이언트가 접속하자마자 보내는 ID를 TextArea에 출력
			view.append(dis.readUTF() + "님이 입장하셨습니다.\n");

		} catch (IOException ie) {
			System.out.println("서버 소켓 생성 실패");
		}

		// 메시지를 무한 루프로 수신하여 파싱하고, 파싱된 메시지를 화면에 출력
		while (true) {

			try {
				String msg = dis.readUTF().trim();
				String msgPlus = "";

				// 아이디와 대화 내용을 분리하기 위해
				// StringTokenizer 클래스를 이용해 "/"를 기준으로 분리
				StringTokenizer st = new StringTokenizer(msg, "/");
				view.append("[" + st.nextToken() + "] : ");
				while (st.hasMoreTokens()) {
					msgPlus += st.nextToken();
				}
				view.append(msgPlus + "\n");
			} catch (Exception e) {
				System.out.println(e);
			} // catch end

		} // while end

	}// waitClient() end

	
	// 텍스트 필드에 데이터를 입력하고 엔터를 누르는 이벤트 처리
	public void actionPerformed(ActionEvent ae) {

		try {
			// 클라이언트에게 데이터를 전송
			// 전송할 때의 포맷은 아이디/내용의 형식
			dos.writeUTF("Server/" + message.getText());

			view.append("[Server] : " + message.getText() + "\n");
			message.setText("");

		} catch (Exception e) {
		}

	}// actionPerformed() end

	public static void main(String[] args) {
		
		// TalkServer 객체를 생성
		ServerSocket_TalkServer talk = new ServerSocket_TalkServer();
		// waitClient() 메소드를 호출하여 서버의 대기 상태를 시작
		talk.waitClient();
	}
}