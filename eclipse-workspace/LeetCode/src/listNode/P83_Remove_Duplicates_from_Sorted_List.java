package listNode;

/** 입력값으로 정렬된 linked list를 받아서 중복된 값을 제외하는 프로그램
 * -Given the head of a sorted linked list,
 *  delete all duplicates such that each element appears only once.
 * -Return the linked list sorted as well
 * ex) Input : head = [1, 1, 2] => output : [1, 2]
 * ex) Input : head = [1, 1, 2, 3, 3] => output : [1, 2, 3]
 */

// 연결 리스트의 노드를 나타내는 클래스
class ListNode {
	
	// 노드 값
	int val;
	// 다음 노드를 가리키는 포인터
	ListNode next;
	
	// 노드 생성을 위한 생성자
	ListNode() {}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class P83_Remove_Duplicates_from_Sorted_List {
	
	/* 정렬된 연결 리스트에서 중복된 노드를 제거하는 메소드 구현
	 * 주어진 연결 리스트 head를 받아서 중복된 값을 가진 노드를 제거하고,
	 * 중복된 값을 가진 노드 중 첫 번째 노드를 유지
	 */
	static ListNode deleteDuplicates(ListNode head) {
		
		// 현재 노드를 나타내는 포인터 => 초기에는 입력 연결리스트 시작인 head를 가리킴
		ListNode current = head;
		
		/** While문을 시작할 때는 current 값이 1, next 값이 1 
		 *  그리고 next.next값이 2
		 *  => 현재 값과 다음 값이 모두 1 이므로 if 문 안으로 들어가서
		 *     current.next 가 그 다음 값을 포인트 하게 됨
		 *     따라서, 첫번쨰 While문을 끝내면 첫번째 1은 2를 포인트
		 *  
		 *  두번째 루프에서는 각각 값이 1,2,3이 되고, 
		 *  현재 값 두번째 1은 2가 됨
		 *  
		 *  세번째 루프에서는 2,3,3 이 되고, 또한 현재 값 2는 3이 됨
		 *  
		 *  네번째 루프에서는 3,3,null 이 됨
		 */
		while(current != null && current.next != null) {
			
			/* current와 그 다음 노드 current.next를 비교하여 
			 * 중복된 값을 찾고 중복된 값을 제거
			 */
			if(current.next.val == current.val) {
				/* 중복된 값이 있으므로 다음 노드 current.next를 건너뛰어 
				 * 다다음 노드 current.next.next를 가리키도록 변경
				 * => 중복된 값을 가진 노드는 제거됨
				 */
				current.next = current.next.next;
			}
			// 중복된 값이 없는 경우
			else {
				// current를 다음 노드로 이동하여 다음 노드의 값 검사
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 테스트할 입력 연결 리스트 생성 (초기화 리스트 사용) - head = [1, 1, 2, 3, 3]
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
		
		// deleteDuplicates 메소드 호출
		ListNode result = deleteDuplicates(head);
		
		// 결과 출력 (스트림 사용)
		System.out.print("[");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.print("]");
	}
}
