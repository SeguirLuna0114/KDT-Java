package easy;

/** 정렬된 int배열에서 겹친 숫자가 몇개인지 알아내는 문제
 * Remove Duplicates from Sorted Array
 * - Given an integer array nums sorted in non-decreasing order.
 * - remove the duplicated in-place such that each unique element appears only once.
 * - The relative order of the elements should be kept the same.
 * 
 * * Do not alloate extra space for another array.
 * 	(새로운 배열을 만들어서 풀지 말고, 입력된 배열을 수정해서 답을 구하라는 문제)
 * * Must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * ex) nums = [1, 1, 2]	=> 2, nums = [1, 2, _]
 * ex) nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] => 5, nums = [0, 1, 2, 3, 4]
 */
public class P26_Remove_Duplicates_from_Sorted_Array {
	
	/* 알고리즘
	 * 1. 입력값은 오름차순 정렬됨 => 첫번째 숫자는 제일 작은 숫자
	 * 	 	- 두번째 숫자를 첫번째 숫자와 비교해서, 같은 숫자이면 중복된 숫자
	 * 		- 만일, 같지 않다면, 해당 숫자를 두번째 자리에 둠
	 * 2. 새로 나온 중복되지 않는 숫자를 제자리에 넣기위한 인덱스 변수 설정(InsertIdx)
	 * 3. 입력된 배열 속 숫자들을 살피기 위해 배열의 길이를 다뤄야 함(Array.length)
	 */
	static int removeDuplicates(int[] nums) {
		
		// 입력받은 숫자 배열이 비어있는 경우 return 0
		if(nums.length == 0) {
			return 0;
		}
		
		/** 중복되지 않는 숫자를 제자리에 넣기 위한 인덱스 변수 설정
		 *  맨처음 숫자배열이 InsertIdx =0의 위치에 있기에,
		 *  그 이후의 숫자를 탐색함 => 따라서 InsertIdx =1 부터 시작
		 * - 입력된 배열의 모든 아이템 숫자를 비교하기 위해 length만큼 for문을 돌림
		 */
		int InsertIdx = 1;
		for(int i=1; i<nums.length; i++) {
			// 현재 숫자와 이전숫자를 비교하여 다르면 새로운 인덱스위치에 넣기
			if(nums[i] != nums[i-1]) {
				nums[InsertIdx] = nums[i];
				InsertIdx++;	// 다음 위치에 숫자 삽입을 위해 인덱스를 1 증가
			}
		}
		// 마지막으로 중복되지 않는 숫자를 넣은 후, 1 증가한 상태이기에
		// 인덱스 +1 = 실제 숫자 개수여서 InsertIdx값 리턴
		return InsertIdx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 입력받은 배열을 숫자 배열로 설정
		int[] nums = new int[args.length];
		for(int i=0; i<args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		
		// 중복되는 숫자를 삭제한 배열을 만드는 메소드 실행
		int k = removeDuplicates(nums);
		
		// 중복숫자를 삭제한 배열을 출력
		StringBuilder sb= new StringBuilder();
		sb.append(k).append(", nums = [");
		for(int i=0; i<k; i++) {
			sb.append(nums[i]);
			if(i != k-1) {
				sb.append(", ");
			}
		}
		sb.append(']');
		System.out.println(sb);
	}
}