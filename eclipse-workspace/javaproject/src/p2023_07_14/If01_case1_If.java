package p2023_07_14;

// If 문(조건문)
//      if(조건식){
//			조건식이 참인경우 실행될 문장;
//		}
public class If01_case1_If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		if 10 > 5 {}		// 조건식을 만들때 괄호()가 있어야 함
			
		if (10 > 5) {		// (조건식)이 참이기에, if문{}안의 내용 실행
			System.out.println("실행1");
		}
		
		// 실행되는 문장이 1줄인 경우에는 중괄호{} 생략가능O
		if (10 > 5) System.out.println("실행2");
		
		// 조건식에 true 또는 false를 적어서 무조건 실행/~실행 되게 할 수 있음
		if (true) {
			System.out.println("무조건 실행");
		}
		
		if (false) {
			System.out.println("실행 안됨");
		}
		
		// if문에 중괄호{}가 없으면, if문 바로 아래쪽 1줄만 if문의 적용을 받음
		if (10 > 30)
			System.out.println("실행 안됨");
			System.out.println("조건식의 적용을 받지 않고 실행됨");
		
	}

}
