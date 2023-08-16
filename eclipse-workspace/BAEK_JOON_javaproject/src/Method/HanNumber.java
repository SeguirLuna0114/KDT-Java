package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 한수의 개수 출력하는 프로그램
// 한수 : 어떤 양의 정수X의 각 자리가 등차수열을 이루는 수
// N이 주어졌을 때, 1보다 크거나 같고 N보다 작거나 같은 한수의 개수 출력

//알고리즘 - 입력받은 양의 정수 X가 각 자리가 등차수열을 이루어야
// X의 각 자리의 수를 CharAt()메소드로 한 자리씩 가져옴
// 가져온 수의 차가 같으면 한수
class HanN {
	
	// string.charAt(index) 메소드: 특정 인덱스에 해당하는 문자를 가져옴
	static int[] charAtNarr(int N) {
		
		// 입력받은 숫자 N -> 문자 "N" 
		String StrN = String.valueOf(N); 
		int[] Narr = new int[3];	// 입력받은 수는 1000보다 작기에
		
		for (int i=0; i<StrN.length(); i++) {
			// String.valueOf()메소드를 사용: char -> string
			String CharToStr = String.valueOf(StrN.charAt(i));
			Narr[i] = Integer.parseInt(CharToStr);
		}
		return Narr;
	}
	
	// 등차수열 : an = a1 + (n-1)d
	static int Arithmetic_Progression(int N) {
		// 한수 카운팅
		int cnt = 0;
		
		// 입력받은 숫자가 100보다 작은경우에는 return
		if (N < 100) {
			// 1~99경우, 그 수 자체가 수열
			// ex) 31: 공차가 -2인 수열, 38: 공차가 +5인 수열
			return N;
		} else {
			// 100 이상의 수가 들어오면 한수의 최소 개수는 99개
			cnt = 99;
			// 100 이상의 수들이 각 자릿수가 등차수열인지 확인
			for (int i=100; i<=N; i++) {
//				int[] charAtNarr = charAtNarr(i);
				// 100 ~ 입력받은 수까지 반복하며 한수의 개수 cnt
				// charAtNArr()메소드 사용하여 각 자리의 수를 구함
				int hund = charAtNarr(i)[0];	// 백의자리수: i/100
				int ten = charAtNarr(i)[1];		// 십의자리수: (i/10)%10
				int one = charAtNarr(i)[2];		// 일의자리수: i%10
				
				// 각 자리수가 수열을 이루면
				if((hund - ten) == (ten - one)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}

public class HanNumber {

	// 1000보다 작거나 같은 자연수 N이 주어짐
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		System.out.println("1,000보다 작거나 같은 자연수N을 입력하세요.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 한수의 개수 출력하는 프로그램
		System.out.println(HanN.Arithmetic_Progression(N));
	}

}
