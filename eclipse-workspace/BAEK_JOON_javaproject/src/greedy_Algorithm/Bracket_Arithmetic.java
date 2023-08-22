package greedy_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램
 * 
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 
 * 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 
 * - 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고,
 *   가장 처음과 마지막 문자는 숫자이다. 
 * 
 * - 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
 * - 수는 0으로 시작할 수 있다. 
 * - 입력으로 주어지는 식의 길이는 50보다 작거나 같다
 */
public class Bracket_Arithmetic {

	/** 식의 값을 최소로 만드는 알고리즘
	 * 최솟값을 만들기 위해서는 최대한 '큰 수'를 빼주어야 한다
	 * => 덧셈(+)으로 이루어진 부분을 먼저 계산한 뒤 빼주는 것
	 * 
	 * "덧셈 부분을 먼저 계산 하는 것"
	 * 1. 뺄셈(-)을 기준으로 1차적으로 문자열을 분리해준다.
	 * 2. 분리된 문자열들 각각에 포함 된 정수 값들을 모두 더 해준다.
	 * 3. 각각 더해진 값들을 뺄셈해준다.
	 * 
	 * - 단, 첫번째 수는 양수이기에 
	 * 	 만약 모조리 빼버리면 첫 번째 수도 음수가 되어 결과값이 -335가 되어버리는 잘못된 답이 나온다
	 */
	static String input;
	
	// 계산 결과를 저장하는 변수
	// - 초기 상태 여부 확인을 위한 값으로 설정
	static int sum = Integer.MAX_VALUE;
	static int sum2 = Integer.MAX_VALUE;
	
	// split()메소드를 사용해 문자열 분리
	static void UseSplit() {
		
		// 1. 뺄셈(-)을 기준으로 1차적으로 문자열을 분리
		// String.split()메소드를 사용해 입력받은 문자열을 파싱
		String[] subtraction = input.split("-");
		
		for(int i=0; i<subtraction.length; i++) {
			
			// 임시 변수 temp 생성
			int temp = 0;
			
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰을 더함
			String[] addition = subtraction[i].split("\\+");
			/**
			 *  split의 경우 정규식(regex)을 받기 때문에
			 *  + 문자가 메타문자(meta character =특별한 의미를 담고 있다는 뜻)라서
			 *  구분자를 "+"을 하면 regex.PatternSyntaxException 예외 처리됨
			 *  
			 *  따라서 온전하게 문자 그대로 사용하기 위해 이스케이프 처리 필요
			 *  하지만 \(백슬래시)도 단독으로 출력할 수 없기 때문에 백슬래시 자체도 이스케이프 해야함 => \\+
			 */
			
			// 덧셈으로 나뉜 토큰을 모두 더함
			for(int j=0; j<addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			// 첫번째 토큰인 경우 temp값이 첫번째수가 됨
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
	
	
	// StringTokenizer클래스를 사용하여 문자열 분리
	static void UseStringToken() {
		
		StringTokenizer subtraction = new StringTokenizer(input, "-");
		
		while(subtraction.hasMoreTokens()) {
			
			// 임시변수 temp 생성
			int temp = 0;
			
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰을 더함
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
			
			// 덧셈으로 나뉜 토큰을 모두 더함
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			// 첫번째 토큰인 경우 temp값이 첫번째 수가 됨
			if(sum2 == Integer.MAX_VALUE) {
				sum2 = temp;
			} else {
				sum2 -= temp;
			}
		}
		System.out.println(sum2);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("식을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		// split()메소드를 사용해 문자열 분리
		UseSplit();
		
		// StringTokenizer클래스를 사용하여 문자열 분리
		UseStringToken();
	}
}
