package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램
	첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
	둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
	주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다
	
	# Queue를 이용하지 않고, 직접 구현하는 방식

	push X: 정수 X를 큐에 넣는 연산이다.
	pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 큐에 들어있는 정수의 개수를 출력한다.
	empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
public class Queue_cmd_intArray_front0 {
	
	// 명령의 수N (1 ≤ N ≤ 10,000)이 주어진다 => 배열의 크기 2*N
	static int[] queue = new int[20000];
	
	static int size = 0;
	static int front = 0;
	static int back = 0;
	
	static StringBuilder sb = new StringBuilder();
	
	
	static void push(int n) {
		queue[back] = n;
		back++;
		size++;
	}
	
	static void pop() {
		if(size == 0) {
			sb.append(-1).append('\n');
		} else {
			sb.append(queue[front]).append('\n');
			size--;
			// front는 첫번째 인덱스를 가리키므로, 그 위치를 1 증가
			front++;
		}
	}
	
	static void size() {
		sb.append(size).append('\n');
	}
	
	static void empty() {
		if(size == 0) {
			sb.append(1).append('\n');
		} else {
			sb.append(0).append('\n');
		}
	}
	
	static void front() {
		if(size == 0) {
			sb.append(-1).append('\n');
		} else {
			sb.append(queue[front]).append('\n');
		}
	}
	
	static void back() {
		if(size == 0) {
			sb.append(-1).append('\n');
		} else {
			/* 	마지막 인덱스에 해당하는 back의 경우,
			 	요소를 추가한 후, 다음 위치로 back을 설정해두기에, back은 항상 0을 가리킴
			 	=> 맨뒤의 요소를 반환하고싶으면 back-1인덱스를 해줘야 함 */
			sb.append(queue[back-1]).append('\n');
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("첫째줄에 명령의 수와, 둘째줄부터 명령과 정수를 입력해주세요.");
		
		// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)
		int N = Integer.parseInt(br.readLine());
		StringTokenizer command;
		
		// 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
		// 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다
		while(N-- >0) {
			command = new StringTokenizer(br.readLine(), " ");
					
			switch(command.nextToken()) {
				// push X: 정수 X를 큐에 넣는 연산
				case "push" : {
					push(Integer.parseInt(command.nextToken()));
					break;
				}
				
				// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
				case "pop" : {
					pop();
					break;
				}
				
				case "size": {
					size();
					break;
				}
				case "empty": {
					empty();
					break;
				}
				
				// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
				case "front": {
					front();
					break;
				}
				
				// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
				case "back": {
					back();
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
