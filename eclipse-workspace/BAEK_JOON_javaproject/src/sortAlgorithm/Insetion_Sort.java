package sortAlgorithm;

/*
	삽입 정렬(Insertion Sort)
	: 현재 비교하고자 하는 target과 그 이전의 원소들을 비교하며 자리 교환(swap)하는 정렬
	
	- 비교정렬: 데이터를 '비교'하며 찾음
	- 제자리 정렬(in-place sort): 정렬 대상이 되는 데이터 외에 추가적인 공간을 필요로하지 않기에
	- 안정정렬(선택정렬과 달리)
	
	삽입정렬 과정(오름차순 기준)
	1. 현재 '타겟이 되는 숫자'와 '이전 위치에 있는 원소' 비교(첫번째 타켓은 두번째 원소부터 시작)
	2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치교환
	3. 그 다음 타겟을 찾아 위 같은 방법으로 반복
 */
public class Insetion_Sort {
	
	static void insertion_sort(int[] array) {
		insertion_sort(array, array.length);
	}

	public static void insertion_sort(int[] array, int size) {
		
		// 첫번째 타켓은 두번째 원소부터 시작(타겟 숫자 vs 이전 숫자 비교)
		for (int i=1; i<size; i++) {
			// 타겟 넘버
			int target = array[i];
			
			// 이전 원소와 비교하기위한 정수j 설정
			int j=i-1;
			// 타겟이 이전 원소보다 크기 전까지 반복
			while( j>=0 && target < array[j]) {
				// 이전 원소를 한 칸씩 뒤로 미룸
				array[j+1] = array[j];
				j--;
			}
			
			/*
			 * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
			 * 타겟 원소는 j번째 원소 뒤에 와야한다.
			 * 그러므로 타겟은 j + 1 에 위치하게 된다.
			 */
			array[j+1] = target;
		}
	}
}
