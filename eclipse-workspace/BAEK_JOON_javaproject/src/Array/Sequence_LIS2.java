package Array;

import java.util.Scanner;

// 가장 긴 증가하는 부분수열을 구하는 프로그램2
// LIS(Longest Increasing Sub-sequence)

// -직전 숫자 대비 차이가 작은 값 위주로 비교
// 가장 긴 증가하는 수열 = 중점이 '증가'한다는 것과 '가장 길다'는 것
// => 증가한다 = 선행 원소 < 후행 원소 => 길다는 것은 제한된 수의 범위 내에서 "상호 원소값의 차이가 적어야 함"

class LowerBound {
		
	// 메소드
	public static int BinarySearch(int[] arr, int key) {
		
		// 인덱스 필드 초기값 형성
		int low = 0;
		int high = arr.length;
		
		// 현재 탐색값이 LisArr의 마지막 값보다 작거나 같은경우
		// Lower Bound 이분탐색 진행
		while (low < high) {
			int mid = (low+high) / 2;
			
			if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	public static int setLisArr(int key, int[] LisArr, int lengthOfLIS) {
		// 만약 key가 LisArr의 마지막 값보다 클 경우 추가
		if (LisArr[lengthOfLIS-1] < key) {
			lengthOfLIS++;
			LisArr[lengthOfLIS-1] = key;
		} else {
			// 현재 탐색값이 LisArr의 마지막 값보다 작거나 같은경우
			// BinarySearch()메소드 - Lower Bound 이분탐색 진행
//			int low1 = 0;
//			int high1 = lengthOfLIS;
			int index = LowerBound.BinarySearch(LisArr, key);
			LisArr[index] = key;
		}
		return lengthOfLIS;
	}
	
	public static void PrintArr(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			if (i==0) {
				System.out.print("{"+arr[i]);
			} else if (i== (arr.length-1)) {
				System.out.print(arr[i]+"}");
			} else {
				System.out.print(" "+arr[i]+" ");
			}
		}
	}
	
}


public class Sequence_LIS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("수열의 크기와 수열 요소를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int inputN = sc.nextInt();	// 첫번째 정수는 수열의 크기(SequenceLength)
		
		// 1차원 배열형성
		int[] SeqArr = new int[inputN];
		int[] LisArr = new int[inputN];
		
		// 입력받은 수열을 for문 활용하여 입력
		for (int i=0; i<inputN; i++) {
			SeqArr[i] = sc.nextInt();
		}
		
		// LisArr 초기값으로 첫번째 수열의 값을 할당
		LisArr[0] = SeqArr[0];
		int lengthOfLIS = 1;	// lengthOfLIS를 1로 초기화
		
		// 이분탐색 = 대치를 하는 과정에 탐색하는 값보다 큰 가장 가까운 원소를 찾는데 쓰임
		// SeqArr를 순회하면서 LIS를 찾음
		for (int i=1; i<inputN; i++) {
			int key = SeqArr[i];	// 현재 탐색값
			lengthOfLIS = LowerBound.setLisArr(key, LisArr, lengthOfLIS);
		}
		
		// 본래 코드
//		for (int i = 1; i < N; i++) {
//			int key = seq[i];
//			// 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다. 
//			if (LIS[lengthOfLIS - 1] < key) {
//				lengthOfLIS++;
//				LIS[lengthOfLIS - 1] = key;
//			} else {
//				// Lower Bound 이분탐색을 진행한다.
//				int lo = 0;
//				int hi = lengthOfLIS;
//				while (lo < hi) {
//					int mid = (lo + hi) / 2;
//					
//					if(LIS[mid] < key) {
//						lo = mid + 1;
//					}
//					else {
//						hi = mid;
//					}
//				}
//				LIS[lo] = key;
//			}
//		}
					
		//위 과정을 통해 나온 LisArr의 길이 출력
		System.out.println(lengthOfLIS);
		
		System.out.print("SeqArr= ");
		LowerBound.PrintArr(SeqArr);
		
		System.out.print("LisArr= ");
		LowerBound.PrintArr(LisArr);
	}
}
