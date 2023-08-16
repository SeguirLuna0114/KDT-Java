package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램

// 일반적으로 큰 수를 쓸 때 쓰는 long형은 2^64 -1으로 약 1844경
// 하지만 이번 문제의 경우 입력범위가 최대 10^10000이므로 long형을 넘음

// 덧셈 알고리즘
// 배열의 인덱스끼리 더해줌. 만일 더한 결과가 10이 넘는다면 10으로나눈 나머지값을 저장하고 올림
class AddClass {
	
	static void UseScanner() {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 수를 문자열로 받아 -> length()메소드로 길이 측정
		String Str_A = sc.next();	// 공백을 간격으로 A와 B입력
		String Str_B = sc.next();
		
		// 두 수중 가장 긴 자리수의 길이를 구하고, 이를 기준으로 배열 생성
		int max_length = Math.max(Str_A.length(), Str_B.length());
		
		// 마지막 자리수의 올림이 있을 수 있기에 max_length+1
		int[] A_arr = new int[max_length+1];
		int[] B_arr = new int[max_length+1];
		
		// A와 B값을 정수배열에 할당
		// 맨 뒤 문자부터 역순으로 하나씩 저장(자리올림을 처리하기 위함)
		for(int i=Str_A.length()-1, idx=0; i>=0; i--, idx++) {
			// i변수는 문자열의 마지막인덱스, 배열에 저장하기위한 idx는 0부터, 
			// i가 0보다 크거나 같을때까지 i는 1씩 감소시키고, idx는 증가시켜
			// i와 idx가 역순으로 증감하게 함 
			A_arr[idx] = Str_A.charAt(i) - '0';
			// charAt()메소드로 가져온 문자를 정수변환하기 위해 -'0'처럼 아스키코드 값을 뺌
		}
		for(int i=Str_B.length()-1, idx=0; i>=0; i--, idx++) {
			B_arr[idx] = Str_B.charAt(i) - '0';
		}
		
		// 덧셈
		for (int i=0; i < max_length; i++) {
			int addVal = A_arr[i]+B_arr[i];
			// 더한 값의 10으로 나눈 나머지가 자리값이 됨
			A_arr[i] = addVal % 10;
			// 더한 값의 10으로 나눈 몫이 올림값이 됨
			A_arr[i+1] += (addVal / 10);
		}
		
		// 덧셈의 결과값인 A배열을 역순 출력
		StringBuilder sb = new StringBuilder();
		// 가장 높은 자리수가 0일수도 있기에 0이 아닐경우에만 출력
		if(A_arr[max_length] != 0) {
			sb.append(A_arr[max_length]);
		}
		for (int i=max_length-1; i>=0; i--) {
			sb.append(A_arr[i]);
		}
		System.out.println(sb);
	}
	
	static void UseBidInteger() {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		
		A = A.add(B);
		
		System.out.println(A.toString());
	}
	
	// Scanner대신 BufferedReader를 사용
	static void UseBuffReadBigInteger() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		
		A = A.add(B);
		
		System.out.println(A.toString()); 
	}
	
}


public class BigInteger_Add {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("두 정수 A, B를 입력하세요.(1 < A,B <10^10000)");
		
		// 방법1. Scanner클래스로 구현한 UseScanner()메소드 사용
//		AddClass.UseScanner();
		
		// 방법2. Scanner클래스 + BigInteger클래스로 구현한 UseBidInteger()메소드 사용
//		AddClass.UseBidInteger();
		
		// 방법3. BufferedReader클래스 + BigInteger클래스로 구현한 UseBuffReadBigInteger()메소드
		AddClass.UseBuffReadBigInteger();
		
	}

}
