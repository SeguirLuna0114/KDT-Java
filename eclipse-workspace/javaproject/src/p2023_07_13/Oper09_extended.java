package p2023_07_13;

// 확장 대입 연산자: +=, -=, *=, /=, %=
//ex)   a+=b;	// a = a + b;
//		a-=b; 	// a = a - b;
//		a*=b; 	// a = a * b;
//		a/=b; 	// a = a / b;
//		a%=b;	// a = a % b;
public class Oper09_extended {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10, b = 3;
		System.out.println("a+=b => a= "+(a+=b));	// 10+3=13
		System.out.println("a-=b => a= "+(a-=b));	// 13-3=10
		System.out.println("a*=b => a= "+(a*=b));	// 10*3=30
		System.out.println("a/=b => a= "+(a/=b));	// 30/3=10
		System.out.println("a%=b => a= "+(a%=b));	// 10%3=1
		
	}

}
