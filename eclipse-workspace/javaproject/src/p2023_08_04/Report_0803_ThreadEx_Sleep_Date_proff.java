package p2023_08_04;

import java.text.SimpleDateFormat;
import java.util.Date;

/* Thread를 이용해서 현재 시간을 1초에 한번씩 출력하는 프로그램

	Thread.sleep(milliseconds) 메서드를 활용하여 구현
: 지정된 시간 동안 스레드를 일시 중지하는 역할
- 주로 스레드의 실행 간격을 조절하는데 사용
- milliseconds 매개변수 : 스레드를 일시 중지할 시간을 밀리초 단위로 지정

	SimpleDateFormat클래스를 사용하여 연, 월, 일, 시, 분, 초 를 출력(생성자의 format지정가능)
*/
public class Report_0803_ThreadEx_Sleep_Date_proff implements Runnable{

	@Override
	// run()메소드 구현 - 스레드가 실행할 작업내용을 정의
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = 
			new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		
		while(true){
			try{
				/* 
				 * 루프 안에서 Date 클래스의 객체를 생성
				 * => 객체 생성이 반복될 때마다 메모리에 새로운 객체가 생성되어,
				 * 	  이전 객체는 가비지 콜렉터에 의해 정리됨
				*/
				Date d = new Date();
				System.out.println(sf.format(d));
				Thread.sleep(1000);
			}catch(Exception e){				
			}			
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Runnable인터페이스를 구현한 클래스의 객체 생성
		Report_0803_ThreadEx_Sleep_Date_proff tx = new Report_0803_ThreadEx_Sleep_Date_proff();
		
		// 2. Thread 클래스의 생성자에 tx 객체를 전달하여,
	    //  새로운 스레드클래스의 객체(t) 생성
		Thread t = new Thread(tx);
		
		// start() 메서드를 호출하여 스레드를 시작
		t.start();
	}

}
