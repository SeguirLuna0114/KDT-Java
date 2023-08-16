package String;

// 공백없이 쓰여있는 숫자 N개를 모두 합해서 출력하는 프로그램
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// byte[] getBytes() 메소드 : 문자열(String)에 대해서 해당 문자열을 하나의 byte배열로 변환
// 이때 변환되는 방법은 Charset에서 사용되는 인코딩 방식(UTF-16)으로 변경되는 값
public class GetBytes_method {

	// Scanner로 입력받아 charAt()메소드를 활용하는 방법
	static void UseScannerCharAt() {
		Scanner sc = new Scanner(System.in);
		
		// 첫째줄에 입력할 숫자의 개수N
		int N = sc.nextInt();
		
		// 둘째줄에 입력되는 숫자를 문자로 한번에 입력받아와 charAt()메소드 활용하여
		// 바이트 단위의 하나의 숫자를 문자형태로 받아옴
		String StrN = sc.next();		// 위 경우 공백없이 한줄에 입력되기에 next()메소드 활용
//		String StrN = sc.nextLine();	// 개행문자 이전까지 입력 한줄을 통째로 받아옴 => 개행문자 포함한 문자를 반환
		sc.close();
		
		// 각 숫자를 더할 sum객체 생성
		int sum = 0;
		
		// 입력받은 횟수N만큼 반복
		// 이때, N이 아닌, StrN.length()메소드를 활용해도 됨(즉, 첫번째 입력값을 굳이 변수에 할당할 필요x)
		for (int i=0; i < N; i++) {
			sum += (StrN.charAt(i) - '0');
			// charAt()메소드로 가져온 '숫자'는 ASCII코드값을 반환하기에,
			// -'0'(또는 -48)을 통해 숫자값 그대로를 받아올 수 있음
		}
		// 각 숫자들의 합을 출력
		System.out.println(sum);
	}
	
	
	// BufferedReader로 입력받아 getBytes()메소드를 활용하는 방법
	static void UseBuffR_getBytes() throws IOException {
		// BufferedReader클래스 활용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 두번째줄에 입력되는 값을 계산하기에, 첫번째 입력되는 숫자의 개수는 필요X(length메소드 사용하면 됨)
		br.readLine();		// 처음 입력받은 N은 쓸모 없기에 입력만 받음
		
		// 각 숫자를 더할 sum객체 생성
		int sum = 0;
		
		for (byte value : br.readLine().getBytes()) {
			// readLine으로 읽어들인 문자를 byte[]배열로 반환하기에, 
			// for - each(확장 for문)을 활용하여 문자를 하나씩 읽어들임
			sum += (value - '0');
//			sum += (value - 48);
			// UTF-16 인코딩에 맞게 각 문자값을 저장하기에, 반드시 '0' 또는 48을 빼주어야 함
		}
		// 각 숫자들의 합을 출력
		System.out.println(sum);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째줄에는 입력할 숫자의 개수N(1<=N<=100)를, 두번째줄에는 계산할 숫자를 공백없이 입력해주세요");

		// 둘 중 하나만 사용!
		// Scanner & charAt()메소드 활용하는 방법
//		UseScannerCharAt();
		
		// BufferedReader & getBytes()메소드 활용하는 방법
		UseBuffR_getBytes();
	}
}
