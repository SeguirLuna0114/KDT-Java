package p2023_07_27;

import java.text.DecimalFormat;

// 반지름(r)이 5인 경우 다음을 구하는 프로그램(단, 결과는 소수점 2째자리까지만 출력)
// DecimalFormat클래스를 이용해서 해결

class CalcCircle {
	
	static double Circular(int radius) {
		System.out.println("원주(원 둘레): 2*PI*r");
		return 2 * Math.PI * radius;
	}
	
	static double CircleArea(int radius) {
		System.out.println("원의 면적: PI*r*r");
//		return Math.PI * radius * radius;
		return Math.PI * Math.pow(radius, 2);
	}
	
}

class CalcSphere {
	
	static double SphereArea(int radius) {
		System.out.println("구의 표면적: 4*PI*r*r");
//		return 4* Math.PI * radius * radius;
		return 4* Math.PI * Math.pow(radius, 2);
	}
	
	static double SphereVolume(int radius) {
		System.out.println("구의 표면적: 4/3*PI*r*r*r");
//		return (double)4/3 * Math.PI * radius * radius * radius;
		return (double)4/3 * Math.PI * Math.pow(radius, 3);
	}
	
}


public class Report_0727_CalculateArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("반지름 값을 입력해주세요?");
		
		int radius = 5;
		// DecimalFormat클래스를 사용하여 출력값 소수점 이하 2째자리까지 지정
		DecimalFormat df = new DecimalFormat("#,###.00");

		// 메소드 호출	
		System.out.println(df.format(CalcCircle.Circular(radius)));
		System.out.println(df.format(CalcCircle.CircleArea(radius)));
		System.out.println(df.format(CalcSphere.SphereArea(radius)));
		System.out.println(df.format(CalcSphere.SphereVolume(radius)));
		
		System.out.println();
		
		// printf()메서드 - 형식 지정 문자열을 사용해 원하는 형식으로 출력
		// %.2f: 소수점 아래 둘째자리까지 출력되게 처리
		System.out.printf("%.2f", CalcCircle.Circular(radius));
		System.out.println();
		System.out.printf("%.2f", CalcCircle.CircleArea(radius));
		System.out.println();
		System.out.printf("%.2f", CalcSphere.SphereArea(radius));
		System.out.println();
		System.out.printf("%.2f", CalcSphere.SphereVolume(radius));
		System.out.println();
		
	}

}
