package p2023_08_07;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class Socket_TalkClient implements ActionListener, Runnable {

	// GUI 요소들과 서버와의 통신을 위한 소켓 및 입출력 스트림 변수들이 선언
	Frame first, second;
	TextField ipField;
	TextField idField;
	Button connection;
	TextArea view;
	TextField message;

	// 서버의 접속을 위한 클래스 선언
	Socket clientSocket;
	DataInputStream dis;
	DataOutputStream dos;

//  String name = "gemini"; //대화명

	// 생성자
	public Socket_TalkClient() {
		// 접속 화면 프레임을 생성하고 초기화
		first = new Frame("접속 화면");
		connection = new Button("Connect");

		// Server의 IP 주소와 id를 받아 들이는 TextField 객체 생성
		ipField = new TextField(15);
		idField = new TextField(15);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1, 0, 10));
		p1.add(new Label("Server IP주소", Label.CENTER));
		p1.add(new Label("대화명(ID)", Label.CENTER));

		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(2, 1, 0, 10));
		p2.add(ipField);
		p2.add(idField);

		Panel p3 = new Panel();
		p3.add(p1);
		p3.add(p2);

		// 연결 시도 프레임 구성( BorderLayout(int hgap, int vgap) )
		first.setLayout(new BorderLayout(0, 10));
		first.add(p3, "Center");
		first.add(connection, "South");

		// 윈도우 종료 이벤트 처리
		first.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		first.setSize(300, 150);
		first.setLocation(300, 300);
		first.setVisible(true);

		// 버튼에 ActionEvent를 등록시킴
		connection.addActionListener(this);
	}// 생성자 end

	// 두 번째 프레임을 생성하고 초기화
	public void SecondFrame() throws Exception {

		// view 텍스트 영역과 message 텍스트 필드가 GUI 요소로 등록
		second = new Frame("Client Chatting");
		view = new TextArea(" ", 30, 50, TextArea.SCROLLBARS_NONE);
		view.setEditable(false);
		message = new TextField(27);

		Panel p = new Panel();
		p.add(new Label("Message", Label.LEFT));
		p.add(message);

		second.add(view, "Center");
		second.add(p, "South");

		second.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		second.setSize(350, 400);
		second.setLocation(300, 300);
		second.setVisible(true);

		message.addActionListener(this);

	}// SecondFrame() end

	// 서버와의 연결을 시도하고 소켓을 생성하는 메소드
	public void connectServer(String id, String address) {

		try {
			// 서버와 연결
			clientSocket = new Socket(address, 3333);

			// DataInputStream과 DataOutputStream를 생성하여
			// 클라이언트와 서버 사이의 데이터 송수신을 위한 스트림을 설정
			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());
			dos.writeUTF(idField.getText());

		} catch (IOException e) {
			System.out.println("서버가 없습니다.");
			System.exit(0);
		}

		// 클라이언트 자체도 쓰레드로 구동시킴
		Thread t = new Thread(this);
		// 클라이언트 측에서도 별도의 스레드로 실행되는 run() 메소드를 호출
		t.start(); // run() 메소드 호출
	}// connectServer() end

	// 서버와 연결 후 소켓 객체를 생성하는 메소드
	public void run() {

		try {
			// 주어진 IP와 port를 이용해 소켓 객체 생성
//			clientSocket = new Socket( ipField.getText(), 3333 );

			System.out.println("ip주소 :" + ipField.getText());
			System.out.println("ID :" + idField.getText());
			view.append("Server Connection Success \n");

			// 스트림 객체 생성
//			dos = new DataOutputStream(clientSocket.getOutputStream());
//			dis = new DataInputStream(clientSocket.getInputStream() );

			// 스트림 객체를 생성하자마자 서버에게 ID를 전송함
//			dos.writeUTF( idField.getText() );

		} catch (Exception ie) {
			System.out.println("서버 접속 실패");
		} // catch end

		// 무한 루프를 수행하면서 서버가 보내는 메시지를 출력
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
	}// connect() end

	// 텍스트 필드에 데이터를 입력하고 엔터를 치는 이벤트 처리
	public void actionPerformed(ActionEvent ae) {

		// 접속 버튼을 누를 경우, 서버와의 연결 시도를 하고 두 번째 프레임을 표시
		if (ipField.getText().equals("") && idField.getText().equals("")) {
			System.exit(0);

		} else if (ae.getSource() == connection) {

			try {
				// 서버와 연결 시도
//				clientSocket = new Socket( ipField.getText(), 3333 );

//				dis = new DataInputStream(clientSocket.getInputStream() );
//				dos = new DataOutputStream(clientSocket.getOutputStream());

				// 서버에 접속한 클라이언트의 대화명을 서버로 전송
//				dos.writeUTF( idField.getText() );				

				// 연결 시도 프레임을 화면에서 사라지게 함
				first.setVisible(false);

				// 연결 시도 프레임의 자원을 반납
				first.dispose();

				// 두 번째 프레임을 화면에 출력시킴
				SecondFrame();
				connectServer(idField.getText(), ipField.getText());

			} catch (Exception e) {
//				System.out.println( "소켓 생성 실패" );
				System.out.println("두번째 프레임이 나타나지 않습니다.");
			}

		} else if (ae.getSource() == message) {

			try {
				// 서버로 데이터를 전송하는 부분
				// 전송할 때의 포맷은 아이디/내용의 형식
				dos.writeUTF(idField.getText() + "/" + message.getText());

				view.append("[" + idField.getText() + "] : " + message.getText() + "\n");
				message.setText("");

			} catch (Exception e) {
				System.out.println("데이터 전송 실패");
			} // catch end

		} // if end

	}// actionPerformed() end

	public static void main(String[] args) {
		// TalkClient 객체를 생성하여 클라이언트 애플리케이션을 시작
		Socket_TalkClient tc = new Socket_TalkClient();
	}
}