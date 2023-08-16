package sortAlgorithm;

/*
	퀵 정렬(Quick Sort)
	- '분할 정복' 알고리즘을 기반으로 정렬되는 방식
		단, 퀵 정렬(Quick Sort)의 경우 
		피벗(pivot)의 값에 따라 피벗보다 작은 값을 갖는 부분리스트와 
		피벗보다 큰 값을 갖는 부분리스트의 크기가 다를 수 있음
	- 비교정렬: 데이터를 비교하면서 찾음
	- 제자리 정렬: 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로하지X
	- 불안정 정렬: 하나의 피벗을 두고 두개의 부분리스트를 만들 때 서로 떨어진 원소끼리 교환
	
	* 퀵 정렬의 메커니즘
	1. 피벗을 하나 선택한다.
	2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다. 왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.
	3. 양 방향에서 찾은 두 원소를 교환한다.
	4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복한다.
	5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐 때 까지 1번 과정을 반복한다. (Divide : 분할)
	6. 인접한 부분리스트끼리 합친다. (Conquer : 정복)
 */
public class Quick_Sort {

	public static void sort(int[] a) {
		l_pivot_sort(a, 0, a.length - 1);
	}
	
	/**
	 *  왼쪽 피벗 선택 방식
	 * @param a		정렬할 배열
	 * @param lo	현재 부분배열의 왼쪽
	 * @param hi	현재 부분배열의 오른쪽
	 */
	private static void l_pivot_sort(int[] a, int low, int high) {
		/*
		 *  low가 high보다 크거나 같다면 정렬 할 원소가 
		 *  1개 이하이므로 정렬하지 않고 return한다.
		 */
		if(low >= high) {
			return;
		}
		
		/*
		 * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
		 * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
		 * 
		 * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
		 * 분할 정복을 해준다.
		 * 
		 * [과정]
		 * Partitioning:
		 *
		 *   a[left]          left part              right part
		 * +---------------------------------------------------------+
		 * |  pivot  |    element <= pivot    |    element > pivot   |
		 * +---------------------------------------------------------+
		 *    
		 *  result After Partitioning:
		 *  
		 *         left part          a[low]          right part
		 * +---------------------------------------------------------+
		 * |   element <= pivot    |  pivot  |    element > pivot    |
		 * +---------------------------------------------------------+
		 *  result : pivot = low     
		 *       
		 *  Recursion:
		 * l_pivot_sort(a, low, pivot - 1)    l_pivot_sort(a, pivot + 1, high)
		 *  
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |    pivot    |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * low                pivot - 1        pivot + 1                 high
		 * 
		 */
		int pivot = partition(a, low, high);
		
		l_pivot_sort(a, low, pivot-1);
		l_pivot_sort(a, pivot+1, high);
	}
	
	private static int partition(int[] a, int left, int right) {
		int low = left;
		int high = right;
		
		// 부분리스트의 왼쪽 요소를 피벗으로 설정
		int pivot = a[left];
		
		// low가 high보다 작을때까지만 반복
		while(low < high) {
			/*
			 * high가 low보다 크면서, high의 요소가 pivot보다 작거나 같은 원소를
			 * 찾을 떄 까지 high를 감소시킨다.
			 */
			while(a[high] > pivot && low < high) {
				high--;
			}
			
			/*
			 * high가 low보다 크면서, low의 요소가 pivot보다 큰 원소를
			 * 찾을 떄 까지 low를 증가시킨다.
			 */
			while(a[low] <= pivot && low < high) {
				low++;
			}
			
			// 교환될 두 요소를 찾았으면 두 요소를 바꿈
			swap(a, low, high);
		}
		
		/*
		 *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와 
		 *  low가 가리키는 원소를 바꾼다.
		 */
		swap(a, left, low);		// while문에 의해 업데이트 된 low의 원소를 left의 원소와 바꿈
		
		// 두 요소가 교환되었다면 피벗이었던 요소는 low에 위치하게됨 => low반환
		return low;
	}
	
	private static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
}
