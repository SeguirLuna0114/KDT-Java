package p2023_07_18;

// p187
// args : 프로그램 실행 시 전달된 인수(arguments)를 담는 배열
// 실행) run configuration -> arguments에 인수 입력 -> apply -> run
public class ArrayEx07_args {

	// main(String[] args): 입력한 인수가 문자열 배열에 저장됨
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 인수의 개수가 정확하지 않은 경우 오류처리 방법
		// args.length: 전달된 인수를 담은 배열(args)의 길이
		if (args.length != 2) {
			System.out.println("값의 수가 부족 합니다.");
			System.exit(0); // 프로그램을 강제 종료
		}	
		// System.exit(0): 프로그램 강제 종료 메소드
		// -'0': 정상적인 종료를 의미(이 코드 실행시, 프로그램 종료)
		
		// 입력된 인수(arguments)를 문자열로 저장
		// 숫자로 입력되어도, 문자로 변환되어 저장됨
		String strNum1 = args[0];
		// 만약 첫번째 입력된 값 = 10  => args[0]="10"
		String strNum2 = args[1];
		// 만약 두번째 입력된 값 = 20  => args[1]="20"
		
		// 문자를 숫자로 형변환: "20" ----> 20
		// Integer.parserInt(): 문자열을 정수로 변환하는 정적 메서드
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1+"+"+num2+"= "+result);
		
	}

}
