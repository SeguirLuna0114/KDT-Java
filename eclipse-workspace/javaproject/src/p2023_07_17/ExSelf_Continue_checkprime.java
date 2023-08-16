package p2023_07_17;

import java.util.Scanner;

public class ExSelf_Continue_checkprime {

	// 소수 판별 - 소수는 1과 자기자신으로만 나누어떨어짐
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Check Prime~!!");
		System.out.println("Insert number: ");
		Scanner sc = new Scanner(System.in);
		int checkprime = sc.nextInt();	// 입력받은 숫자를 저장
		System.out.println("Inserted Number: "+checkprime);
		
		boolean isPrime = true;
		
		// for문 활용 소수판별법 - 2~입력받은수/2까지의 숫자를 반복
		int i;
		for (i=2; i<checkprime; i++) {
			// i로 나눈 나머지가 0인 경우, 소수가 아님
			if (checkprime%i==0) {	// i로 나누어 나머지가 0인지 확인
				isPrime = false;
				break;	//나머지가 0이면, 그 아래 코드 실행X->반복문으로 돌아감
			} // 나머지가 0이 아닌 경우, 현재의 i값 출력
		}
		
		//isPrime이 True면 소수
		if (isPrime && checkprime>1) {	//소수는 1보다는 커야 함
			System.out.println(checkprime+" is a prime number");
		} else {
			System.out.println(checkprime+" is not a prime number");
		}
		
		// 제곱근을 이용한 소수판별
		// Math.sqrt(num): 루트 num까지 나눠 떨어지는지 검사
//		int sqrt = (int)Math.sqrt(checkprime);
//		for (i=2; i<=sqrt; i++) {
//			if (checkprime%i ==0) {
//				isPrime = false;
//				break;
//			}
//		}
		
		// sqrt 내장함수 사용X 소수판별
		if (checkprime < 2) {
			isPrime = false;
		}
		
		if (checkprime == 2) {
			isPrime = true;
		}
		
		if (checkprime%2==0) {
			isPrime = false;
		}
		
		for (i=3; i*i<=checkprime; i+=2) {
			if (checkprime%i ==0) {
				isPrime = false;
				break;
			}
		}
		isPrime = true;
		
		//isPrime이 True면 소수
		if (isPrime && checkprime>1) {	//소수는 1보다는 커야 함
			System.out.println(checkprime+" is a prime number");
		} else {
			System.out.println(checkprime+" is not a prime number");
		}
		

		
	}

}
