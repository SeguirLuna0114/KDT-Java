package sortAlgorithm;

/*	셸 정렬과정 중 삽입정렬을 따로 분리하여 정렬
	셸 정렬(Shell sort)
	:  배열을 "일정한 간격(간격을 통해 부분 리스트를 생성)"으로
	   분할하여 부분 리스트 내에서 삽입 정렬을 수행
	
	- 기존 삽입정렬은 타겟원소와 이전원소를 비교하여 타겟 원소가 들어갈 위치를 잡는것이라
	  만약 오름차순 기준으로 이전 원소보다 target원소가 작을경우 이전 원소를 모두 탐색하며
	  위치를 교환(swap)해야 한다는 단점 존재
	  => 이러한 삽입정렬의 단점을 줄인 방법
	- 비교정렬: 데이터를 비교하며 찾음
	- 체자리 정렬: 데이터 외에 추가적인 공간을 필요로하지X
	- 불안정 정렬: 일정 간격을 주기로 비교/교환이 일어남
	
	셸 정렬 과정
	1. 간격(gap) 설정
	2. 각 간격별로 분류된 서브(부분)리스트에 대해 삽입정렬
	3. 각 서브(부분) 리스트의 정렬이 끝나면 간격을 줄임
	4. 간격이 1이 될때까지 2번 과정으로 되돌아가며 반복
 */
public class Shell_Sort2 {
	
	// 많은 사람들이 각 간격에 따라 평균적으로 좋은 간격들을 내놓음 => Gap Sequences
	private final static int[] gap = 
		{ 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 	
		8858, 19930, 44842, 100894, 227011, 510774,
		1149241, 2585792, 5818032, 13090572, 29453787, 
		66271020, 149109795, 335497038, 754868335, 1698453753};	// 갭을 담고있는 배열

	
	// 맨 처음 gap을 참조할 인덱스를 구하는 메소드
	private static int getGap(int length) {
		int index = 0;
		// 최소한 부분 배열의 원소가 2개씩은 비교되도록 나눠줌
		int len = (int)(length / 2.25);
		
		while (gap[index] < len) {
			index++;
		}
		return index;
	}
	
	// 두 원소 값 교환하는 swap메소드 구현
	static void swap(int[] array, int index1, int index2) {
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}
	
	
	static void shell_sort(int[] array) {
		shell_sort(array, array.length);
	}
	
	
//	/**
//	 * 
//	 * @param array  배열
//	 * @param start	 부분 배열의 첫 번째 원소 인덱스 
//	 * @param size	 배열의 전체 크기
//	 * @param gap	 현재 gap
//	 */
//	public static void insertion_sort(int[] array, int start, int size, int gap) {
//		
//		// 부분 배열의 두번째 원소부터 size까지 반복(gap씩 건너뜀)
//		for (int i=start+gap; i<size; i+=gap) {
//			// 타겟원소
//			int target = array[i];
//			// 이전원소(현재 인덱스i보다 gap만큼 작은 원소의 인덱스)
//			int j = i - gap;
//			
//			// 타켓 원소가 이전 원소보다 작을때까지 반복
//			while(j >= start && target < array[j]) {
//				array[j+gap] = array[j];	// 이전 원소를 한 칸씩 미룸
//				j -= gap;
//			}
//			/*
//			 * 위 반복문에서 탈출 하는 경우 타켓원소가 이전원소보다 크다는 의미이므로
//			 * 타겟 원소는 j번째 원소(이전원소) 뒤에 와야한다.
//			 * 그러므로 타겟은 j + gap 에 위치하게 된다.
//			 */
//			array[j + gap] = target;
//		}
//	}
	
	
	// ----삽입정렬을 이용------
	private static void shell_sort(int[] array, int size) {
		// 첫 gap을 사용할 index
		int gapIndex = getGap(size);
		
//		// gap[index]값 부터 gap[0]까지 반복
//		for (int i=index; i >= 0; i--) {
//			
//			// 각 부분 리스트에 대해 삽입정렬
//			for (int j=0; j<gap[i]; j++) {
//				insertion_sort(array, j, size, gap[i]);
//			}
//		}
		
		/**
		 *	첫번째 방식과 달리, 하나의 부분리스트를 먼저 완료하는 것이 아니라,
		 *	부분 리스트를 한 번씩 돌아가면서 이전 원소들에 대해 삽입정렬 수행
		 */
		
		// 갭이 1이 될 때까지 반복
		while(gapIndex >= 0) {
			// 현재 gap(step)
			int step = gap[gapIndex--];
			
			/* * --- 삽입 정렬 과정 ---
			 * 각 부분리스트의 두 번째 원소의 인덱스 부터 순회한다.
			 * 예로들어 step이 3일 때 arr[0], arr[1], arr[2] 는 
			 * 이전 원소와 비교할 것이 없다.
			 * 그러므로 step부터 순회한다.   
			 */
			for (int i=step; i<size; i++) {
				/* 
				 * j는 target원소가 되며 현재원소(target) array[j]가
				 * 이전원소array[j-step]보다 작을 때까지 반복
				 */
				for(int j=i; j>= step && array[j] < array[j-step]; j -= step) {
					/*
					 * 현재(target)원소의 인덱스(j)와 이전원소(j-step)의 인덱스에 있는 원소의 값 교환
					 */
					swap(array, j, j-step);
				}
			}
		}
	}
}
