package p2023_08_02;

import java.util.*;

//1~45사이 정수중에서 6개의 숫자를 추출하는 로또프로그램
//- Set자료구조를 사용해서, 중복숫자가 나오지 않게 작성
//- TreeSet클래스를 활용해 추출된 6개의 숫자를 오름차순으로 정렬해서 출력

public class Report_0801_SetTest_RandInt_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
//		Set s = new HashSet();
		TreeSet s = new TreeSet();

		Random r = new Random();

		while (true) {
			n = r.nextInt(45) + 1; // 1 ~ 45 난수 발생
			s.add(n);
			if (s.size() == 6) {
				System.out.println(s);
				break;
			}
		}
	}

}
