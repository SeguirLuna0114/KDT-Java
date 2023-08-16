package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	정수를 저장하는 덱(Deque)을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램
	첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
	둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
	주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다

	# int[]배열을 활용한 방식2- 원형배열처럼 다루기에, index조정시에는 나머지연산 필요
	- 단, front메소드 구현시 주의 => 아무 원소가 없는상태에서 원소 들어가면 front가 감소하거나 back증가
	- 원소가 한개일 경우에는 해당 원소는 front이자 back. 하지만, 실제 front가 가리키는 위치는 비게됨
	=> push_front 가 실행 될 경우 front을 먼저 감소시키는 것이 아닌 
	   일단 front 위치에 원소를 넣은 뒤 front을 1 감소(어느 상황에서든 front 원소는 front + 1 에 위치)
	- 배열 인덱스를 음수가 되지않고, 원형으로 순환(circular rotation)시키기 위한 연산
		(인덱스가 원형으로 순환하는 자료구조에서 사용)
		 front = (front - 1) % array.length;(크기가 10000인 경우)
		* deque[9999](크기10000)까지 꽉 찬 경우에는 0으로 가리키기 위해, 배열의 크기만큼 나누어 나머지를 이용

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
public class Deque_cmd_intArray_front0 {

	
	/*
	 * Deque 배열에서 front' 가 가리키는 인덱스는 비어있어야 한다.(항상 비워둠)
	 *  => 가장 앞에있는 원소는 front + 1이 된다.
	 * 
	 * 만약 front의 최종 위치에 원소를 넣게 되면 front가 감소하거나 back이 증가함
	 * ex)  push_front(3) 을 실행하려 하는데 아무 원소도 없을 때  
	 * 		front--; 감소시킨 뒤 deque[front] = 3; 이 되면
	 * 		deque[9999] = 3; 이 된다. 이때 front = 9999; back = 10000 이 된다.
	 * 
	 * 하지만, 원소가 한 개만 있을 경우 해당 원소는 front 이자 back 원소이지만, 
	 * 실제로는 front가 가리키는 위치에는 비어있게 된다.
	 * 이러한 경우를 방지하기 위해 만약 push_front 가 실행 될 경우, front을 먼저 감소시키는 것이 아닌 
	 * 일단 front 위치에 원소를 넣은 뒤(deque[front]) front을 1 감소(front--;)
	 * 
	 * 결과적으로 어느상황에서든 front 요소 자체는 deque[front + 1] 위치에 자리한다.
	 * 
	 * 간단히 말해, front가 오른똑방향으로 움직이는 경우, 다음위치로 갱신
	 * front = (front + 1) % array.length;	// front을 front의 다음 위치로 갱신
	 * 
	 * front가 왼쪽방향으로 움직이는 경우, 
	 * front = (front - 1 + array.length) % array.length;	// front을 front의 다음 위치로 갱신
	 */
	
	// front와 back의 초기값을 0으로 설정
	static int front = 0;
	static int back = 0;
	static int size = 0;
	
	// 정수배열 활용하여 구현 - 명령의 수 N (1 ≤ N ≤ 10,000)
	static int[] deque = new int [10000];
	
	// push_front X: 정수 X를 덱의 앞에 넣는다.
	static void push_front(int value) {
		// 원소를 먼저 넣은 뒤, front를 감소시킴
		
		// front위치는 빈 공간이기 때문에 추가 해준 뒤 front 값을 갱신한다.
		deque[front] = value;
		// front를 감소시킬 때, front가 음수가 되지 않도록 배열의 크기(10000)만큼 더해줌
		front = (front-1 +10000) % 10000;
		// 배열 인덱스를 음수가 되지않고, 원형으로 순환(circular rotation)시키기 위한 연산(인덱스가 원형으로 순환하는 자료구조에서 사용)
		size++;
	}
	
	// push_back X: 정수 X를 덱의 뒤에 넣는다.
	static void push_back(int value) {
		// deque[9999](크기10000)까지 꽉 찬 경우에는 0으로 가리키기 위해, 배열의 크기만큼 나누어 나머지를 이용
		back = (back + 1) % 10000;	// 인덱스 원형순환
		size++;
		deque[back]=value;
	}
	
	// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력(없는경우 -1)
	static int pop_front() {
		if (size == 0) {
			return -1;
		}
		// front + 1이 front원소이기에, 해당 원소를 임시변수에 둔 후 front를 +1 증가 
		int popFront = deque[(front+1)%10000];
		front = (front+1)%10000;
		size--;
		return popFront;
	}
	
	// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력(없는경우 -1)
	static int pop_back() {
		if(size == 0) {
			return -1;
		}
		int popBack = deque[back];
		back = (back-1 + 10000) % 10000;
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
		if(size == 0) {
			return -1;
		}
		return deque[(front+1)%10000];
	}
	
	// back: 덱의 가장 뒤에 있는 정수를 출력
	// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	static int back() {
		if(size == 0) {
			return -1;
		}
		return deque[back];
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			// String.split()메소드 활용하여 파싱
			String[] command = br.readLine().split(" ");
			
			// 각 명령에 대한 해당 메소드 실행
			switch (command[0]) {
				case "push_front" : {
					push_front(Integer.parseInt(command[1]));
					break;
				}
				case "push_back" : {
					push_back(Integer.parseInt(command[1]));
					break;
				}
				
				case "pop_front" : {
					sb.append(pop_front()).append('\n');
					break;
				}
				case "pop_back" : {
					sb.append(pop_back()).append('\n');
					break;
				}
				
				case "size" : {
					sb.append(size()).append('\n');
					break;
				}
				
				case "empty" : {
					sb.append(empty()).append('\n');
					break;
				}

				case "front" : {
					sb.append(front()).append('\n');
					break;		
				}
				case "back" : {
					sb.append(back()).append('\n');
					break;		
				}
			}
		}
		System.out.println(sb);
	}
}
