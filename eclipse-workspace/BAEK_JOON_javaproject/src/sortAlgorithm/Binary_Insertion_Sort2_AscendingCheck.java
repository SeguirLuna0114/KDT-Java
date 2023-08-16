package sortAlgorithm;

/*	* Binary Insertion Sort [이진 삽입 정렬]심화
 	 이분 삽입 정렬을 하기 전에 리스트의 가장 앞부분에 오름차순, 혹은 내림차순이 
 	 몇 개까지 연속되어있는지를 확인하고 그 길이를 반환
	
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
public class Binary_Insertion_Sort2_AscendingCheck {

	public static void binaryInsertionSort(int[] a) {
		if (a.length < 2) {
			return;
		}
		int incLength = getAscending(a, 0, a.length);
		binaryInsertionSort(a, 0, a.length, incLength);
	}

	/**
	 * 
	 * @param a     정렬 할 배열
	 * @param lo    정렬 할 배열 구간의 하한선(a[lo] 포함)
	 * @param hi    정렬 할 배열 구간의 상한선(a[hi] 미포함)
	 * @param start 정렬 할 배열의 원소 탐색 시작점
	 */
	private static void binaryInsertionSort(int[] a, int lo, int hi, int start) {

		// 만약 start와 lo가 같다면 이분 탐색 시작점은 lo + 1부터이므로 start을 1 증가시킨다.
		if (lo == start) {
			start++;
		}
		/*
		 * start 이전 원소들은 이미 오름차순으로 정렬 된 상태이므로 start부터 시작하여 이분 탐색 및 시프팅을 통해 삽입정렬을 해준다.
		 */
		for (; start < hi; start++) {
			// 타겟 넘버
			int target = a[start];

			int loc = binarySearch(a, target, lo, start);

			int j = start - 1;

			// 타겟이 들어갈 위치보다 큰 원소들을 뒤로 미룬다.
			while (j >= loc) {
				a[j + 1] = a[j]; // 이전 원소를 한 칸씩 뒤로 미룬다.
				j--;
			}

			/*
			 * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로 타겟 원소는 j번째 원소 뒤에 와야한다. 그러므로 타겟은 j + 1
			 * 에 위치하게 된다.
			 */
			a[loc] = target;
		}
	}

	// 이분 탐색
	private static int binarySearch(int[] a, int key, int lo, int hi) {

		int mid;
		while (lo < hi) {
			mid = lo + ((hi - lo) / 2);
			// 안장 정렬을 위해 key가 a[mid]보다 작을 때만 상한선을 옮긴다.
			if (key < a[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	// lo와 lo + 1 의 비교를 통해 lo 부터 몇 개의 원소가 오름차순 혹은 내림차순인지를 반환하는 메소드
	private static int getAscending(int[] a, int lo, int hi) {

		int limit = lo + 1;
		if (limit == hi) { // lo + 1 == hi 라는 것은 결국 정렬 할 원소가 a[lo] 1개 뿐이라는 의미다.
			return 1;
		}

		// 오름차순 일 경우 (안정 정렬을 위해 같은 경우까지 포함)
		if (a[lo] <= a[limit]) {
			// 오름차순일 때까지 반복한다. (limit이 hi 범위를 벗어나면 안된다.)
			while (limit < hi && a[limit - 1] <= a[limit]) {
				limit++;
			}
		}
		// 내림차순 일 경우
		else {
			while (limit < hi && a[limit - 1] > a[limit]) {
				limit++;
			}
			reversing(a, lo, limit); // 내림차순의 경우엔 오름차순으로 변경해주어야 함
		}
		/*
		 * 시작점 lo를 빼주지 않으면 반환 되는 값은 정렬 된 구간이 아니라 
		 * 정렬 된 구간의 오른쪽 끝 인덱스를 가리키는 값이 됨
		 * => 특정 시작점에서의 정렬 된 구간의 길이를 반환 할 수 있도록
		 * 	  lo(시작점)을 빼주도록 하는 것
		 */
		return limit - lo;
	}

	// 원소를 뒤집어준다.
	private static void reversing(int[] a, int lo, int hi) {
		// a[lo] <= a[i] < a[hi] 범위이므로 마지막 인덱스는 hi - 1부터 시작된다.
		hi--;
		while (lo < hi) {
			int temp = a[lo];
			a[lo] = a[hi];
			a[hi] = temp;
			lo++;
			hi--;
		}
	}
}
