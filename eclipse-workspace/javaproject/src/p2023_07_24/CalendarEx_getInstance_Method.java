package p2023_07_24;

// 날짜, 시간 관련 클래스 : Date, Timestamp, Calendar
//: 날짜와 시간을 계산하고 조작하는 다양한 메서드 제공
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarEx_getInstance_Method {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		3. Calendar 클래스
		// # Calendar객체 생성 방법
//		Calendar c1 = new Calendar();	// 오류발생
		// Calendar클래스는 new연산자로 객체생성X
		
		// 1) 업캐스팅(하위 객체를 상위 객체에 전달)
		// 클래스명과 생성자가 같은이름으로 호출되지 않는 경우 => 자료형 변환
		Calendar c2 = new GregorianCalendar();
		
		// 2) 정적메소드 사용하여 객체를 불러옴
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		// Calendar클래스의 toString()메소드는 객체의 정보를 보기쉬운문자열로 반환X
		// 객체의 해시코드와 클래스정보 출력 => 의미있는 정보X
		// java.util.GregorianCalendar[time=1690168250207,...,DST_OFFSET=0]
		
		// Calendar클래스의 정적필드 YEAR은 클래스의 연도 나타내는 상수 = 1
		System.out.println(Calendar.YEAR);
		
		
		// Calendar객체 c에 저장된 각 필드(YEAR, MONTH...)상수의 실제정보를 가져옴
		// Calendar클래스의 정적필드상수 YEAR
		int y = c.get(Calendar.YEAR);	//Calendar 객체 c에서 현재 연도 정보를 가져와 변수 y에 저장
		
		// 월을 나타내는 필드상수 MONTH
		// 월을 가져오는 필드는 0~11까지를 가져옴 => 실제 사용을 위해서는 +1을 해줘야 함
		int m = c.get(Calendar.MONTH);
		int m1 = c.get(Calendar.MONTH)+1;
		
		// 날짜(일)을 나타내는 필드상수 DATE
		// Calendar.DATE상수와 Calendar.DAY_OF_MONTH상수는 동일 값을 가짐
		int d = c.get(Calendar.DATE);
		int d2 = c.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(y+"-"+m1+"-"+d);
		System.out.println(y+"-"+m1+"-"+d2);
		// 2023-7-24
		
		
		// 시간을 나타내는 필드상수 HOUR - 12시간 형식으로 표현됨
		// 0~11까지의 범위를 가짐. 오전/오후 표기법을 사용하여 시간을 표현
		int h1 = c.get(Calendar.HOUR);		// 12시간제
		
		// 오전/오후 나타내는 필드상수 AM_PM
		// 상수값 0(오전)과 1(오후)을 가짐
		// Calendar.AM: 오전을 나타내는 상수로, 값은 0
		// Calendar.PM: 오후를 나타내는 상수로, 값은 1
		int ap = c.get(Calendar.AM_PM);		// 0: 오전, 1: 오후
		if (ap == 0) {	// "0" = 오전
			System.out.print("오전 ");
		} else {		// "1" = 오후
			System.out.print("오후 ");
		}
		
		// 시간을 나타내는 필드상수 HOUR_OF_DAY - 24시간 형식으로 표현됨
		// 0~23까지의 범위를 가짐
		int h2 = c.get(Calendar.HOUR_OF_DAY);	// 24시간제

		
		// 분을 나타내는 필드상수 MINUTE
		// 0~59사이 범위를 가짐
		int mm = c.get(Calendar.MINUTE);
		// 초를 나타내는 필드상수 SECOND
		// 0~59사이 범위를 가짐
		int ss = c.get(Calendar.SECOND);
		
		System.out.println(h1+":"+mm+":"+ss);	// 12시간제
		// 오후 0:33:42
				
		System.out.println(h2+":"+mm+":"+ss);	// 24시간제
		// 12:33:42
		
		// String AmPmStr을 사용하는 방법
//		String AmPmStr;
//		if (ap == Calendar.AM) {
//			AmPmStr = "오전 ";
//		} else {
//			AmPmStr = "오후 ";
//		}
		
		// 삼향 조건 연산자('? :') 사용 : (조건식) ? 값1 : 값2
		String AmPmStr = (ap == Calendar.AM) ? "오전 " : "오후 ";
		System.out.print("Hour: "+AmPmStr+h1+"시\n");
	}
}
