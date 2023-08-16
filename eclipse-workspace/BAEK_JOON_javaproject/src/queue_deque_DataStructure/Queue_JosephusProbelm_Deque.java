package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	요세푸스 문제
	N과 k가(1<=K<=N<=1000) 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램
	
	# Queue를 활용하여 문제 풀이(원형 배열)
	"1부터 N까지 나열 된 수에서 K번째 수 마다 차례대로 뽑아 낸 수열을 출력"
	- K번 쨰 수가 되기 직전까지 맨 앞의 원소를 K-1 번 꺼내오고(poll)
		-> 꺼내온 원소들을 맨 뒤로 넣는다.(offer) -> K번째로 뽑힌(poll) 원소는 출력
	=> K-1번만큼 poll과 offer을 한 뒤, K번 째 값을 poll만하고 해당 원소를 출력
	
	1번부터 N번까지 N명의 사람들이 원을 이루며 앉아있고, 양의정수k(k<=N)이 주어짐.
	이제 순서대로 k번째 사람을 제거하고, 한 사람이 제거되면 남은 사람들로 이루어진 새로운 원으로 위 과정 반복
	N명의 사람이 모두 제거될 때까지 반복됨
	이때 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라 함
	ex)	(7,3)-요세푸스 순열: <3, 6, 2, 7, 5, 1, 4>
 */
public class Queue_JosephusProbelm_Deque {

	// 맨 앞의 원소를 뽑아낸 뒤(poll) 그 원소를 매개변수에 할당(targetVal)했다가 뒤에 추가(offer)하는 방법
	static void polltargetValOffer(StringBuilder sb, Deque<Integer> queue, int K) {
		/*
		 * 단, 큐를 사용할 경우, 
		 * 참조하려는 인덱스가 입력받은 수보다 작아질 경우가 생기는데, 
		 * 이럴 경우 참조 범위 밖으로 에러가 날 수 있음
		 * => 반드시 큐의 크기를 나눈 나머지값으로 증가시킴
		 */
		sb.append('<');
		while(queue.size() > 1) {
			// K-1번 앞에 있는 원소를 뒤로 보냄
			for (int i=0; i < K-1; i++) {
				// 맨 앞의 원소를 제거하며 뽑아냄
				int targetVal = queue.poll();
				// 큐의 맨 뒤에 추가
				queue.offer(targetVal);
			}
			sb.append(queue.poll()).append(", ");
		}
		// 마지막 원소를 출력한 뒤, >도 붙여줌
		sb.append(queue.poll()).append('>');
		System.out.println(sb);
	}
	
	// 맨 앞의 원소를 제거하며 뽑아낸 뒤 바로 offer메소드로 뒤에 추가하는 방법
	static void pollOffer(StringBuilder sb, Deque<Integer> queue, int K) {
		/*
		 *  마지막 부분의 출력은 > 괄호 전에 공백이 없기 때문에
		 *  일괄적으로 출력하기 위해 마지막 원소만 남겨질 때까지만
		 *  반복하고 마지막 원소는 그대로 출력한다.
		 */
		sb.append('<');
		
		// 마지막 원소 전까지
		while(queue.size() > 1) {
			// K-1번째 인덱스 앞에 있는 원소를 뒤로 보냄
			for (int i=0; i < K-1; i++) {
				// poll()로 제거하며 뽑아낸 맨 앞의 원소를
				// offer()로 큐의 맨 뒤에 추가
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		// 마지막 원소를 출력한 뒤, >도 붙여줌
		sb.append(queue.poll()).append('>');
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("(N, K)-요세푸스 순열을 구하기 위해 N과 k(1<=K<=N<=1000)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N과 k가(1<=K<=N<=1000) 입력됨
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> queue = new LinkedList<Integer>();
//		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		// 1~N까지 큐에 입력
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		// 방법1. 매개변수를 사용해서 poll -> targetVal -> offer하는 방법
		polltargetValOffer(sb, queue, K);
		
		System.out.println();
		
		// 방법2. poll하여 뽑아낸 원소를 offer로 바로 뒤에 추가하는 방법
		pollOffer(sb, queue, K);
	}
}
