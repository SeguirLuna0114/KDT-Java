package stack_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	정수를 저장하는 스택을 구현한 다음,
	출력해야 하는 명령이 주어질때마다, 한줄에 하나씩 출력하는 프로그램
	
	첫째줄에 주어지는 명령의 수N(1 <= N <= 10,000)
	둘째줄부터 N개의 줄에는 명령이 하나씩 주어짐. 주어지는 정수는 1보다 크거나 같고 100,000보다 작거나 같음
	
	- push X: 정수 X를 스택에 넣음
	- pop: 스택에서 가장 위에있는 정수를 빼고, 그 수를 출력. 만일 스택에 들어있는 정수가 없으면 -1 출력
	- size: 스택에 들어있는 정수의 개수 출력
	- empty: 스택이 비어있다면 1, 아니면 0을 출력
	- top: 스택 가장 위에있는 정수 출력. 만일 스택에 들어있는 정수가 없다면 -1 출력
 */
public class Stack_formation {
	
	// 필드
	static int size = 0;
	// 각 명령에 대한 값을 입력할 배열 선언
	static int[] StackArr;
	
	// stack의 메소드를 구현
	// push X: 정수 X를 스택에 넣음
	static void push(int num) {
		StackArr[size] = num;
		size++;
	}
	
	// pop: 스택에서 가장 위에있는 정수를 빼고, 그 수를 출력. 만일 스택에 들어있는 정수가 없으면 -1 출력
	static int pop() {
		if(size == 0) {
			return -1;
		} else {
			// 스택에서 가장 위에 있는 정수 출력
			int popN = StackArr[size-1];
			// 해당 위치의 값을 0으로 대체
			StackArr[size-1] = 0;
			// 가장 위에있는 정수의 위치를 1 감소시킴
			size--;
			return popN;
		}
	}
	
	// size: 스택에 들어있는 정수의 개수 출력
	static int size() {
		return size;
	}
	
	// empty: 스택이 비어있다면 1, 아니면 0을 출력
	static int empty() {
		if (size == 0) {
			// 가장 위에있는 정수 위치가 0이면, 비어있다는 뜻이기에 1 출력
			return 1;
		} else {
			// 비어있지 않은경우 0 출력
			return 0;
		}
	}
	
	// top: 스택 가장 위에있는 정수 출력. 만일 스택에 들어있는 정수가 없다면 -1 출력
	static int top() {
		if(size == 0) {
			return -1;
		} else {
			return StackArr[size-1];
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("입력할 명령의 수N(1 <= N <= 10,000)과 "
				+ "둘째줄부터 N개의 줄에 명령과 정수를 입력하세요");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력할 명령의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 각 명령에 대한 값을 입력할 배열 생성
		StackArr = new int[N];
		
		// 파싱할 st객체변수 선언
		StringTokenizer st;

		// 입력한 명령의 수만큼 반복문 실행
		while (N-- >0) {
			
			// 입력받은 한 줄을 공백을 기준으로 파싱
			st = new StringTokenizer(br.readLine()," ");
			
			switch (st.nextToken()) {
			
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
					
				case "pop":
					sb.append(pop()).append('\n');
					break;
				
				case "size":
					sb.append(size()).append('\n');
					break;
					
				case "empty":
					sb.append(empty()).append('\n');
					break;
					
				case "top":
					sb.append(top()).append('\n');
					break;
			}
		}
		System.out.println(sb);
	}

}
