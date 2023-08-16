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
	
	# Deque(ArrayDeque)를 활용한 방식
	
	# Deque(Double-ended Queue): 양방향으로 삽입 삭제가 가능
	- push = offer, pop = poll
	push_front X: 정수 X를 덱의 앞에 넣는다.
	push_back X: 정수 X를 덱의 뒤에 넣는다.
	pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 덱에 들어있는 정수의 개수를 출력한다.
	empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	- 원소를 삭제하지 않고 얻기만 하려는 경우 문제에서는 front(peekFirst), back(peekLast)
	front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class Deque_cmd_ArrayDeque {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어지고"
				+ "둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.(1<=주어지는 정수<=100,000)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		// 첫째 줄에 주어지는 명령의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 둘째 줄부터 주어지는 명령과 정수
		while (N-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			// 입력받은 명령에 대한 실행
			switch (cmd) {
				case "push_front" : {
					// push_front X: 정수 X를 덱의 앞에 넣는다.
					int targetN = Integer.parseInt(st.nextToken());
					// 정수 X를 덱의 앞에 넣는다 => addFirst()메소드
					deque.addFirst(targetN);
					break;
				}
				case "push_back" : {
					// push_back X: 정수 X를 덱의 뒤에 넣는다.
					int targetN = Integer.parseInt(st.nextToken());
					deque.addLast(targetN);
					break;
				}
				
				case "pop_front" : {
					// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
					// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if (deque.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deque.pollFirst()).append('\n');
					}
					break;
				}
				case "pop_back" : {
					// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 
					// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if (deque.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deque.pollLast()).append('\n');
					}
					break;
				}
				
				case "size" : {
					// size: 덱에 들어있는 정수의 개수를 출력한다.
					sb.append(deque.size()).append('\n');
					break;
				}
				
				case "empty" : {
					// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
					if(deque.isEmpty()) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
					break;
				}
				
//				- 원소를 삭제하지 않고 얻기만 하려는 경우 문제에서는 front(peekFirst), back(peekLast)
				case "front" : {
					// front: 덱의 가장 앞에 있는 정수를 출력한다. 
					// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if(deque.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deque.peekFirst()).append('\n');
					}
					break;
				}
				case "back" : {
					// back: 덱의 가장 뒤에 있는 정수를 출력한다. 
					// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if(deque.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(deque.peekLast()).append('\n');
					}
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
