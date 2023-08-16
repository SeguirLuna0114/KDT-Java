package p2023_07_12;
// 지역변수 관련 예제

public class VariableEx02_localVariable {
	// 교재 p55
	// 변수의 범위 : 지역 변수(local variable)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//메인 메소드 안에서 정의된 지역변수 v1
		int v1 = 15;
		
		//if문 안에서 정의된 지역변수 v2는 if문 안에서만 사용될 수 있음
		if (v1 > 10) {
			int v2;				// v2 : 지역변수
			v2 = v1 - 10;
		}
		
//		int v3 = v1 + v2 + 5;	// 오류 발생

	}

}
