package sortAlgorithm;

/*
	거품정렬(Bubble Sort) - 정렬 과정에서 원소의 이동이 마치 거품이 수면위로 올라오는 듯
	: 두개의 인접한 원소를 비교하여 정렬
	- 비교정렬: 데이터를 비교하며 찾음
	- 제자리 정렬: 정렬의 대상이 되는 데이터 외에 추가적인 공간 필요X(임시변수swap만 필요)
	- 안정 정렬: 앞에서부터 차례로 비교
	
	거품정렬 과정(오름차순 기준)
	1. 앞에서부터 현재 원소와 바로 다음의 원소를 비교
	2. 현재 원소가 다음 원소보다 크면 원소 교환
	3. 다음 원소로 이동해서 해당 원소와 그 다음 원소 비교
	=> 각 라운드를 진행할 때 마다 "뒤에서부터 한개씩 정렬"되기에,
	 총 라운드(데이터비교횟수): 배열크기-1, 데이터 비교횟수: 배열크기 - i(1<=i< size) 만큼 비교
 */
public class Bubble_Sort {
	
	static void bubble_sort(int[] array) {
		bubble_sort(array, array.length);
	}
	
	// 입력받은 array에서 idx1에 해당하는 원소와 idx2에 해당하는 원소를 교환
	static void swap(int[] array, int idx1, int idx2) {
		// 임시변수를 이용하여 원소값을 교환
		int temp = array[idx2];
		array[idx2] = array[idx1];
		array[idx1] = temp;
	}
	
	static void bubble_sort(int[] array, int size) {
		// 총 라운드는 배열크기 - 1만큼 진행됨 => 첫번째 라운드: 1 ~ 마지막 라운드: size-1
		for (int i=1; i < size; i++) {
			
			// 각 라운드별 비교횟수는 배열크기 - 현재 라운드 만큼 비교
			for(int j=0; j<size-i; j++) {
				/*
				 * 현재 원소가 다음 원소보다 클 경우
				 * 서로 원소의 위치를 교환
				 */
				if(array[j] > array[j+1]) {
					swap(array, j, j+1);
				}
			}
		}
	}
}
