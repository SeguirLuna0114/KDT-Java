package p2023_07_26;

// 1~45사이 숫자를 6개 추출하는 프로그램(단, 중복된 숫자는 1번만 출력)
class Random {
	
	// Math.random()메소드를 활용하여 1~45사이 난수 발생
	static void RandPrint() {
		// 1~45사이 숫자를 6개 넣을 int배열 선언
		int[] RandArr = new int[6];
		
		// 인덱스 0,1에 값을 미리 할당
		RandArr[0] = (int)(Math.random()*45)+1;		
		for (int i=1; i<6; i++) {
			// 중복값은 배열에 포함X
			int rand;	// 발생시킨 난수
			boolean Duplicate;	// 중복되는지 검사
			// 중복이 발생하지 않을 때까지 난수를 다시 생성
			do {
				rand = (int)(Math.random()*45)+1;
				Duplicate = true;
				
				// 중복 확인
				for (int j=0; j<i; j++) {
					if (rand != RandArr[j]) {
						Duplicate = false;
						break;
						// 해당 반복문 실행 중지
					}
				}
			} while (Duplicate);	// 중복되지 않을 때까지
			RandArr[i] = rand;		// 중복되지 않기에 할당
		}
		PrintArr(RandArr);
	}
	
	static void PrintArr(int[] arr) {
		// 배열 출력
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
	
}


public class Report_0726_RandomInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random.RandPrint();
	}

}
