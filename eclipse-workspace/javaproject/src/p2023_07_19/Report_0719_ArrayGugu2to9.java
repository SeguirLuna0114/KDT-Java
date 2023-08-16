package p2023_07_19;

public class Report_0719_ArrayGugu2to9 {

	// 구구단(2~9단)의 연산결과를 2차원 배열에 저장
	// 배열에 저장된 결과를 이용하여 구구단을 출력하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2차원 배열
		int[][] Gugudan = new int[8][9];
		
		int Dan=2;

		for (int row=0; row <8; row++) {
			for (int col=0; col <9; col++) {
				if (col==0) {
					Gugudan[row][col] = Dan*1;
				} else {
					Gugudan[row][col] = Dan*(col+1);
				}
			}
			Dan++;
		}
		
		int Dan2=2;
		for (int row=0; row <8; row++) {
			for (int col=0; col <9; col++) {
				if (col==0) {
					System.out.print(Dan2+"*"+(col+1)+"="+Gugudan[row][col]+"\t");
				} else {
					System.out.print(Gugudan[row][col]+"\t");
				}
			}
			System.out.println();
			Dan2++;
		}
		
	}

}
