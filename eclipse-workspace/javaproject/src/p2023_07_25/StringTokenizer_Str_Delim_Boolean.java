package p2023_07_25;

import java.util.StringTokenizer;

//StringTokenizer 클래스
//: 특정 문자열에서 구분기호(#)를 이용해서 데이터를 파싱한 다음에 문자열(토큰)을 구해오는 경우 사용
//- 토큰(token): 구분기호를 사용해 파싱된 문자열
//- 사용 가능한 경우가 한정적임(정해져 있음)

// StringTokenizer(String str, String delim, boolean returnDelims)
// boolean returnDelims - True: 구분기호(delim)도 토큰으로 인식 => 같이 출력

//hasMoreTokens()메소드 : token이 있으면 true, 없으면 false로 결과반환
public class StringTokenizer_Str_Delim_Boolean {

	public static void main(String[] args) {
	
		// StringTokenizer생성자
		// StringTokenizer(String str, String delim)
		
		// 구분기호 - 공백(" ")
		String source1="한국 미국 태국 중국 이란";
		StringTokenizer st1=new StringTokenizer(source1," ");
		
		// boolean hasMoreTokens()메소드
		// : 가져올 token이 있으면 true, 없으면 false를 리턴
		while(st1.hasMoreTokens()){	// 가져올 토큰이 있으면 true가 되어 while문 실행
			System.out.println("st1.token:"+st1.nextToken());
		}
		
		System.out.println();
		System.out.println();
		
		// 구분기호 - 컴마(,)
		String source2="푸들,삽살개,풍산개,진돗개";
		StringTokenizer st2=new StringTokenizer(source2,",");
		
		// boolean hasMoreTokens()메소드
		// : 가져올 token이 있으면 true, 없으면 false를 리턴
		while(st2.hasMoreTokens()){
			System.out.println("st2.token:"+st2.nextToken());
		}
		
		System.out.println();
		System.out.println();		
		
		// StringTokenizer생성자
		// StringTokenizer(String str, String delim, boolean returnDelims)
		// boolean returnDelims - True: 구분기호(delim)도 토큰으로 인식 => 같이 출력
		StringTokenizer st3=new StringTokenizer(source2,",",true);
		
		// boolean hasMoreTokens()메소드
		// : 가져올 token이 있으면 true, 없으면 false를 리턴
		while(st3.hasMoreTokens()){
			System.out.println("st3.token:"+st3.nextToken());
		}
	}

}
