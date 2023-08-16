package p2023_07_12;
// 교환 알고리즘

public class VariableEx01_ExchangeValue {
	// 교재 p53
	// x, y 변수의 값을 서로 교환하는 예제
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 3;
		int y = 5;
		System.out.println("x: "+x + ", y: "+y);
		System.out.println();
		
		//임시변수 temp를 활용하여 변수 값 교환
		int temp = x;	// temp = 3
		x = y;			// x = 5
		y = temp;		// y = temp = 3
		System.out.println("x: "+x + ", y: "+y);

	}

}
