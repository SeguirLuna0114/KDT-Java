package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
	정수를 저장하는 덱(Deque)을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램
	첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
	둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
	주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다
	
	# int[]배열을 활용한 방식
	- 단, front메소드 구현시 주의 => 아무 원소가 없는상태에서 원소 들어가면 front가 감소하거나 back증가
	- 원소가 한개일 경우에는 해당 원소는 front이자 back. 하지만, 실제 front가 가리키는 위치는 비게됨
		=> push_front 가 실행 될 경우 front을 먼저 감소시키는 것이 아닌 
		   일단 front 위치에 원소를 넣은 뒤 front을 1 감소(어느 상황에서든 front 원소는 front + 1 에 위치)
	
	# Deque(Double-ended Queue): 양방향으로 삽입 삭제가 가능
	push_front X: 정수 X를 덱의 앞에 넣는다.
	push_back X: 정수 X를 덱의 뒤에 넣는다.
	pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 덱에 들어있는 정수의 개수를 출력한다.
	empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class Deque_cmd_intArray_front10000 {
	
	/*
	 * Deque 배열에서 front가 최종적으로 가리키는 위치는 항상 비워둔다.(가장 앞에있는 원소는 front + 1)
	 * => 만약 front의 최종 위치에 원소를 넣게 되면 예외가 발생한다.
	 * 
	 * 예로들어  push_front(3) 을 실행하려 하는데 아무 원소도 없을 때  
	 * front--; 감소시킨 뒤 deque[front] = 3; 이 되면
	 * deque[9999] = 3;(맨 뒤 인덱스에 추가)이 된다. 이때 front = 9999; back = 10000 이 된다.
	 * 
	 * 하지만, 원소가 한 개만 있을 경우 해당 원소는 front 이자 back 원소가 된다.
	 * 이러한 경우를 방지하기 위해
	 * deque[front] 에 원소를 넣은 뒤, front--; 을 해준다.
	 * 
	 * 결과적으로 front 요소 자체는 deque[front + 1] 위치에 자리한다.
	 */
	// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)
	// front와 back의 초기값을 10000으로 설정( 음수 인덱스를 사용하지 않고 덱을 구현하기 위한 것)
	static int front = 10000;
	static int back = 10000;
	static int size = 0;
	
	// 명령을 실행한 후, 각 값들을 int[]배열을 이용하여 계산할 것
	static int[] deque = new int[20001];	// 덱의 크기를 두 배로 설정
	
	// push_front X: 정수 X를 덱의 앞에 넣는다.
	static void push_front(int value) {
		// 원소를 먼저 넣은 뒤 front를 감소시킴
		deque[front] = value;
		front--;
		size++;
	}
	
	// push_back X: 정수 X를 덱의 뒤에 넣는다.
	static void push_back(int value) {
		back++;
		deque[back] = value;
		size++;
	}
	
	// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력(없는경우 -1)
	static int pop_front() {
		if(size == 0) {
			return -1;
		}
		/*
		 * front+1이 front 원소이기에, 해당 원소를 임시변수에 둔 후 front+1
		 */
		int popFront = deque[front+1];
		front++;
		size--;
		return popFront;
	}
	
	// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력(없는경우 -1)
	static int pop_back() {
		if(size ==0) {
			return -1;
		}
		int popBack = deque[back];
		back--;
		size--;
		return popBack;
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if(size == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	// front: 덱의 가장 앞에 있는 정수를 출력
	// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	static int front() {
		if (size == 0) {
			return -1;
		}
		return deque[front+1];
	}
	
	// back: 덱의 가장 뒤에 있는 정수를 출력
	// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	static int back() {
		if (size==0) {
			return -1;
		}
		return deque[back];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어지고"
				+ "둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.(1<=주어지는 정수<=100,000)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 첫째 줄에 주어지는 명령의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 둘째 줄부터 주어지는 명령과 정수
		while (N-- >0) {	// for(int i = 0; i < N; i++) {
			// String.split()메소드 사용하여 문자열 파싱 => 반환값은 배열로 받음
			String[] command = br.readLine().split(" ");	// =>0인덱스 명령, 1인덱스 정수
			
			// 입력받은 명령에 대한 실행
			switch (command[0]) {
				case "push_front" : {
					// push_front X: 정수 X를 덱의 앞에 넣는다.
					push_front(Integer.parseInt(command[1]));
					break;
				}
				case "push_back" : {
					// push_back X: 정수 X를 덱의 뒤에 넣는다.
					push_back(Integer.parseInt(command[1]));
					break;
				}
				
				case "pop_front" : {
					// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
					// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					sb.append(pop_front()).append('\n');
					break;
				}
				case "pop_back" : {
					// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 
					// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					sb.append(pop_back()).append('\n');
					break;
				}
				
				case "size" : {
					// size: 덱에 들어있는 정수의 개수를 출력한다.
					sb.append(size()).append('\n');
					break;
				}
				
				case "empty" : {
					// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
					sb.append(empty()).append('\n');
					break;
				}
				
//				- 원소를 삭제하지 않고 얻기만 하려는 경우 문제에서는 front(peekFirst), back(peekLast)
				case "front" : {
					// front: 덱의 가장 앞에 있는 정수를 출력한다. 
					// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					sb.append(front()).append('\n');
					break;
				}
				case "back" : {
					// back: 덱의 가장 뒤에 있는 정수를 출력한다. 
					// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					sb.append(back()).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
