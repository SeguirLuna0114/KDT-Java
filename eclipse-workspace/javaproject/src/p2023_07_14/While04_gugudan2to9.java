package p2023_07_14;

// while문 (반복문)
// -조건식은 True/False 값을 가져야 함
//	while(조건식){	// 조건식에 따라 반복여부 결정. 
//	  반복 실행할 문장;
//	}
public class While04_gugudan2to9 {

	// while문을 이용하여 구구단(2~9단)까지 출력하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Dan=2;					// 초기값 설정
		while (Dan<10) {			// 단수 조건식
			System.out.println("["+Dan+"단]");
			int count=1;			// 증감수 초기값 설정
			while (count < 10) {	// 조건식
				System.out.println(Dan+"*"+count+"= "+(Dan*count));
				count+=1;			// 증감식
			}
			Dan+=1;					// 증감식
			System.out.println();
		}
		
		
	}

}
