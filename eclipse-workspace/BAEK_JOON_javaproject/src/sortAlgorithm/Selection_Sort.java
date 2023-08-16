package sortAlgorithm;

/*
	선택정렬(Selection Sort)
	: 현재 위치에서 들어갈 데이터를 찾아 선택하는 알고리즘
	- 비교정렬: 데이터를 '비교'히면서 찾음
	- 제자리 정렬(in-place sort): 정렬의 대상이 되는 데이터 외에 추가적인 공간을 필요로하지X
	
	선택정렬 과정
	1. 주어진 리스트에서 최솟값을 찾음
	2. 최솟값을 맨 앞자리 값과 교환
	3. 맨 앞 자리를 제외한 나머지 값들 중 최솟값을 찾아 위와같은방법을 반복
	=> 앞 인덱스부터 순차적으로 정렬해나가기 때문에, 
	   N개의 데이터 중에서 N-1개가 정렬됨 = 마지막 원소가 최댓값
 */
public class Selection_Sort {

	static void selection_sort(int[] array) {
		selection_sort(array, array.length);
	}
	
	static void selection_sort(int[] array, int size) {
		
		for (int i=0; i<size-1; i++) {
			int min_index = i;
			
			// 최솟값을 갖는 인덱스 찾기
			for (int j=i+1; j<size; j++) {
				if(array[j] < array[min_index]) {
					min_index = j;
				}
			}
			
			// i번째 값과 찾은 최솟값을 서로 교환 => 최솟값을 현재 i번째 위치에 할당
			int temp = array[min_index];	// 최솟값을 temp변수에 임시 할당
			array[min_index] = array[i];	// 현재 i번째 값을 최솟값의 위치에 할당
			array[i] = temp;				// 최솟값을 현재 i번째 위치에 할당
		}
		
	}
	
}
