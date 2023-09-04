package binarySearch_easy;

/** Search Insert Position
 * - Given a sorted array of distinct integers and a target value
 * - return the index if the target is found.
 * - If not, return the index where it would be if it were inserted in order
 * 
 * ex) nums= [1, 3, 5, 6] target=5 => output : 2
 * 	   nums= [1, 3, 5, 6] target=2 => output : 1
 */
public class P35_Search_Insert_Position {
	
	/* 전형적인 이분탐색(Binary Search)
	 * "Target값을 정렬된 배열에 순서에 맞게 넣으려면, 몇번째에 넣어야 하는지"
	 */
	static int searchInsert(int[] nums, int target) {
		
		// 반환할 값
		int resultVal = 0;
		
		// 타겟값이 정렬된 배열의 마지막 값보다 크다면, 타겟값은 맨 마지막에 들어가야 함
		if(nums[nums.length -1] < target) {
			resultVal = nums.length;
		}
		else {
			// 배열의 마지막값보다 크지 않다면, 반복문 실행
			for(int i=0; i < nums.length; i++) {
				
				/* 입력받은 nums배열을 오름차순 정렬되어있기에,
				 * target은 배열의 값 중 작은숫자부터 비교하게 됨
				 * 따라서, target값보다 큰 값이 나오는 구간의 인덱스가 target값이 들어가야 하는 인덱스 위치가 됨
				 * 
				 * 또는 해당 target값과 배열의 값이 같은 경우에도 해당 인덱스를 return
				 */
				if(nums[i] >= target) {
					// 타겟 값이 들어가야 하는 자리는 i
					resultVal = i;
					// 해당 for반복문을 빠져나감
					break;
				}
			}
		}
		return resultVal;
	}
	
/*	해당 문제는 O(log n)으로 로직을 만들어야 함
 * 	Binary Search를 수행해야 함 
 * 	1. 정렬된 배열을 다룰 때에는 , 중간값을 타겟값과 비교
 *  2. 중간값이 타겟값보다 작거나 같으면 오른쪽 반을 검색
 *  3. 중간값이 타겟값보다 크면 완쪽 반을 검색하며 탐색시간을 줄임
 */
	static int searchInsert2(int[] nums, int target) {
		
		// 범위를 정할 변수 설정
		int left = 0;
		int right = nums.length;
		
		// 이분탐색 시작
		while(left < right) {
			int mid = left  + (right - left)/2;
			
			// mid값이 타겟과 같으면 해당 값 반환
			if(nums[mid] == target) {
				return mid;
			}
			
			// 중간값이 타깃보다 크면 왼쪽 반을 검색하기 위해 right범위를 mid-1로 조정
			if(target < nums[mid]) {
				right = mid-1;
			}
			
			// 중간값이 타깃보다 작으면 오른쪽 반을 검색하기 위해 left범위를 mid+1로 조정
			if(nums[mid] < target) {
				left = mid+1;
			}
			
		}
		// 마지막에 남은 값을 반환
		return left;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] {1, 3, 5, 6};
		int target = 5;
		System.out.println(searchInsert2(nums, target));
	}

}
