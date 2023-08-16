package p2023_08_01;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

// 1~45사이 정수중에서 6개의 숫자를 추출하는 로또프로그램
// - Set자료구조를 사용해서, 중복숫자가 나오지 않게 작성
// - TreeSet클래스를 활용해 추출된 6개의 숫자를 오름차순으로 정렬해서 출력
public class Report_0801_RandIntLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1~45사이 정수중에서 6개의 숫자를 추출하는 로또프로그램");

		// TreeSet클래스 객체 생성
		// TreeSet의 경우 기본적으로 오름차순 정렬됨
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		Random r = new Random();
		
		// for문 작성: for(초기화; 조건식; 증감식) {
		for (int i=0, cnt=1; cnt<=6; i++) {
			// Math.random()메소드를 활용하여 1~45사이 난수 발생
//			int check_randN = (int)(Math.random()*45)+1;
			
			// Random클래스를 활용하여 1~45사이 난수 발생
			int check_randN = r.nextInt(45)+1;
			
			// boolean add(E e): TreeSet에 요소 추가. 중복된 요소 허용X
			if(ts.add(check_randN)) {
				cnt++;
			} 
		}
		System.out.println(ts);
		System.out.println();
		
		// 생성한 난수 출력
		Iterator it = ts.iterator();
		// Iterator.hasNext()메소드: 가져올 데이터(요소)가 남아있을때만 true리턴
		while(it.hasNext()) {
			// Iterator.next()메소드: 다음 데이터(요소)를 1개씩 가져오는 메소드
			System.out.print(it.next()+"\t");
		}
	}

}
