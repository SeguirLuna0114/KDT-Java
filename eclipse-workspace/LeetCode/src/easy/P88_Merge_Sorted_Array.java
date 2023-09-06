package easy;

import java.util.Arrays;

/** Merge Sorted Array
 * 첫번째 숫자의 개수만큼 첫번째 배열의 아이템을 사용하고 나머지는 버림
 * 두번째 숫자의 개수만큼 두번째 배열의 아이템을 사용하고 나머지는 버림
 * + 첫번째 배열의 아이템 숫자는 입력받은 두 숫자의 합
 * 
 * - given integer arrays nums1, nums2 sorted in non-decreasing order
 * - two integers m and n, representing the number of element in nums1 and num2
 * 	- to accommodate this, nums1 has a length of m+n
 * Then Merger nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * ex) Input : nums1 = [1,2,3,0,0,0], m=3, nums2=[2,5,6], n=3
 *     Output : [1,2,2,3,5,6]
 * ex) Input : nums1 = [1], m=1, nums2=[], n=0
 *     Output : [1]
 * ex) Input : nums1 = [0], m=0, nums2=[1], n=1
 *     Output : [1]
 */
public class P88_Merge_Sorted_Array {

	/* 방법1) 첫번째 배열의 아이템 숫자는 입력받은 두 숫자의 합이라는 조건을 활용
	 * " 첫번째 배열에서 첫번째 숫자와 맞는 개수만큼만 채우고, 
	 *   두번째 배열에서 나머지를 그냥 채워넣음"
	 * + 결과 값은 정렬 되어 있어야 하기에, Arrays.sort() 사용
	 */
	static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		// 첫번째 배열에 채워진 값을 기준으로, 그 이후부터 두번째 값을 채움
		for (int i=0; i<n; i++) {
			nums1[m+i] = nums2[i];
		}
		
		// 결과 값을 오름차순 정렬
		Arrays.sort(nums1);
	}
	
	
	// 방법2) Arrays.sort()대신 크기를 비교해가며 배열에 작성하는 방법
	static void merge2(int[] nums1, int m, int[] nums2, int n) {
		
		// nums1배열을 복사
		int[] nums1CP = new int[m];
		for(int i=0; i<m; i++) {
			nums1CP[i] = nums1[i];
		}
		
		// 각 배열의 위치를 나타내는 포인터 변수 생성
		int p1 = 0;
		int p2 = 0;
		
		// nums1[]의 크기가 m+n이니까 첫번째 배열의 크기만큼 반복
		// 복사한 배열과 두번째 배열의 원소들을 비교하며 작은 값부터 nums1배열에 작성
		for(int i=0; i<m+n; i++) {
			
			// p1과 p2포인터가 각 배열의 경계 안에 있는 경우
			// 첫번째 배열의 값이 두번째 배열의 값보다 작거나
			// 두번재 배열의 포인터가 배열의 경계를 넘어간 경우
			if(p2 >= n || (p1 < m && nums1CP[p1] < nums2[p2])) {
				nums1[i] = nums1CP[p1++];
			}
			// 첫번째 배열의 값이 두번째 배열의 값보다 같거나 큰 경우
			// 또는 첫번째 배열의 포인터가 배열의 경계 안에 있는 경우
			else {
				nums1[i] = nums2[p2++];
			}
		}
	}
	
	
//	방법3) 배열의 뒤에서 부터 값을 비교하며 입력하는 경우
	static void merge3(int[] nums1, int m, int[] nums2, int n) {
		/** 첫번째 배열의 뒷자리 부터 집어 넣는 경우에는
		 *  새로운 배열을 생성하지 않고 nums1에 곧바로 값을 넣을 수 있음
		 *  
		 *  - For 문은 m+n-1만큼만 반복
		 */
		// 각 배열의 위치를 나타내는 포인터 변수 생성
		int rev_idx1 = m-1;
		int rev_idx2 = n-1;
		
		for(int r = m+n-1; r>=0; r--) {
			
			if(rev_idx1>=0 && rev_idx2>=0) {
				nums1[r] = nums1[rev_idx1] > nums2[rev_idx2] 
						   ? nums1[rev_idx1--] : nums2[rev_idx2--];
			}
			else if(rev_idx1 >=0) {
				nums1[r] = nums1[rev_idx1--];
			}
			else {
				nums1[r] = nums2[rev_idx2--];
			}
		}
		// 그 외에는 메소드 실행중지
		return;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = new int[] {2,5,6};
		int n = 3;
		
//		방법1) 첫번째 배열의 아이템 숫자는 입력받은 두 숫자의 합이라는 조건을 활용
		merge(nums1, m, nums2, n);
		for(int i=0; i<nums1.length; i++) {
			System.out.print(nums1[i]+" ");
		}
		
//		방법2) Arrays.sort()대신 크기를 비교해가며 배열에 작성하는 방법
		merge2(nums1, m, nums2, n);
		for(int i=0; i<nums1.length; i++) {
			System.out.print(nums1[i]+" ");
		}
		
//		방법3) 배열의 뒤에서 부터 값을 비교하며 입력하는 경우
		merge3(nums1, m, nums2, n);
		for(int i=0; i<nums1.length; i++) {
			System.out.print(nums1[i]+" ");
		}
	}
}
