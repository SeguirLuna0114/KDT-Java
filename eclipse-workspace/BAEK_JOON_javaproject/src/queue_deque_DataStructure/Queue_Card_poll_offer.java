package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
	N장의 카드(1~N)가 주어졌을때, 1번 카드가 제일 위, N번카드가 제일 아래에 놓임
	제일 위의 카드를 바닥에 버리고, 그다음 위 카드를 제일 아래 카드 밑으로 옮김
	위 동작을 카드가 하나 남을때까지 반복할경우, 제일 마지막에 남게되는 카드는?
	
	# Queue(큐)
	: '선입선출(FIFO)' 자료구조. 말 그대로 먼저 들어간 요소가 먼저 나오는 방식
	
	알고리즘
	맨 앞의 수를 삭제(poll) -> 그 다음 맨 앞의수를 삭제(poll)한 후, 그 수를 맨 뒤에 삽입(offerLast)
	위 과정을 수가 1개 남을때까지 무한반복
	
 */
public class Queue_Card_poll_offer {
	
	// Queue를 활용하는 방법
	static void Use_Queue(int N) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		// LinkedList<Integer> q = new LinkedList<>(); 로 선언해주어도 무방
		
		// 입력받은 N만큼 1~N까지 숫자를 queue에 추가(offer)
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		// queue의 원소가 1개가 남을때까지(= 1개 남기 전까지 과정 반복)
		while (queue.size() > 1) {
			// 1. 맨 앞의 원소를 버림
			queue.poll();
			// 2. 그 다음 앞의 원소를 버리고, 그 원소를 맨 뒤로 추가
			queue.offer(queue.poll());
		}
		
		// 마지막으로 남은 queue의 원소를 출력
		System.out.println(queue.poll());
	}
	
	
	// 배열로 풀이하는 방법
	static void Use_ArrayLikeQueue(int N) {
		/*
		 *  한 턴에 1개 씩 삭제되고 뒤에 1개가 추가 되므로
		 *  2 * N - 1 의 공간이 필요하다.
		 *  다만 index는 1부터 시작할 것이기 때문에
		 *  2 * N 공간으로 생성한다.   
		 */
		int[] queueArr = new int[2*N];
		
		// 입력받은 N만큼 1~N까지 숫자를 queueArr 배열에 추가
		for (int i=1; i<=N; i++) {
			queueArr[i] = i;
		}
		
		// 원소는 인덱스 1부터 N까지 채웠기에 (index 0은 쓰지 않음)
		int front = 1;	// 첫번째요소 인덱스
		int back = N;	// 마지막 요소 인덱스
		
		// queue의 원소가 1개가 남을때까지(= 1개 남기 전까지 과정 반복)
		while (N-- > 1) {
			// 삭제할 필요 없이 첫 번째 원소를 가리키는 인덱스를 다음 원소로 변경
			front++;
			
			// 마지막 원소 다음공간에 현재 첫 번째 원소 데이터를 삽입
			queueArr[back+1] = queueArr[front];
			
			// 각각 변수가 가리키는 인덱스를 1 씩 증가 
			back++;
			front++;
		}
		
		// 마지막으로 남은 원소 출력 = 첫번째 인덱스가 가리키는 원소
		System.out.println(queueArr[front]);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("자연수N을 입력하세요.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 정수 N => N장의 카드
		int N = Integer.parseInt(br.readLine());

		// 1. Queue를 활용하는 방법
		Use_Queue(N);

		System.out.println();
		
		// 2. 배열을 활용하는 방법
		Use_ArrayLikeQueue(N);
		
	}

}
