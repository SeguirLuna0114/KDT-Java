package p2023_08_07;
/*
	GUI 클라이언트 애플리케이션을 구현한 예제로, 
	사용자가 서버에 연결하고 데이터를 주고받을 수 있는 기능을 제공
	
	첫 번째 프레임에서 서버의 IP 주소와 ID를 입력하고 "Connect" 버튼을 클릭하면 
	두 번째 프레임에서 연결 상태와 서버로부터 받은 메시지가 출력
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*; //java.util.Date;
import java.net.*;

public class Socket_GUIClient_ObjectStream implements ActionListener {

	// Client GUI를 구성하기 위한 component 선언
	// 첫 번째와 두 번째 GUI 프레임
	Frame first;
	Frame second;
	
	// 사용자로부터 서버 IP 주소와 ID를 입력받는 텍스트 필드
	TextField ipField;
	TextField idField;
	
	// Connect"라는 텍스트를 가진 버튼
	Button connection;
	// 서버와의 연결 상태와 서버로부터 받은 메시지를 표시하는 텍스트 영역
	TextArea connectState;

	// 서버와의 연결(접속)을 위한 Socket 객체 선언
	Socket socket;

	// 데이터 송수신을 위한 Object 스트림 클래스 객체 선언
	ObjectInputStream dis;
	ObjectOutputStream dos;

	// 서버로부터 전송된 메시지를 저장하는 변수 선언
	String serverMsg = null;

	// 생성자 -  GUI 클라이언트 애플리케이션의 초기 설정과 UI 구성
	public Socket_GUIClient_ObjectStream() {

		first = new Frame("연결 시도");
		connection = new Button("Connect");

		// Server의 IP 주소와 id를 받아 들이는 TextField 객체 생성
		ipField = new TextField(15);
		idField = new TextField(15);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1, 0, 10));
		p1.add(new Label("Server", Label.CENTER));
		p1.add(new Label("ID", Label.CENTER));

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

	// 서버와의 접속이 성공적으로 이루어졌을 경우, 화면에
	// 출력되는 두 번째 프레임을 구성하는 메소드
	public void secondFrame() throws Exception {

		second = new Frame("Client");
		connectState = new TextArea(80, 80);

		// 윈도우 종료 이벤트 처리
		second.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		second.add(connectState, "Center");

		// 서버와의 연결이 성공적으로 이루어졌음을 TextArea에 출력
		connectState.append("Connection Success" + "\n");

		// Object를 받아들이기 위한 ObjectInputStream 객체 생성
		// InputStream is = socket.getInputStream();
		dis = new ObjectInputStream(socket.getInputStream());

		// 서버에서 전송된 데이터를 저장
//		serverMsg = new String( dis.readObject().toString() );
		serverMsg = (String) dis.readObject();
		Date d = (Date) dis.readObject();

		// TextArea에 데이터를 출력
		connectState.append(serverMsg + "\n");
//		connectState.append( d.toString() + "\n" );
		connectState.append(d + "\n");

		second.setSize(300, 200);
		second.setLocation(300, 300);
		second.setVisible(true);
	}// secondFrame() end

	// 버튼에 이벤트가 발생하면 처리해주는 method 선언
	public void actionPerformed(ActionEvent ae) {

		// 두 개의 TextField에 공백이 입력되면 프로그램 종료
		if (ipField.getText().equals("") && idField.getText().equals("")) {
			System.exit(0);

		// Connect" 버튼을 클릭하면 서버와 연결을 시도
		} else if (ae.getSource() == connection) {

			try {
				// 서버와 연결 시도
				socket = new Socket(ipField.getText(), 2222);

				// ObjectOutputStream 객체를 생성해 ID 값을 전송
				// OutputStream os = socket.getOutputStream();
				dos = new ObjectOutputStream(socket.getOutputStream());
				dos.writeObject(idField.getText());

				// 연결 시도 프레임을 화면에서 사라지게 함
				first.setVisible(false);

				// 연결 시도 프레임의 자원을 반납
				first.dispose();

				// 두 번째 프레임을 화면에 출력시킴
				secondFrame();

			} catch (Exception e) {
				System.out.println("소켓 생성 실패");
			}
		} // if ~ else if end
	}// actionPerformed() end

	public static void main(String[] args) {
		
		// GUIClient클래스의 객체를 생성하여 애플리케이션을 실행
		Socket_GUIClient_ObjectStream gui = new Socket_GUIClient_ObjectStream();
	}
}