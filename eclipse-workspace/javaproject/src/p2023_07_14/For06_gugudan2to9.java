package p2023_07_14;

public class For06_gugudan2to9 {

	// 구구단(2~9단)을 출력하는 프로그램을 작성하세요?
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int dan=2; dan<10; dan++) {		// 단
			System.out.println("["+dan+"단]");	// 단 title
			for (int i=1; i<10; i++) {
				System.out.println(dan+"*"+i+"= "+(dan*i));
			}
			System.out.println();				// 각 단 사이 간격
		}
		System.out.println("구구단 출력 완료!");
		
	}

}
