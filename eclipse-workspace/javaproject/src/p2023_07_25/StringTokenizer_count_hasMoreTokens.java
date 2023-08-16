package p2023_07_25;

import java.util.*;

// StringTokenizer 클래스
// : 특정 문자열에서 구분기호(#)를 이용해서 데이터를 파싱한 다음에 문자열(토큰)을 구해오는 경우 사용
// - 토큰(token): 구분기호를 사용해 파싱된 문자열
// - 사용 가능한 경우가 한정적임(정해져 있음)

// nextToken()메소드: 토큰을 가져온다는 의미
// countTokens()메소드:  파싱된 문자열이 모두 몇 개인지 되는지 알려줌
// hasMoreTokens()메소드 : token이 있으면 true, 없으면 false로 결과반환
class StringTokenizer_count_hasMoreTokens {

	public static void main(String[] args) {
		
		// StringTokenizer(String str, String delim) 생성자 사용
		StringTokenizer str 
				= new StringTokenizer("이순신#을지문덕#강감찬#광개토대왕", "#");

		// nextToken()메소드: 
//		System.out.println(str.nextToken());	// 이순신
//		System.out.println(str.nextToken());	// 을지문덕
//		System.out.println(str.nextToken());	// 강감찬
//		System.out.println(str.nextToken());	// 광개토대왕
//		System.out.println(str.nextToken());	// NoSuchElementException 예외 발생
		// Token이 없는데 가져오라는 명령을 실행했기에, 예외 발생
		
		// countTokens()메소드:  파싱될 문자열이 모두 몇 개인지 되는지 알려줌
		int cnt = str.countTokens();
		System.out.println("파싱할 문자열의 총갯수-> " + cnt);

		System.out.println(str.nextToken());
		
		// hasMoreTokens()메소드 : token이 있으면 true, 없으면 false로 결과반환
		// -예외 발생되지 않고, 파싱(문자열을 자르는 것)되는 token(잘라진 문자열)의 문자열 출력
		while (str.hasMoreTokens()) { // 토큰이 있으면 true => while문 실행
			// 차례대로 파싱된 문자열을 얻어온다.
			System.out.print(str.nextToken()+"\t");
		}

	} // main() end

}