package p2023_07_24;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

// 날짜, 시간 관련 클래스 : Date, Timestamp, Calendar
public class DateEx_TimestampEx_simpleDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1. Date
		// - SimpleDateFormat클래스를 사용하여
		//	 년, 월, 일, 시, 분, 초, 요일로 날짜를 출력
		// 	 - 생성자의 format지정가능
		SimpleDateFormat simpledate1 = 
				new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
		
		SimpleDateFormat simpledate2 = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		
		SimpleDateFormat simpledate3 = 
				new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEE요일");
		
		SimpleDateFormat simpledate4 = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss EEE요일");
//		- yyyy: 년도(4자리)
//		- MM : 월(2자리)
//		- dd: 일(2자리)
//		- a: 오전/오후
//		- HH: 시간(24시간 형식, 2자리)	/	hh: 시간(12시간 형식, 2자리)
//		- mm:분(2자리)
//		- ss: 초(2자리)
//		- EEE: 요일(월/화/수/목/금/토/일)
		
		Date date = new Date();
		System.out.println(date);
		// Mon Jul 24 11:08:39 KST 2023
		// 따라서, date객체를 바로 사용하는 경우는 적음
		
		// SimpleDateFormat의 format메소드 사용하여 출력
		System.out.println(simpledate1.format(date));
		// 2023년 07월 24일 오전 11:27:24
		
		System.out.println(simpledate2.format(date));
		// 2023년 07월 24일 11:27:24
		
		System.out.println(simpledate3.format(date));
		// 2023년 07월 24일 오전 11:30:44 월요일
		
		System.out.println(simpledate4.format(date));
		// 2023년 07월 24일 11:30:44 월요일
		
		
//		2. Timestamp
		// 현재 시간으로 Timestamp 객체 생성
		SimpleDateFormat simpleStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// System.currentTimeMillis(): 현재 시간을 long형의 밀리초 단위로 반환
		
		System.out.println(timestamp);
		// 2023-07-24 11:41:35.116
		
		System.out.println(simpleStamp.format(timestamp));
		// 2023-07-24 11:48:04
		
		
	}

}
