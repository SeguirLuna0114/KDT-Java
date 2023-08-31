package easy;

import java.util.HashMap;
import java.util.Map;

/** 로마 숫자를 아라비아 숫자로 바꾸는 로직
 * "Given a roman numeral, convert it to an integer"
 * - Roman numerals are represented by seven different symbols
 * 	I(1)	V(5)	X(10)	L(50)	C(100)	D(500)	M(1000)
 * - Roman numerals are written largest to smallest from left to right
 * 
 * 1. 각각의 로마자에 대입되는 숫자들을 더하는데 기본 규칙
 * 		ex) CM : 1000(M) - 100(C) = 900
 * 2. 현재 숫자보다 다음 숫자가 더 클 경우, 다음 숫자에서 현재 숫자를 뺀다
 * 		ex) MCMXCIV : 1000 + 900 (M-C) + 90 (C - X) + 4 (V-I) = 1994 
 */
public class P13_Roman_to_Integer {
	
//	방법1. 기본 규칙만을 적용하여 로마자를 아라비아숫자로 변환
	static int RomanToInt(String s) {
		
		// 로마자와 아라비아 숫자를 키-밸류 쌍으로 다루기 위해 해쉬맵을 선언
		Map<String, Integer> romanInt = new HashMap<String, Integer>();
		
		// 로마 숫자와 아라비아 숫자 쌍을 key-value형식으로 put
		romanInt.put("M", 1000);
		romanInt.put("D", 500);
		romanInt.put("C", 100);
		romanInt.put("L", 50);
		romanInt.put("X", 10);
		romanInt.put("V", 5);
		romanInt.put("I", 1);
		
		// 합을 return할 변수 선언
		int sum = 0;
		
		// 루프에서 사용될 int변수 선언
		int i = 0;
		// 입력값의 글자 숫자만큼 반복
		while(i <s.length()) {
			
			// 입력값의 맨 i번째 문자를 currentSymbol에 담음
			String currentSymbol = s.substring(i, i+1);
			
			// 입력값의 i번째 문자(currentSymbol)에 해당하는 아라비아 숫자를 currentInt에 담는다
			int currentInt = romanInt.get(currentSymbol);
			
			// 다음 숫자를 담을 int변수 선언
			int nextInt = 0;
			// 입력값의 i번째 문자가 맨 마지막 글자까지 가지 않았다면
			if(i < s.length() - 1) {
				// i+1번째 문자를 nextSymbol에 담는다
				String nextSymbol = s.substring(i+1, i+2);
				
				// nextSymbol에 해당하는 아라비아 숫자를 nextInt에 담는다
				nextInt = romanInt.get(nextSymbol);
			}
			
			// 현재값이 다음 값보다 작을 경우
			if(currentInt < nextInt) {
				// nextInt - currentInt가 된다
				sum += (nextInt - currentInt);
				
				// 입력값의 두 문자에 대해 실행했기에, 두 칸을 건너뜀
				i += 2;
			} else {
				// 현재값이 다음 값보다 클 경우 현재값을 더함
				sum += currentInt;
				// 한글자에 대해서만 처리했기에 1을 더함
				i++;
			}
		}
		return sum;
	}
	
	
//	방법2. 현재 숫자보다 다음 숫자가 더 클 경우, 다음 숫자에서 현재 숫자를 뺀다는 규칙을 적용
	static int RomanToInt2(String s) {
		// 로마자와 아라비아 숫자를 키-밸류 쌍으로 다루기 위해 해쉬맵을 선언
		Map<String, Integer> romanInt = new HashMap<String, Integer>();
		
		// 로마 숫자와 아라비아 숫자 쌍을 key-value형식으로 put
		romanInt.put("M", 1000);
		romanInt.put("D", 500);
		romanInt.put("C", 100);
		romanInt.put("L", 50);
		romanInt.put("X", 10);
		romanInt.put("V", 5);
		romanInt.put("I", 1);
		// 현재숫자보다 다음숫자가 큰 경우의 값을 put
		romanInt.put("IV", 4);
		romanInt.put("IX", 9);
		romanInt.put("XL", 40);
		romanInt.put("XC", 90);
		romanInt.put("CD", 400);
		romanInt.put("CM", 900);
		
		// 합을 return할 변수 선언
		int sum = 0;
		
		// 루프에서 사용될 int변수 선언
		int i = 0;
		// 입력값의 글자 숫자만큼 반복
		while(i <s.length()) {
			
			// 입력값의 i번째 문자가 맨 마지막 글자까지 가지 않았다면
			if(i < s.length() - 1) {
				// 처음부터 입력값의 글자 2개를 가져옴
				String doubleSymbol = s.substring(i, i+2);
				
				// 해당 키 값이 존재하는 경우
				if(romanInt.containsKey(doubleSymbol)) {
					// 해당 값을 가져와서 더해줌
					sum += romanInt.get(doubleSymbol);
					// 입력값의 두 문자에 대해 실행했기에, 두 칸을 건너뜀
					i += 2;
					continue;
				}
			}
			
			// 2글자가 map에 없다면, 한글자만 불러와서 처리
			String singleSymbol = s.substring(i, i+1);
			// 불러온 한글자를 sum에 더해줌
			sum += romanInt.get(singleSymbol);
			// 한글자만 실행했기에, 한칸만 건너뜀
			i++;
		}
		
		// 결과값을 리턴
		return sum;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = args[0];
		
		// 로마숫자를 아라비아 숫자로 바꾸는 로직 실행
//		방법1. 기본 규칙만을 적용하여 로마자를 아라비아숫자로 변환
		System.out.println(RomanToInt(s));
		
//		방법2. 현재 숫자보다 다음 숫자가 더 클 경우, 다음 숫자에서 현재 숫자를 뺀다는 규칙을 적용
		System.out.println(RomanToInt2(s));
	}
}
