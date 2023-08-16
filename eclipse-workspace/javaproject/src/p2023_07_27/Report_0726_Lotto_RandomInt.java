package p2023_07_27;

import java.util.Arrays;

//1~45사이 숫자를 6개 추출하는 프로그램(단, 중복된 숫자는 1번만 출력)
class Report_0726_Lotto_RandomInt {

	public static void main(String[] args) {

		int num[] = new int[6];

		for (int i = 0; i < num.length; i++) {
			// Math.random()메소드를 활용하여 1~45사이 난수 발생
			num[i] = (int) (Math.random() * 45) + 1;
//			num[0]=5, num[1]=5,
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
					break;
				} // if end

			} // for end
		} // for end

		// 오름차순 정렬 : 버블정렬(자신의 옆자리에 있는 것과 비교)
		int temp = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		// Array.sort()메소드 : 자료형 배열 또는 객체배열의 요소를 오름차순으로 정렬 가능
		// 메소드 형식: sort(TypeOfArray[] arr)
		Arrays.sort(num); // 오름차순 정렬
						  // 숫자: 1, 2, 3...
						  // 문자: 사전순 정렬 a, b, c...

		for (int k : num) {
			System.out.print(k + "\t");
		}
	}
}

/*
 * 난수 발생 공식 난수 =(정수화) ((상한값-하한값+1)* Math.random()) + 하한값
 * 
 */