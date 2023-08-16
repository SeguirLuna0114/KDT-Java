package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	요세푸스 문제
	N과 k가(1<=K<=N<=1000) 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램

	# LinkedList를 활용하여 문제 풀이(원형 배열)
	- 중간삭제가 많은 만큼, ArrayList보다는 LinkedList가 더 효율적
	- K값을 매 번 K씩 증가시키며 해당 원소를 삭제하면서 해당 값을 출력
	- 리스트의 시작 index는 0부터 시작하고, 
	  매 번 원소가 한 개씩 줄기 때문에 때문에 처음 시작 값 및 증가 값은 K값에 -1
	- 참조하려는 인덱스가 입력받은 수보다 작아질 경우를 대비하여 원형구조 인덱스값 이동으로 설정
	  : index = (index +(K-1)) % list.size()
		"현재 인덱스에서 (K-1)만큼 이동한 위치"(현재 리스트의 크기를 나눈 나머지값으로 증가)

	## LinkedList : 데이터 요소들이 노드라 불리는 객체로 연결된 자료구조
	- 각 노드가 이전 노드와 다음 노드를 가리키는 링크를 통해 연결됨
	- add(index, element): 지정한 인덱스에 요소를 추가 -> addFirst(element), addLast(element)
	- remove(index): 지정한 인덱스의 요소를 제거 -> removeFirst(), removeLast()
	- get(index): 지정한 인덱스에 위치한 요소를 반환
	- size(): 리스트에 포함된 요소의 개수를 반환
	- isEmpty(): 리스트가 비어 있는지 여부를 반환

	1번부터 N번까지 N명의 사람들이 원을 이루며 앉아있고, 양의정수k(k<=N)이 주어짐.
	이제 순서대로 k번째 사람을 제거하고, 한 사람이 제거되면 남은 사람들로 이루어진 새로운 원으로 위 과정 반복
	N명의 사람이 모두 제거될 때까지 반복됨
	이때 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라 함
	ex)	(7,3)-요세푸스 순열: <3, 6, 2, 7, 5, 1, 4>
*/
public class Queue_JosephusProblem_LinkedList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("(N, K)-요세푸스 순열을 구하기 위해 N과 k(1<=K<=N<=1000)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// N과 k가(1<=K<=N<=1000) 입력됨
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// LinkedList를 이용하여 문제풀이
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// 1~N까지 리스트에 입력
		for (int i=1; i <= N; i++) {
			list.add(i);
		}
		
		// 리스트에서 삭제할 요소를 참조할 인덱스 변수
		int index = 0;	// 리스트에는 1부터 N까지 인덱스가 채워짐 
		
		// 출력할 원소들 형식
		sb.append('<');
		
		/*
		 *  마지막 부분의 출력은 > 괄호 전에 공백이 없기 때문에
		 *  일괄적으로 출력하기 위해 마지막 원소만 남겨질 때까지만
		 *  반복하고 마지막 원소는 그대로 출력한다.
		 */
		
		// 마지막 원소 전까지
		while(list.size() > 1) {		// while(N-- > 1) {
			/*
			 * 원형 구조에서 인덱스의 이동
			 * List나 Array는 선형적인 구조를 갖기에, 인덱스를 넘어가는 경우, 원형적으로 이동시켜야 함
			 * 
			 * 초기 int index = 0;으로 할당(처음 인덱스값을 설정)
			 * index = (index +(K-1)) % list.size()
			 * : 현재 인덱스에서 (K-1)만큼 이동한 위치
			 * (K-1을 더한 후, 리스트의 크기로 나눈 나머지값 => 원형적인 인덱스 이동
			 * 
			 */
			// K값을 매 번 K씩 증가시키며 해당 원소를 삭제하면서 해당 값을 출력
			// -> 이때 index는 0부터 시작하며 매번 원소가 하나씩 줄기에, 
			// 처음 시작값 및 증가값은 K-1이어야 함
			index = (index +(K-1)) % list.size();
			
			// index위치에 있는 요소를 삭제함과 동시에 출력
			sb.append(list.remove(index)).append(", ");
		}
		
		// 마지막으로 남은 요소를 삭제함과 동시에 출력
		sb.append(list.remove()).append('>');
		System.out.println(sb);
	}

}
