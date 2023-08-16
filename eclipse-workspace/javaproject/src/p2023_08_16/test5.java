package p2023_08_16;

/*
 * 60과 24의 최대 공약수를 구하는 프로그램
 */
public class test5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		
		sb.append("24와 60의 최대공약수 =");
		for (int i=2; i<=60; i++) {
			if(24 % i == 0 && 60 % i == 0) {
				sb.append(i).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}
