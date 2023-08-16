package p2023_07_14;

// 구구단(2~9단)을 열방향(세로방향)으로 출력하는 프로그램
public class Report_0714_gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2~9단까지 [n단]

		for (int dan1=2; dan1<=9; dan1++) {
			System.out.print("["+dan1+"단]\t");
		}
		System.out.println();
		
		for (int count=1; count<=9; count++) {
			for (int dan=2; dan<=9; dan++) {
//				if (count==1) {
//					System.out.print("["+dan+"단]\t");
//				} else {
					if (dan==9) {
						System.out.println(dan+"*"+count+"= "+(dan*count)+"\t");
					} else {
						System.out.print(dan+"*"+count+"= "+(dan*count)+"\t");
					}
				}
//			}
		}
		System.out.println("구구단 출력 완료!");
		
	}

}