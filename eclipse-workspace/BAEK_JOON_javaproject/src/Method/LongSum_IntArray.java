package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정수 n개가 주어졌을 때, n개의 합을 구하는 함수 작성
// C, C11, C(Clang), C11(clang): long long sum(int *a, int a);
// 	- a: 합을 구해야하는 정수 n개가 저장된 배열(a<= a[i] <= 1,000,000, n<=3,000,000)
// 	- n: 합을 구해야하는 정수 n개의 합
// long sum(int[] a); (클래스이름 Test)
// 	- 리턴값: a에 포함되어 있는 정수 n개의 합
class Test {
	// 함수로 넘어오는 인자 a: 합을 구해야 하는 정수배열
	// => a배열에 저장되어 있는 정수들을 더하여 long형으로 리턴
	static long sum(int[] a) {
		// a배열 정수 합 변수
		long sum = 0;
		
		for (int i=0; i<a.length; i++) {
			sum += a[i];	// sum = sum + a[i];
		}
		
		return sum;
	}
}

// 만일 메인메소드를 구현한다면...
public class LongSum_IntArray {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.out.println("정수 n을 입력하세요(1<=n<=3,000,000)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력값 N개의 크기만큼 int형 배열 선언
		int[] Narr = new int[N];
		for (int i=0; i<N; i++) {
			Narr[i] = (int)(Math.random()*N) +1;
		}
		
		for (int i=0; i<Narr.length; i++) {
			if(i%10==0) {
				System.out.println();
			}
			System.out.print(Narr[i]+"\t");
		}
		System.out.println();
		
		// Test클래스의 sum()메소드 호출하여 n개의 합을 구함
		System.out.println("sum= "+Test.sum(Narr));

	}

}
