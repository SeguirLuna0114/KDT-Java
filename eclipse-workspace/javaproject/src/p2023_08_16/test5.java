package p2023_08_16;

/*
 * 60과 24의 최대 공약수를 구하는 프로그램
 */
public class test5 {
	
	static int GCD(int a, int b) {
		
		while(b != 0) {
			int r = a%b;
			
			a = b;
			b = r;
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("24와 60의 최대공약수");
		int n1 = 24;
		int n2 = 60;
		
		int GCD = GCD(n1, n2);
		System.out.println(GCD);
	}
}
