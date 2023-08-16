package sortAlgorithm;

/*
	카운팅 정렬 / 계수정렬(Counting Sort)
	: 각 요소의 발생 횟수를 세어서 정렬하는 정렬 알고리즘
	- 카운팅 정렬은 각 배열의 원소끼리 직접 비교X -> 인덱스 값을 갖고 위치를 찾아가는 것
	
	* 카운팅 정렬의 주요 아이디어
	* "array -> counting -> counting value-1 -> result[value-1]
	1. 정렬하려는 배열의 최대 값 범위를 기반으로 카운팅 배열 생성
	: 카운팅 배열 = 각 값(요소)의 개수가 담겨있는 배열(각 요소 발생횟수가 저장된 배열)
	2. 카운트 배열을 사용해 누적 카운트 배열을 생성(카운트 배열의 값들을 누적합으로 설정)
		- 누적합을 통해 각 값보다 작거나 같은 값의 총 개수를 나타냄
		- 정렬된 결과 배열에서 각 값의 위치를 알 수 있음: 카운팅 배열의 각 값은 시작점-1을 알려줌
	3. 정렬 결과 배열 생성
		- 원래 배열을 순회하며 각 요소를 그 값의 누적 카운트 배열을 참조해 정렬된 위치에 배치
		- 해당 값을 누적 카운트 배열에서 하나씩 감소
 */
public class Counting_Sort {
	
	// 카운팅 정렬에 사용된 각 수열 및 배열 출력
	static void printMethod(int[] array) {
		
		for (int i=0; i<array.length; i++) {
			if (i%10 == 0) {
				// 10번째 인덱스에서 행 바꿔 출력
				System.out.println();
			}
			System.out.print(array[i]+"\t");
		}
		System.out.println("\n\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// array 크기(수열의크기)는 100개로 하고, 수의 범위는 0~30으로 하자
		int[] array = new int[100];		// 수열의 원소:100개
		int[] counting = new int[31];	// 수의 범위: 0~30
		int[] result = new int[100];	// 정렬 될 배열
		
		// 수열에 0~30까지의 난수를 입력
		for (int i=0; i < array.length; i++) {
			array[i] =(int)(Math.random()*31);	// 0이상~31미만(=> 정수는 0이상 30이하)
		}
		
		// Counting sort(카운팅 정렬)
		// 1. 정렬하려는 배열의 최대 값 범위를 기반으로 카운팅 배열 생성
		for (int i=0; i<array.length; i++) {
			// 각 array의 value값을 index로 하는 counting배열 값 1 증가
			// => 각 값(요소)의 발생횟수를 담은 카운팅 배열 생성
			counting[array[i]]++;
		}
		
		// 2. 카운트 배열을 사용해 누적 카운트 배열을 생성(카운팅 배열의 각 값은 시작점-1)
		for (int i=1; i < counting.length; i++) {
			// 카운트 배열의 값들을 누적합으로 설정
			counting[i] += counting[i-1];
		}
		
		// 3. 원래 배열을 순회하며 각 요소를 그 값의 누적 카운트 배열을 참조해 정렬된 위치에 배치
		for (int i=array.length-1; i >=0; i--) {
			/*
			 *  i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤 
			 *  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
			 */
			int value = array[i];
			counting[value]--;		// 카운팅 배열의 각 값은 시작점-1
			
			result[counting[value]] = value;
		}
		
		
		/* 각 수열 및 배열의 값들을 출력 */
		// 초기 수열(array) 출력
		System.out.println("array[]");
		printMethod(array);
		
		// Counting배열(counting) 출력
		System.out.println("counting[]");
		printMethod(counting);
		
		// 정렬된 배열(result) 출력
		System.out.println("result[]");
		printMethod(result);
	}
}
