package p2023_07_13;

//증감 연산자: ++, --
//++      1씩 증가   ++a(선행 처리) 	// a=a+1;
//					a++(후행 처리) 	// a=a+1;
//--      1씩 감소   --a(선행 처리)   	// a=a-1;
//					a--(후행 처리)  	// a=a-1;
//선행연산: 현재값에서 1증가/감소 하여 반환
//후행연산: 현재값을 반환한 후, 1증가/감소

public class Oper11_increNdecrement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=10, b=10;
		
		// 후행연산 => a= 10을 출력한 후, 1증가시켜 a=11로 할당
		System.out.println("a= " + (a++));	// a= 10
		System.out.println("a= " + a);		// a= 11
		
		System.out.println("a= " + (a--));	// a= 11
		System.out.println("a= " + a);		// a= 10
		
		// 선행연산 => b(10)의 값을 1증가시켜 b=11로 할당하고 이를 반환
		System.out.println("b= " + (++b));	// b= 11
		System.out.println("b= " + b);		// b= 11(이미 증가시킨 값임)
		
		System.out.println("b= " + (--b));	// b= 10
		System.out.println("b= " + b);		// b= 10(이미 증가시킨 값임)

	}

}
