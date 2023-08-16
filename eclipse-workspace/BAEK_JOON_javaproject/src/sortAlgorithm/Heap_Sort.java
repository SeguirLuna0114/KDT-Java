package sortAlgorithm;

/*
 * * 힙 정렬(heap Sort): 이진 힙 자료구조를 배열로 구현하여 정렬 수행하는 알고리즘
 * 
 * * 힙(heap): 최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전 이진트리 형태로 만들어진 자료구조
 * 		'부모 노드는 자식 노드보다 우선순위가 높다' => 모든 요소를 고려하여 우선순위 정할 필요X
 * 	1. 최소 힙 : 부모 노드의 값(key 값) ≤ 자식 노드의 값(key 값)
 * 	2. 최대 힙 : 부모 노드의 값(key 값) ≥ 자식 노드의 값(key 값)
 * 
 * 	* 힙 자료구조를 배열로 구현시 성질
 * 	1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
 * 	2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
 * 	3. 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
 */
public class Heap_Sort {

	// 부모 인덱스를 얻는 함수
	static int getParentNode(int childNode) {
		// 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
		return (childNode -1) /2 ;
	}
	
	// 두 인덱스의 원소를 교환하는 함수
	static void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx2];
		array[idx2] = array[idx1];
		array[idx1] = temp;
	}
	
	// heap을 만드는 함수 heapify - case1) 재귀호출
	// 힙을 만드는 과정('heapify')는 부모노드(상위 노드)부터 자식노드(하위 노드)로 진행됨(sift-down 과정)
	static void heapify_Recursion(int[] array, int parentIdx, int lastIdx) {
		/*
		 * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
		 * - 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
		 * - 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
		 */
		int leftChildIdx = 2* parentIdx + 1;
		int rightChildIdx = 2*parentIdx + 2;
		
		// 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
		int largestIdx = parentIdx;
		
		/*
		 *  * left child node와 비교
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
		 */
		if(leftChildIdx <= lastIdx && array[largestIdx] < array[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}
		
		/*
		 *  * right child node와 비교
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
		 */
		if(rightChildIdx <= lastIdx && array[largestIdx] < array[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}
		
		/*
		 * largestIdx 와 부모노드가 같지 않다는 것
		 * = 위 if문에 해당하여 largestIdx값이 자식노드 인덱스값으로 변경되었다는 의미
		 * = 위 자식노드 비교 과정에서, 현재 부모노드보다 큰 노드가 존재한다는 뜻
		 * 
		 * 그럴 경우 해당 자식 노드(largestIdx)와 부모노드(parentIdx)를 교환해주고,
		 * 교환 된 자식노드(largestIdx)를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
		 */
		if(parentIdx != largestIdx) {
			swap(array, largestIdx, parentIdx);	// 해당 자식 노드와 부모노드를 교환
			heapify_Recursion(array, largestIdx, lastIdx);	// 자식노드(largestIdx)를 부모노드로 삼은 서브트리를 검사
		}
	}
	
	
	// heap을 만드는 함수 heapify - case2) 반복문형식
	// 힙을 만드는 과정('heapify')는 부모노드(상위 노드)부터 자식노드(하위 노드)로 진행됨(sift-down 과정)
	static void heapify_while(int[] array, int parentIdx, int lastIdx) {
		
		// 왼쪽 자식 노드 인덱스 선언
		// - 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
		int leftChildIdx;
		// 오른쪽 자식 노드 인덱스 선언
		// - 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
		int rightChildIdx;
		// 가장 큰 값을 갖는 인덱스 선언
		int largestIdx;
		
		/*
	     * 현재 부모 인덱스의 '자식 노드 인덱스'가 
	     * '마지막 인덱스'를 넘지 않을 때 까지 반복
	     * 
	     * 이 때 '왼쪽 자식 노드'를 기준으로 해야 한다.
	     * 오른쪽 자식 노드를 기준으로 범위를 검사하게 되면
	     * 마지막 부모 인덱스가 왼쪽 자식만 갖고 있을 경우
	     * 왼쪽 자식노드와는 비교 및 교환을 할 수 없기 때문이다. 
	     */
		
		// 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
		while((parentIdx * 2)+1 <= lastIdx) {
			/*
			 * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
			 * - 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
			 * - 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
			 */
			leftChildIdx = (parentIdx * 2) + 1;
			rightChildIdx = (parentIdx * 2) + 2;
			// 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
			largestIdx = parentIdx;
			
			/*
			 *  * left child node와 비교
			 *  현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
			 *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
			 * (범위는 while문에서 검사했으므로 별도 검사 필요 없음)
			 */
			if(array[leftChildIdx] > array[largestIdx]) {
				largestIdx = leftChildIdx;
			}
			
			/*
			 *  * right child node와 비교
			 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
			 * (right child node는 범위를 검사 필요)
			 *  현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
			 *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
			 */
			if(rightChildIdx <= largestIdx && array[rightChildIdx] > array[largestIdx]) {
				largestIdx = rightChildIdx;
			}
			
	        /*
	         * largestIdx 와 부모노드가 같지 않다는 것
	         * = 위 if문에 해당하여 largestIdx값이 자식노드 인덱스값으로 변경되었다는 의미
	         * = 위 자식노드 비교 과정에서, 현재 부모노드보다 큰 노드가 존재한다는 뜻
	         * 
	         * 따라서, 교환이 발생했을 경우 두 원소를 교체 한 후 
	         * 교환이 된 자식노드를 부모 노드가 되도록 교체한다. 
	         */
			if(largestIdx != parentIdx) {
				swap(array, parentIdx, largestIdx);		// 부모 인덱스와 largestIdx(교환된 자식노드)의 원소를 교체
				parentIdx = largestIdx;				// 교환된 자식노드를 부모노드가 되도록 교체
			}
			else {
				return;
				// if문에 해당하지 않아서 largestIdx와 부모노드가 같다면
				// 해당 반복문 중지하고 메소드 호출한 곳으로 이동
			}
		}
	}
	
	
	// heap 정렬
	static void heapSort(int[] array) {
		int size = array.length;
		
		/*
		 * 부모노드와 heaify과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
		 * 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
		 */
		if(size < 2) {
			return;
			// return문으로 해당 함수를 "종료"하고 메소드를 호출한 곳으로 돌아감
		}
		
		// 가장 마지막 노드(마지막 인덱스는 size-1)와 부모 노드 인덱스
		int parentIdx = getParentNode(size-1);
		
		// max heap 만들기 => 최대 힙(max heap)으로 array 배열이 재구성됨
		for (int i=parentIdx; i>=0; i--) {
			//부모노드(i값)을 1씩 줄이면서 heap 조건을 만족시키도록 재구성
			heapify_while(array, i, size-1);
		}
		
		// 정렬 과정-마지막인덱스부터 1씩 감소시키며 인덱스1까지 반복(size>=2)
		for(int i=size-1; i>0; i--) {
			/*
			 *  root인 0번째 인덱스와 i번째 인덱스의 값을 교환해준 뒤
			 *  0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록
			 *  재구성한다.
			 */
			swap(array, 0, i);	// 배열의 0번째 인덱스와 i번째 인덱스 값을 교환
			heapify_while(array, 0, i-1);	// 배열의 0번째 인덱스(교환된 i번째 인덱스)를 부모로, i-1인덱스를 마지막 인덱스로
		}
	}
	
}
