package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 제품 고정비용, 가변비용, 판매가격이 주어졌을 때, 손익분기점을 계산하는 프로그램
// 손익분기점이 되는 판매량을 출력하는 프로그램

// 생산하는데 드는 총 비용 = 고정비용 + 가변비용 * 개수
// 생산대수를 늘려가게 되면, 어느순간 총수입(판매비용) > 총 비용(고정비+가변비용*개수)
// 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점이라 함
// 손익분기점이 존재하지 않으면 -1을 출력
public class BreakEvenPoint {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 첫째줄에 고정비용(A), 가변비용(B), 판매가격(C)이 주어진다.
		// A, B, C는 21억 이하의 자연수
		System.out.println("고정비용(A), 가변비용(B), 판매가격(C)을 입력하세요."
				+ "(단, A, B, C는 21억 이하의 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		// 고정비용(A)
		int A = Integer.parseInt(st.nextToken());
		// 가변비용(B)
		int B = Integer.parseInt(st.nextToken());
		// 판매가격(C)
		int C = Integer.parseInt(st.nextToken());
		
		// 출력해야 하는 값은 손익분기점이 되는 판매량n
		// 총수입(판매비용)(C * n)
		// 총 비용(고정비용 + 가변비용 *n)(A + B*n)
		// => n > A / (C - B)
		// 단, 손익분기점이 존재하지 않는다는것은 n<=0인 경우 => C - B <= 0 => C <= B
		// n과 A / (C - B)이 같으면 수익이 같아지는 것이지 이익이 나는것은 X => n > (A / (C - B))+1
		
		// 손익분기점이 존재하지 않는 경우
		if (C <= B) {
			System.out.println("-1");
		}
		else {
//			System.out.println((A / (C - B))+1);
			System.out.println((int)Math.ceil((A / (C - B)) + 1));
		}
		
		
	}

}
