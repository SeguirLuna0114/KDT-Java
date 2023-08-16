package p2023_08_04;

/* 
	Java Swing GUI 애플리케이션을 이용하여 시계 기능을 구현하는 프로그램
	시계 창이 생성되고, 시간이 1초마다 업데이트되어 표시됨
*/
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Report_0803_Thread_SwingGUI_ClockDate_proff extends JFrame implements Runnable {
	// JFrame을 상속하고 Runnable 인터페이스를 구현한 클래스
	// 시계 창을 생성하고 시간을 업데이트하는 역할 수행
	
	private JTextField jf;

	// 기본생성자
	public Report_0803_Thread_SwingGUI_ClockDate_proff() {
		// super()키워드로 JFrame의 생성자를 호출 -> 시계 창을 초기화하고 구성
		super("스레드를 이용한 시계");
		
		setLayout(new FlowLayout());

		jf = new JTextField(20);
		add(new JLabel("현재시간:"));
		add(jf);

		setSize(350, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	// Runnable 인터페이스의 run()메소드를 구현
	// -> 스레드가 실행될 때 실제로 수행되는 로직이 구현됨
	public void run() {
		// TODO Auto-generated method stub

		// SimpleDateFormat클래스 사용
		// => 현재 시간을 "yyyy-MM-dd HH:mm:ss" 형식으로 포맷
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 무한 루프로 반복하여 시계가 실시간으로 업데이트
		while (true) {
			try {
				Date d = new Date();
				// JTextField에 표시
				jf.setText(sd.format(d));
				
				// sleep()메소드로 1초간 일시 정지한 후 다시 현재 시간을 업데이트
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// sleep()메소드 사용시, InterruptException 예외처리 필수
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Runnable인터페이스를 구현한 클래스의 객체 생성
		Report_0803_Thread_SwingGUI_ClockDate_proff c = new Report_0803_Thread_SwingGUI_ClockDate_proff();
		
		// 2. Thread 클래스의 생성자에 myRunnable 객체를 전달하여,
	    //   새로운 스레드클래스의 객체(thread) 생성
		Thread t = new Thread(c);
		
		// start() 메서드를 호출하여 스레드를 시작
		t.start();
//		t.run();		
	}

}
