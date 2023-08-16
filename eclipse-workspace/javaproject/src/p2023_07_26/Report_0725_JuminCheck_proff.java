package p2023_07_26;

import java.io.InputStream;
import java.util.Scanner;

// 입력방법 : 주민번호 앞/뒷자리를 각각 입력받음
// 계산방식 : 주민번호 각 숫자를 직접 해당 인수와 곱함 => 곱셈 결과의 합 계산
//			-> 11로 나누어 나머지를 구한 다음, 이 결과를 마지막숫자와 바교
public class Report_0725_JuminCheck_proff {

	// 주민번호 타당성 검사하는 메소드
	public static boolean juminCheck(String jumin) {
		// jumin = "9010101234567";
		int total = 0;
		int total2;

		// total += Integer.parseInt(jumin.substring(0, 1)) * 2;
		// total += Integer.parseInt(jumin.substring(1, 2)) * 3;
		// total += Integer.parseInt(jumin.substring(2, 3)) * 4;
		// total += Integer.parseInt(jumin.substring(3, 4)) * 5;
		// total += Integer.parseInt(jumin.substring(4, 5)) * 6;
		// total += Integer.parseInt(jumin.substring(5, 6)) * 7;
		// total += Integer.parseInt(jumin.substring(6, 7)) * 8;
		// total += Integer.parseInt(jumin.substring(7, 8)) * 9;
		// total += Integer.parseInt(jumin.substring(8, 9)) * 2;
		// total += Integer.parseInt(jumin.substring(9, 10)) * 3;
		// total += Integer.parseInt(jumin.substring(10, 11)) * 4;
		// total += Integer.parseInt(jumin.substring(11, 12)) * 5;

		int[] mul = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };

		// 주민번호 앞 12자리에 해당하는 숫자를 각 자리 가중치와 곱하여 total에 누적
		for (int i = 0; i <= 11; i++) {
			total += Integer.parseInt(jumin.substring(i, i + 1)) * mul[i];
		}

		// 누적값을 11로 나눈 나머지
		total %= 11; // total = total % 11;
		// 11에서 나머지 값을 뺀 연산을 total2에 저장
		total2 = 11 - total;
		
		// 만일 total2가 10 이상이라면, 일의자리 숫자(total2 % 10)로 변환하여
		// total2에 저장
		if (total2 > 9)
			total2 = total2 % 10;

		// total2와 주민번호 마지막 숫자가 일치하는지 확인
		if (total2 != Integer.parseInt(jumin.substring(12, 13))) {
			return false; // 체크용 번호와 일치하지 않을때
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JuminCheck01 jc = new JuminCheck01();

		InputStream is = System.in;
		Scanner sc = new Scanner(is);

		System.out.println("주민번호 앞자리를 입력 하세요?");
		String jumin1 = sc.next(); // 900101
		System.out.println("주민번호 뒷자리를 입력 하세요?");
		String jumin2 = sc.next(); // 1234567

		if (jumin1.length() != 6) {
			System.out.println("주민번호 앞자리는 6자리 입력");
		} else if (jumin2.length() != 7) {
			System.out.println("주민번호 뒷자리는 7자리 입력");
		} else if (!juminCheck(jumin1 + jumin2)) {
			System.out.println("잘못된 주민번호 입니다.");
		} else {
			System.out.println("올바른 주민번호 입니다");
		}

	}

}
