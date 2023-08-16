package stack_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	입력받은 k개의 줄에 주어진 정수를 0일 경우 가장 최근에 쓴 수를 지우고
	최종적으로 적어낸 수들의 합을 출력하는 프로그램
	
	첫번째 줄에 정수 K가 주어짐(1<= k <= 100,000)
	k줄에 입력한 정수는 0에서 1,000,000사이 값을 가짐
	최종적으로 적어낸 수의 합은 2^31-1보다 작거나 같은 정수
 */
public class ZeroInput_Erase_Sum {
	
	static void Use_Stack(BufferedReader br, int K) throws IOException {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// 입력받은 수가 0인지 아닌지 확인하며 stack에 추가
		for (int i=0; i<K; i++) {
			int checkNum = Integer.parseInt(br.readLine());
			
			// 입력된 수가 0인 경우 '가장 최근에 입력된 수'를 삭제
			if (checkNum == 0) {
				stack.pop();
			} else {
				// 0이 아닌경우는 stack에 원소 추가
				stack.push(checkNum);		// stack.add(checkNum);
			}
		}
		// 입력받은 수들의 합계를 구함
		int sum = 0;
		// 스택에 담긴 원소들의 합 구하는 반복문
		for (int element : stack) {
			sum+= element;
		}
		System.out.println(sum);
	}
	
	
	static void Use_ArrayLikeStack(BufferedReader br, int K) throws IOException {
		
		// 입력한 값을 저장할 배열
		int[] StackArr = new int[K];
		
		// 가장 최근에 입력한 원소의 위치를 가리키는 변수
		int top = -1;
		for (int i=0; i<K; i++) {
			// 정수 입력
			int checkNum = Integer.parseInt(br.readLine());
			
			// 입력받은 정수가 0인지 확인
			if(checkNum == 0) {
				// 가장 최근에 입력한 원소의 위치를 1감소
				top--;
			} else {
				// 0이 아닌경우 1증가 후 배열에 저장
				top++;	// 인덱스 0부터 시작해야 함
				StackArr[top] = checkNum;
			}
		}
		// 입력받은 수들의 합계를 구함
		int sum = 0;
		// 배열에 담긴 원소들의 합 구하는 반복문
		// 합을 구할 때, K가 아닌, 가장 최근 입력한 원소위치를 가리키는 top까지이다.
		for (int i=0; i <= top; i++) {
			sum+= StackArr[i];
		}
		System.out.println(sum);
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("입력할 정수의 개수k와 k개의 정수를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력개수 정수 K
		int K = Integer.parseInt(br.readLine());
		
		// 1. stack클래스를 이용해 입력한 정수들의 합을 구하는 메소드 호출
//		Use_Stack(br, K);
		
		// 2. stack클래스를 배열로 자체구현하여 입력 정수의 합을 구하는 메소드 호출
		Use_ArrayLikeStack(br,K);
	}

}
