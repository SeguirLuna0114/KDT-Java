package sortAlgorithm;

/*
	합병(병합) 정렬
	: 정렬해야 할 리스트가 주어지면 해당 리스트를 분할을 반복하여
	  최대한 작게 쪼개진 시점에 부분리스트에서 인접한 원소들끼리 비교하여 정렬하는 방식
	- 분할정복 알고리즘을 기반으로 정렬되는 방식
	- 비교정렬: 데이터를 비교하면서 찾음
	- 제자리 정렬X: 정렬의 대상이 되는 데이터 이외에 추가적인 공간을 필요로 함
	- 안정정렬: 작게 문제를 쪼개어 앞의 부분리스트부터 차례로 합쳐감
	
	합병 정렬 과정
	1. 주어진 리스트를 절반으로 분할(Divide)하여 부분리스트로 나눔
	2. 해당 부분리스트의 길이가 1이 아니라면 1번 과정을 되풀이
	3. 인접한 부분리스트끼리 정렬하여 합침(Conqure)
 */
public class Merge_Sort {
	
	// 합치는 과정에서 정렬하여 원소를 담을 임시배열
	private static int[] sorted;
	
	static void merge_sort(int[] array) {
		sorted = new int[array.length];
		sorted = null;
		
		// 부분 리스트로 나누는 과정을 2방식 중 하나 사용
		merge_sort_TD(array, 0, array.length-1);
//		merge_sort_BU(array, 0, array.length-1);
	}
	
	
	// 부분리스트로 나누는 과정 Top-Down 방식 구현
	private static void merge_sort_TD(int[] array, int left, int right) {
		
		/*
		 *  left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우 
		 *  더이상 쪼갤 수 없으므로 return한다.
		 */
		if(left == right) {
			return;
		}
		
		// 절반위치
		int mid = (left + right)/2;
		
		// 절반 중 왼쪽 부분리스트(left ~ mid)
		merge_sort_TD(array, left, mid);
		
		// 절반 중 오른쪽 부분 리스트(mid+1 ~ right)
		merge_sort_TD(array, mid+1, right);
		
		// 병합작업
		merge(array, left, mid, right);
	}
	
	
	// 부분리스트로 나누는 과정 Bottom-Up 구현방식
	private static void merge_sort_BU(int[] array, int left, int right) {
		/* 배열을 작은 부분리스트로 나누는 방법
		 * 1-2-4-8-... 식으로 1부터 서브리스트를 나누는 기준을 두배씩 늘림
		 * 처음에는 1로 시작하여 2배씩 늘려가면서 부분 리스트의 크기를 설정
		 */
		for(int size=1; size <= right; size+= size) {
			/*
			 * 두 부분리스트을 순서대로 병합해준다.
			 * 예로들어 현재 부분리스트의 크기가 1(size=1)일 때
			 * 왼쪽 부분리스트(low ~ mid)와 오른쪽 부분리스트(mid + 1 ~ high)를 생각하면
			 * 왼쪽 부분리스트는 low = mid = 0 이고,
			 * 오른쪽 부분리스트는 mid + 1부터 low + (2 * size) - 1 = 1 이 된다.
			 *  
			 * 이 때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이
			 * 병합되도록 해야한다. 
			 */
			for(int leftstart = 0; leftstart <= right-size; leftstart +=(2*size)) {
				// 왼쪽 부분리스트 시작점
				int low = leftstart;
				// 절반위치
				int mid = leftstart + size -1;
				// 오른쪽 부분리스트 시작점
				int high = Math.min(leftstart+(2*size)-1, right);
				// 병합작업
				merge(array, low, mid, high);
			}
		}
	}
	
	
	/**
	 * 부분리스트는 array배열의 left ~ right 까지이다. 
	 * 
	 * @param array	정렬할 배열
	 * @param left	배열의 시작점
	 * @param mid	배열의 중간점
	 * @param right	배열의 끝 점
	 */
	private static void merge(int[] array, int left, int mid, int right) {
		// 왼쪽 부분 리스트의 시작점
		int leftstart = left;
		// 오른쪽 부분 리스트의 시작점
		int rightstart = mid+1;
		// 채워 넣을 배열의 인덱스
		int idx = left;
		
		while(leftstart <= mid && rightstart <= right) {
			/*
			 *  왼쪽 부분리스트 leftstart번째 원소가 오른쪽 부분리스트 rightstart번째 원소보다 작거나 같을 경우
			 *  왼쪽의 leftstart번째 원소를 새 배열에 넣고 leftstart과 idx를 1 증가시킨다.
			 */
			if(array[leftstart] <= array[rightstart]) {
				sorted[idx] = array[leftstart];
				idx++;
				leftstart++;
			}
			
			/*	그 외, 왼쪽 부분리스트 leftstart번째 원소가 오른쪽 부분리스트 rightstart번째 원소보다 큰경우
			 *  오른쪽의 rightstart번째 원소를 새 배열에 넣고 rightstart과 idx를 1 증가시킨다.
			 */
			else {
				sorted[idx] = array[rightstart];
				idx++;
				rightstart++;
			}
		}
		// leftstart > mid 이거나 rightstart> right인 경우
		
		/* leftstart > mid
		 * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (leftstart > mid)
		 * => 오른쪽 부분리스트 원소가 아직 남아있을 경우
		 * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		if(leftstart > mid) {
			// rightstart 인덱스가 범위 내에 있는 한
			while(rightstart <= right) {
				sorted[idx] = array[rightstart];
				idx++;
				rightstart++;
			}
		}
		
		/* rightstart> right
		 * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
		 * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
		 * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		else {
			while (leftstart <= mid) {
				sorted[idx] = array[leftstart];
				idx++;
				leftstart++;
			}
		}
		
		// 정렬된 새 배열 sorted를 기존의 배열에 복사하며 옮겨줌
		for (int i=left; i <= right; i++) {
			array[i] = sorted[i];
		}
	}
}
