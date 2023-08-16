package p2023_07_24;

//날짜, 시간 관련 클래스 : Date, Timestamp, Calendar
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

// Timestamp는 특정 시점의 날짜, 시간정보를 저장하는 데이터 형식
// => 바로 요일정보를 제공하지는 X
// => Timestamp -> Date -> Calendar
public class TimestampEx_weekday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 현재시간으로 Timestamp 객체 생성
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// System.currentTimeMillis(): 현재 시간을 long형의 밀리초 단위로 반환

		// 1. Timestamp객체를 Calendar객체로 변환
		// 	  => Timestamp -> Date -> Calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(timestamp.getTime()));
		// timestamp.getTime(): getTime() 메소드를 사용하여 long 타입의 밀리초 시간을 얻음
		// new Date(timestamp.getTime()): java.util.Date로 변환
		
		
		// 2. Calendar객체에서 Calendar.DAY_OF_WEEK를 이용해 요일정보
		int dayOfweek = calendar.get(Calendar.DAY_OF_WEEK);
		String[] weekArr = new String[] {null, "일", "월", "화", "수", "목", "금", "토"};
		
		// 요일이름 출력
		System.out.println(weekArr[dayOfweek]+"요일");
		
	}

}
