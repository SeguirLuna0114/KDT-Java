package p2023_07_25;

// Integer.parseInt()메소드 : 문자열 -> 정수로 변환
// ex) int number = Integer.parseInt(numberStr);
import java.util.Scanner;

// 입력방법 : 전체 주민등록번호를 입력받음
// 계산방식 : 입력 주민등록번호를 정수배열로 반환 -> 각 요소와 정수배열 요소 곱&합
//			-> 
public class Report_0725_Validation_ID {
	
	static int[] StrToInt(String str) {
		// String문자를 문자 하나씩 구분
		String[] StrArr = str.split("");
		// 각 문자 -> 정수로 변환
		int[] IntArr = new int[6];
		
		for (int i=0; i<6; i++) {
			IntArr[i] = Integer.parseInt(StrArr[i]);
		}
		return IntArr;
	}
	
	// 주민번호 각 자리세 숫자를 곱하는 연산
	static int MultiAdd(int[] IntArr1, int[] IntArr2) {
				
		// 곱하는 메소드 사용
		int[] arr1 = new int[] {2,3,4,5,6,7};
		int[] arr2 = new int[] {8,9,2,3,4,5};
		
		int multiSum = 0;
		for (int i=0; i <6; i++) {
			int M1 = arr1[i]*IntArr1[i];
			int M2 = arr2[i]*IntArr2[i];
			multiSum += M1+M2;
		}
		return multiSum;
	}
	
	// 키보드로 주민번호 입력받을 경우, 유효한 주민번호인지 아닌지를 판별하는 프로그램
	// 주민번호 앞자리가 6자리가 아니면 메시지 출력
	// 주민번호 뒷자리가 7자리가 아니면 메시지 출력
	// 유효한 주민번호가 아니면 메시지 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민번호를 입력해주세요(ex. nnnnnn-nnnnnnn)");
		// 입력받은 전체 주민번호를 문자열로 받음
		String IDString = sc.nextLine();
		
		// 주민번호 앞, 뒷자리로 나눠서 확인
		String[] IDArr = IDString.split("-");
		if (IDArr.length != 2) {
			System.out.println("주민번호 형식이 잘못되었습니다.");
			return;
		}
		
		String IDStr1 = IDArr[0];
		String IDStr2 = IDArr[1];
		
		// 주민번호 앞자리가 6자리가 아니면 메시지 출력, 뒷자리가 7자리가 아니면 메시지 출력
		if (IDStr1.length() != 6) {
			System.out.println("주민번호 앞자리 6자리를 입력하세요.");
			return;
		} else if (IDStr2.length() !=7) {
			System.out.println("주민번호 뒷자리 7자리를 입력하세요.");
			return;
		}
		
		// 주민번호 뒷자리수 구분
		String IDString2 = IDStr2.substring(0, 6);	// 1~6번째 문자는 IDString2
		String IDSub = IDStr2.substring(6);		// 7번째 문자는 IDSub
		int SubN = Integer.parseInt(IDSub);
		
		// Stirng[] -> int[]
		int[] IntArr1 = StrToInt(IDStr1);
		int[] IntArr2 = StrToInt(IDString2);
		
		//주민번호 타당성 검사
		// 1. 주민번호 각 자리에 해당 숫자를 곱함
		int multiSum = MultiAdd(IntArr1, IntArr2);
		
		// 2. 곱한 결과를 11로 나누어서 나머지 구함
		int remain = multiSum % 11;
		
		// 3. 11에서 나머지 값을 뺀 후, "체크용 번호"와 비교해서 같으면 올바른 주민번호
		int result = 11 - remain;
		
		// 4. 만일 뺀 값이 10보다 큰 경우에는 10을 다시 나눠서 10보다 작을때까지 반복
		// (10보다 작다 = 일의자리 숫자 = (result % 10)수행
		if (result >= 10) {
			result %= 10;	// result = result % 10
		}
		
		// 주민번호 앞자리가 6자리가 아니면 메시지 출력, 뒷자리가 7자리가 아니면 메시지 출력
		if (result == SubN) {
			System.out.println("체크용 번호와 같음. 올바른 주민번호");
		} else if (result != SubN){
			System.out.println("체크용 번호와 다름. 틀린 주민번호");
		} else {
			System.err.println("똑바로 입력 하세요.");
		}
		
	}
}
