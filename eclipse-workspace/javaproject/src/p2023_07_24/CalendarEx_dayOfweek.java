package p2023_07_24;

// 날짜, 시간 관련 클래스 : Date, Timestamp, Calendar
// : 날짜와 시간을 계산하고 조작하는 다양한 메서드 제공
import java.util.Calendar;

// calendar클래스에는 요일을 나타내는 직접적인 필드X
// calendar.get(Calendar.DAY_OF_WEEK) : 현재 요일에 해당하는 숫자
public class CalendarEx_dayOfweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 추상클래스 => 직접 객체생성X
		// 정적메소드 getInstance()사용하여 객체생성
		Calendar calendar = Calendar.getInstance();
		// 현재 날짜와 시간정보를 가진 calendar객체 생성
		
		// 각 요일을 얻을수 있는 DAY_OF_WEEK필드 활용
		// 일요일(1) ~ 토요일(7)까지의 요일 나타냄
		int dayOfweek = calendar.get(Calendar.DAY_OF_WEEK);
		// Calendar.DAY_OF_WEEK로 현재 요일 값을 가져옴
		
		// Calendar필드상수값 가져옴 - YEAR, MONTH, DATE
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		// 년, 월, 일 출력
		System.out.println(year+"년 "+month+"월 "+date+"일");
		
		// Calendar필드상수값 가져옴 - HOUR(12시간제), AM_PM, MINUTE, SECOND
		int hour = calendar.get(Calendar.HOUR);
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY);
		int ampmInt = calendar.get(Calendar.AM_PM);
		String AmPmStr = (ampmInt == Calendar.AM) ? "오전 " : "오후 ";
		
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		
		// 요일 이름 문자열 배열 (인덱스를 1부터 시작하도록 null 추가)
		String[] weekArr = new String[] {"일", "월", "화", "수", "목", "금", "토"};
				
		System.out.println(AmPmStr+hour+"시 "+min+"분 "+ sec+"초 "+ weekArr[dayOfweek-1]+"요일");
		System.out.println(hour24+"시 "+min+"분 "+ sec+"초 "+ weekArr[dayOfweek-1]+"요일");
	}

}
