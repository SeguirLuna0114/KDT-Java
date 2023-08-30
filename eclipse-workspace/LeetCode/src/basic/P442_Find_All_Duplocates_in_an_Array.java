package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 배열 안에서 중복되는 글자를 찾는 코딩
 * - 숫자는 중복 안된 숫자들과, 한번만 중복된 숫자가 존재(두번 이상 중복된 숫자는 없음)
 * 
 * Given an integer arr nums of length n
 * where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice
 * return an array of all the integers that appears twice
 * 
 * ex) nums = [4, 3, 2, 7, 8, 2, 3, 1]
 * 		=> output : [2, 3]
 * ex) nums = [1]
 * 		=> output : []
 */
public class P442_Find_All_Duplocates_in_an_Array {
	
//	방법1) List인터페이스 사용
	static List<Integer> findDuplicates(int[] nums) {
		
		// 리턴 할 리스트를 ArrayList 로 선언
		List<Integer> result = new ArrayList<Integer>();
		
		// 입력받은 배열을 정렬
		Arrays.sort(nums);
		
		//일단 입력된 배열 내의 값의 개수 만큼 for 문 실행
		for(int i=0; i<nums.length; i++) {
			// 첫번째 값과 그 나머지 값을 비교해야 하니까 총 개수 - 1 만큼 for문을 다시 돌림
			for(int j=i+1; j< nums.length; j++) {
				// 만일, 같은 숫자가 나온다면, list에 추가
				if (nums[j] == nums[i]) {
					result.add(nums[i]);
					// 나머지는 비교하지 않고 해당 j는 for문을 나가서
					// i++이 적용 되서 그 다음 숫자(i+1)를 가지고 비교
					break;
				}
			}
		}
		
		// 중복된 숫자만 추가된 리스트를 리턴
		return result;
	}
	
	
//	방법2) 정렬한 후, 이전값과 같다면 List에 추가
	static List<Integer> findDuplicates2(int[] nums) {
		
		List<Integer> ret = new ArrayList<Integer>();
		
		// 입력받은 배열을 정렬
		Arrays.sort(nums);
		
		// 정렬된 배열에서 이전값과 현재값이 같은 경우는 중복된다는 의미기에 List에 추가
		for(int i=1; i<nums.length; i++) {
			
			if(nums[i] == nums[i-1]) {
				ret.add(nums[i]);
				i++;	// 정렬이 돼 있고 중복이 안 됐거나 한번만 중복이 된 경우만 존재 하므로 2증가
			}
		}
		
		return ret;
	}
	
	
//	방법3) Hashset을 사용해서 중복된 원소를 찾는 방법
	/** HashSet은 중복을 허용하지 않음
	 * - contains라는 메소드를 사용해서 해당 값이 있다면 추가
	 */
	static List<Integer> findDupHashSet(int[] nums) {
		
		// 중복된 수를 리턴할 List객체
		List<Integer> list = new ArrayList<Integer>();
		// 중복되지 않는 수를 담은 hashSet객체
		Set<Integer> hashset = new HashSet<Integer>();
		
		for(int num : nums) {
			
			// HashSet 내에 이미 같은 문자가 있는 경우, 나온적 있는 수이기에 중복된 수
			if(hashset.contains(num)) {
				list.add(num);
			} else {
				// HashSet내에 같은 숫자가 없는 경우, 나온적없는 수이기에 hashSet에 추가
				hashset.add(num);
			}
		}
		
		// 중복된 수를 담은 List객체 리턴
		return list;
	}
	
	
//	방법4. 각 숫자의 위치에 해당하는 인덱스에 값을 음수로 변경하여 중복 여부를 확인
	static List<Integer> findDupABS(int[] nums) {
		
		List<Integer> duplist = new ArrayList<Integer>();
		
		// 각 숫자의 위치에 해당하는 인덱스 값을 음수로 변경
		// => 이미 방문한 숫자의 위치는 음수로 변경되어 중복된 숫자가 체크됨
		for(int n : nums) {
			nums[Math.abs(n) -  1] *= -1;
		}
		
		// 음수가 아닌 값들 즉, 이미 체크된 중복 숫자들을 찾아냄
		for(int n : nums) {
			// 양수라면 음수가 2번 곱해진 것이기에, 중복값임 => 중복 리스트에 추가
			if(nums[Math.abs(n) -1] > 0) {
				duplist.add(Math.abs(n));
				
				// 중복된 숫자는 처리되었음을 표시하기 위해 음수로 변경
				nums[Math.abs(n) -1] *= -1;
			}
		}
		
		return duplist;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[args.length];
		
		for(int i=0; i<args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		
		// 중복된 값을 찾는 메소드 실행
//		방법1) List인터페이스 사용
		System.out.println(findDuplicates(nums));
		
//		방법2) 정렬한 후, 이전값과 같다면 List에 추가
		System.out.println(findDuplicates2(nums));
		
//		방법3) Hashset을 사용해서 중복된 원소를 찾는 방법
		System.out.println(findDupHashSet(nums));
		
//	`	방법4. 각 숫자의 위치에 해당하는 인덱스에 값을 음수로 변경하여 중복 여부를 확인
		System.out.println(findDupABS(nums));
	}
}
