package sortAlgorithm;
/*
 	* Binary Insertion Sort [이진 삽입 정렬]
	: '정렬 된 상태의 구간' 내에서 중간에 위치한 원소와 비교하여 
  		중간 원소보다 작다면 왼쪽 구간으로, 크다면 오른쪽 구간으로 다시 나누어 탐색하는 과정
	- Insertion Sort(삽입정렬)의 메커니즘은 같으나,
 		원소가 들어 갈 위치를 선형 탐색이 아닌 이분 탐색(이진 탐색)을 이용한 방법으로 구현
	- 첫 번째 원소는 타겟이 되어도 비교 할 원소가 없기 때문에 
  		처음 원소부터 타겟이 될 필요가 없고 두 번째 원소부터 타겟

 	* 이진 삽입 정렬 과정(오름차순 기준)
	1. 현재 타겟이 되는 숫자에 대해 이전 위치에 있는 원소들에 들어 갈 위치를 이분 탐색을 통해 얻어낸다.
 		(첫 번째 타겟은 두 번째 원소부터 시작한다.)
	2. 들어가야 할 위치를 비우기 위해 후방 원소들을 한칸 씩 밀고 비운 공간에 타겟을 삽입한다.
	3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.
*/
public class Binary_Insertion_Sort {
	
	static void binaryInsertionSort(int[] a) {
		binaryInsertionSort(a, a.length);
	}
	
	// 첫 번째 원소는 타겟이 되어도 비교 할 원소가 없기 때문에 
	// 처음 원소부터 타겟이 될 필요가 없고 두 번째 원소부터 타겟
	static void binaryInsertionSort(int[] a, int size) {
		
		for (int i=1; i<size; i++) {
			// 타겟넘버
			int target = a[i];
			
			// 이분탐색을 통해 target이 들어가야 할 위치를 얻음
			int location = binarySearch(a, target, 0, i);
			
			// 타겟넘버의 이전원소 인덱스
			int j=i-1;
			// 시프팅 작업 수행(위치를 바꿔줌)
			while(j >= location) {
				// 이전 원소를 한 칸씩 뒤로 미뤄줌
				a[j+1] = a[j];
				j--;
			}
			// 타겟넘버를 location에 할당해줌
			a[location] = target;
		}
	}
	
	// 이분탐색 시행
	private static int binarySearch(int[] a, int key, int low, int high) {
		
		// 중간 인덱스 선언
		int mid;
		while(low < high) {
			// 좀 더 빠르게 하기 위해 /2대신, >>> 1을 사용해도 됨
			mid = low + ((high - low)/2);
			
			if (key < a[mid]) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return high;
	}
}
