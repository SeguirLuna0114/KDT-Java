package binarySearch_easy;

/** 정렬된 배열에서 target값이 몇번째에 있는지 인덱스 값을 출력
 * 
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target,
 * write a function to search target in nums.
 * 
 * If target exist, then return its index.
 * Otherwise, return -1.
 * 
 * Must write an algorithm with O(log n) runtime complexity
 *  ex) nums = [-1, 0, 3, 5, 9, 12], target=9 => output: 4
 */
public class P704_Binary_Search {
	/* Big O 표기법으로 표시 O(log n)
	 * - 루프 내에서 배열의 첫번째 값에서 마지막 값까지 하나 하나 살펴 보는 것은 O(n) 
	 * - O(log n) 은 배열의 중간 값을 가져 와서 타겟 값과 비교
	 * 	-> 그리고 타겟 값이 더 크면 왼 쪽 반을 버리고 오른쪽 반만 놓 고 다시 이를 반복
	 * 	"검색을 하는 step 을 줄여서 시간과 리소스 사용량을 줄일 수 있음"
	 */
//	방법1) 오른쪽 끝 인덱스를 nums.length-1로 설정하는 방법
	static int BinarySearch(int[] nums, int target) {
		
		// 탐색 범위 설정
		int left = 0;
		int right = nums.length-1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
//			System.out.println(left + ". nums[mid] is "+nums[mid]+", mid is "+mid);
			
			if(nums[mid] == target) {
				return mid;
			}
			else if(target > nums[mid]) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	
//	방법2) 오른쪽 끝 인덱스를 nums.length로 설정하는 방법
	static int BinarySearch2(int[] nums, int target) {
		
		// 탐색 범위 설정
		int left = 0;
		int right = nums.length;
		
		while(left < right) {
			
			int mid = left + (right - left)/2;
			
			if(nums[mid] == target) {
				return mid;
			}
			/* target이 mid값보다 큰 경우
			 * 탐색범위를 [mid+1 : right]로 변경
			 */
			else if(target > nums[mid]) {
				left = mid + 1;
			}
			/* target이 mid값보다 작은 경우
			 * 탐색범위를 [left : mid-1]로 변경
			 */
			else {
				right = mid-1;
			}
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[] {-1, 0, 3, 5, 9, 12, 14, 16, 19, 20};
		int target = 5;
		
//		방법1) 오른쪽 끝 인덱스를 nums.length-1로 설정하는 방법
		System.out.println(BinarySearch(nums, target));
		
//		방법2) 오른쪽 끝 인덱스를 nums.length로 설정하는 방법
		System.out.println(BinarySearch2(nums, target));
	}
}
