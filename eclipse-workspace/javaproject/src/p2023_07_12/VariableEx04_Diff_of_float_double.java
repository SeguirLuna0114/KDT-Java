package p2023_07_12;

public class VariableEx04_Diff_of_float_double {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		float var1 = 3.14;		// 컴파일 오류(float형은 끝에 f/F를 붙여야 함)
		float var2 = 3.14f;
		double var3 = 3.14;
		
		// 정밀도 테스트
		// float타입: 소수점 아래 7자리까지 정밀도를 가짐
		float var4 = 0.1234567890123456789f;
		// double타입: 소수점 아래 15자리까지 정밀도를 가짐
		double var5 = 0.1234567890123456789;
		
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);	// var4: 0.12345679 (소수점 아래 7번째 자리까지만 정확)
		System.out.println("var5: " + var5);	// var5: 0.12345678901234568 (소수점 아래 15번째 자리까지만 정확)
	
		// e사용하기
		double var6 = 3e6;	// e6: 10의 6승(10^6)
		float var7 = 3e6F;	// e6: 10의 6승(10^6)
		
		double var8 = 2e-3;	// e-3: 10의 -3승(10^-3, 0.1^3)
		
		System.out.println("var6: " + var6);	// var6: 3000000.0
		System.out.println("var7: " + var7);	// var7: 3000000.0
		System.out.println("var8: " + var8);	// var8: 0.002
	}

}
