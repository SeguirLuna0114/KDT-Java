package p2023_07_25;

import java.util.StringTokenizer;

//StringTokenizer 클래스
//: 특정 문자열에서 구분기호(#)를 이용해서 데이터를 파싱한 다음에 문자열(토큰)을 구해오는 경우 사용
//- 토큰(token): 구분기호를 사용해 파싱된 문자열
//- 사용 가능한 경우가 한정적임(정해져 있음)

// nextToken()메소드: 토큰을 가져온다는 의미
public class StringTokenizer_nextToken {

	public static void main(String[] args) {
	
		String source1="111-111|강원도|춘천시|퇴계동";
		StringTokenizer st1=new StringTokenizer(source1,"|");
		
		// nextToken()메소드: 토큰을 가져온다는 의미
		String zip=st1.nextToken();
		String dou=st1.nextToken();
		String si=st1.nextToken();
		String dong=st1.nextToken();

		System.out.println("우편번호:" +zip);
		System.out.println("도:" +dou);
		System.out.println("시:" +si);
		System.out.println("동:" +dong);
	}

}
