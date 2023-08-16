package p2023_08_16;

import java.util.Random;
import java.util.TreeSet;

/*
 * 1~45사이의 숫자를 6개 추출 하는 프로그램
 * (단, 중복된 숫자는 1번만 출력 되도록 한다.) 
 */
public class test6 {

	/** Set 자료구조를 이용하여 중복된 숫자 나오지 않게 작성
	 * TreeSet클래스를 활용해 추출된 6개의 숫자를 오름차순 정렬
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TreeSet클래스 객체 생성
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		
		// Random클래스를 사용해 난수 발생
		Random rand = new Random();
		
		// for문 사용하여 "6개" 난수 발생
		for (int i=0, cnt=1; cnt<=6; i++) {
			int check_randN = rand.nextInt(45) + 1;
			
			// boolean add()메소드 사용하여 요소 추가
			if(treeset.add(check_randN)) {
				cnt++;	// 중복되지 않은경우 추가됨 => cnt 1 증가
			}
		}
		
		// treeset객체 바로 출력
		System.out.println(treeset);
		System.out.println();
	}
}