package basic;

/**
 *  Output numbers from 1 to x.
 *  If the number is divisible by 3, replace it with "Fizz"
 *  If it is divisible by 5, replace it with "Buzz"
 *  If it is divisible by 3 and 5, replace it with "FizzBuzz"
 */
public class Fizz3Buzz5 {
	
	static StringBuilder sb;

//	방법1) 알고리즘에 따라 구현한 메소드
	static void FizzBuzz(int x) {
		
		sb = new StringBuilder();
		
		// 1 to x
		for(int i=1; i<= x; i++) {
			
			// 3의 배수이면서 5의 배수인 경우
			if(i%3 == 0 && i%5 == 0) {
				sb.append("FizzBuzz").append('\n');
			}
			
			// 3의 배수인 경우
			else if(i%3 == 0) {
				sb.append("Fizz").append('\n');
			}
			
			// 5의 배수인 경우
			else if(i%5 == 0) {
				sb.append("Buzz").append('\n');
			}
			
			// 그 외의 숫자
			else {
				sb.append(i).append('\n');
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		알고리즘에 따라 구현한 메소드
		FizzBuzz(16);
		System.out.println(sb);
	}
}
