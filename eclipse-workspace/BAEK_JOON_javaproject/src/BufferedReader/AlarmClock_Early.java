package BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 45분 일찍 알람 맞추는 프로그램
// 알고리즘 - 입력받은 분(M)을 기준으로 45분보다 작으면 시간(H)-1을, 45분보다 크면 분(M)-45를 해줌
// 만일 시(H)가 0보다 작아질 경우, 23으로 수정
class AlarmEarlier {
	
	static void Earlier45min(int H, int M) {
		// 정수 H와 M이 범위 내에서 입력되었는지 확인(0<= H <=23, 0<= M <= 59)
		if ((H >= 0 && H <=23) && (M >=0 && M <=59)) {
			// pass
		} else {
			System.out.println("정확한 숫자를 입력해주세요");
			return;
		}
		
		// 입력받은 분(M)을 기준으로 45분보다 작으면 시간(H)-1
		if (M < 45) {
			H--;
			if (H < 0) {
				H = 23;
			}
			M = (M+60)-45;
		} else {
			M = M-45;
		}
		
		System.out.println(H+" "+M);
	}
	
	static void Earlier45min_Append(int H, int M) {
		// StringBuilder 클래스 사용
		StringBuilder sb = new StringBuilder();
		
		// 정수 H와 M이 범위 내에서 입력되었는지 확인(0<= H <=23, 0<= M <= 59)
		if ((H >= 0 && H <=23) && (M >=0 && M <=59)) {
			// pass
		} else {
			System.out.println("정확한 숫자를 입력해주세요");
			return;
		}
		
		// 입력받은 분(M)을 기준으로 45분보다 작으면 시간(H)-1
		if (M < 45) {
			H--;
			if (H < 0) {
				H = 23;
			}
			sb.append(H).append(' ');
			M = (M+60)-45;
			sb.append(M);
		} else {
			M = M-45;
			sb.append(H).append(' ').append(M);
		}
		System.out.println(sb);
	}
}


// 첫째줄에 정수 H와 M이 주어진다.(0<= H <=23, 0<= M <= 59)
public class AlarmClock_Early {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 정수 H와 M이 주어진다.(0<= H <=23, 0<= M <= 59)
		System.out.println("정수 H와 M을 입력하세요.(0<= H <=23, 0<= M <= 59)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// StringTokenizer클래스를 사용하여 공백을 구분자로 사용
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 반환되는 토큰을 변수에 할당
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// Earlier45min 메소드 호출
		AlarmEarlier.Earlier45min(H, M);
		
		// StringBuilder클래스를 사용하여 코드를 향상시킨
		// Earlier45min_Append 메소드 호출
		AlarmEarlier.Earlier45min_Append(H, M);

	}

}
