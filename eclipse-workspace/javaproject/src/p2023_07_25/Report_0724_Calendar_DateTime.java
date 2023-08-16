package p2023_07_25;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Report_0724_Calendar_DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3.Calendar

		// Calendar c2 = new Calendar();

		// Calendar c1 = new GregorianCalendar();//업캐스팅

		Calendar c = Calendar.getInstance();

		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) + 1;// 0~11
		int d = c.get(Calendar.DATE);

		int h1 = c.get(Calendar.HOUR); // 12시간
		int ap = c.get(Calendar.AM_PM); // 0:오전
										// 1:오후
		int h2 = c.get(Calendar.HOUR_OF_DAY); // 24시간
		int mm = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);

		System.out.println(y + "년 " + m + "월 " + d + "일");
		if (ap == 0) {
			System.out.println("오전");
		} else {
			System.out.println("오후");
		}
		System.out.println(h1 + ":" + mm + ":" + s);

		int w = c.get(Calendar.DAY_OF_WEEK);// 1~7
		System.out.println("w=" + w);
		// 1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토
		String[] week = { "일", "월", "화", "수", "목", "금", "토" };

		System.out.println(week[w - 1] + "요일");
		
		// 배열을 쓰지 않는경우
//		if (w == 1) {
//			System.out.println("일요일");
//		} else if (w==2) {
//			System.out.println("월요일");
//		} else if (w==3) {
//			System.out.println("화요일");
//		} 
		// 이처럼 각 정수에 해당하는 값을 출력하게 해야 함 => 길이가 너무 길어짐
		
		
	}

}
