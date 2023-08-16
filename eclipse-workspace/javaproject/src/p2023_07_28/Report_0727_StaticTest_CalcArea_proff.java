package p2023_07_28;

import java.text.DecimalFormat;

class Report_0727_StaticTest_CalcArea_proff {
	public static void main(String[] args) {

		int r = 5;
		double l; // 원주(원둘레)
		double s; // 원의 면적
		double v1; // 구의 표면적
		double v; // 구의 체적(부피)

		l = 2 * r * Math.PI;
		s = r * r * Math.PI;
		v1 = 4 * Math.PI * r * r;
		v = 4.0 / 3 * Math.PI * r * r * r; // pow(r,3)

		DecimalFormat df = new DecimalFormat("###.00");

		System.out.println("원주 : " + l);
		System.out.println("반지름이 " + r + "인 원의 면적 " + s);
		System.out.println("구의 표면적 : " + v1);
		System.out.println("구의 체적 :" + v);
		System.out.println();

		System.out.println("원주 : " + df.format(l));
		System.out.println("반지름이 " + r + "인 원의 면적 " + df.format(s));
		System.out.println("구의 표면적 : " + df.format(v1));
		System.out.println("구의 체적 :" + df.format(v));
		System.out.println();

//	System.out.printf("%f", l);
		System.out.printf("%.2f", l);
		System.out.println();
		System.out.format("%.2f", s);
		System.out.println();
		System.out.format("%.2f", v1);
		System.out.println();
		System.out.format("%.2f", v);
	}
}