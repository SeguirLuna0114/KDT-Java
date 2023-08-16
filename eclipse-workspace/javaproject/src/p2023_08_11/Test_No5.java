package p2023_08_11;

// 구구단 2~9단 까지 출력하는 프로그램
public class Test_No5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int dan=2; dan<10; dan++) {
			System.out.println("["+dan+"단]");
			for(int n=1; n<10; n++) {
				System.out.println(dan+"*"+n+"="+(dan*n));
			}
			System.out.println();
		}
	}
}