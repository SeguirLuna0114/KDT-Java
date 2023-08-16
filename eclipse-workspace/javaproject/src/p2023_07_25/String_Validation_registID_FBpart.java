package p2023_07_25;

// 유효성검사 : 데이터나 정보가 주어진 규칙, 조건 또는 목적에 부합하는지를 확인하는 과정
// 프로그래밍에서 조건문을 사용: If문을 사용하여 인자의 유효성 검사 가능
import java.util.Scanner;

//문자열 관련 클래스 - String, StringBuffer, StringTokenizer
// substring()메소드 : 문자열에서 특정 범위에 해당하는 "부분" 문자열을 추출하는 역할
public class String_Validation_registID_FBpart {

	// 키보드로 앞/뒤주민번호를 입력받고, 남자인지 여자인지 판별하는 프로그램
	// 단, 주민번호 앞자리는 6자리, 뒷자리는 7자리인지 유효성 검사를 실행
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		try {
			// 유효성 검사
			System.out.println("주민번호를 앞자리를 해주세요?");
			// String클래스의 메소드를 활용하기 위해 nextLine()메소드로 한 줄을 문자형태로 입력받음
			String IdString1 = sc.nextLine();
			
			// 주민번호 뒷자리를 입력받음
			System.out.println("주민번호 뒷자리를 입력 하세요?");
			String IdString2 = sc.nextLine();
			
			// substring()메소드를 활용하여 주민번호 뒷자리 첫번째문자 추출
			String gender = IdString2.substring(0, 1);	// 인덱스=0인 첫번째 문자 추출
			// 뒷자리를 입력하지 않았을 경우, 예외발생 가능
			// 예외가 발생되면, 아래의 코드는 실행되지 않고, catch문으로 이동
			
			if (IdString1.equals("")) {
				System.out.println("주민번호 앞자리를 입력 하세요.");
			} else if (IdString1.length() != 6){
				System.out.println("주민번호 앞자리 6자리를 입력하세요.");
			} else if (IdString2.equals("")) {
				System.out.println("주민번호 뒷자리를 입력 하세요.");
			} else if (IdString2.length() != 7) {
				System.out.println("주민번호 뒷자리 7자리를 입력하세요.");
			} else if (gender.equals("1") || gender.equals("3")) {
				System.out.println("남자 입니다.");
			} else if (gender.equals("2") || gender.equals("4")) {
				System.out.println("여자 입니다.");
			} else {
				System.out.println("똑바로 입력 하세요.");
			}
			
			// 삼항연산자 활용하는 방법
			if (IdString1.equals("")) {
				System.out.println("주민번호 앞자리를 입력 하세요.");
			} else if (IdString1.length() != 6){
				System.out.println("주민번호 앞자리 6자리를 입력하세요.");
			} else if (IdString2.equals("")) {
				System.out.println("주민번호 뒷자리를 입력 하세요.");
			} else if (IdString2.length() != 7) {
				System.out.println("주민번호 뒷자리 7자리를 입력하세요.");
			} else {
				String genderMessage = (gender.equals("1") || gender.equals("3")) 
						? "남자 입니다." : ((gender.equals("2") || gender.equals("4"))
								? "여자 입니다." : "똑바로 입력 하세요.");
				System.out.println(genderMessage);
			}
			
		} catch (Exception e) {
			System.out.println("잘못된 정보 입니다.");
		}
		

	}

}
