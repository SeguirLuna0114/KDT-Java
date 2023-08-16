package p2023_07_20;

// p253~254
class Computer {
	
	// 주소값 전달에 의한 메소드 호출방식(Call by Reference방식)
	// 배열 values의 주소값을 전달받아 배열 요소들의 합 계산하는 함수
	// - 배열은 객체로 취급되기에, 메소드에 전달할 경우 실제 배열의 복사본X
	// 	 주소값이 전달됨 = 주소값 전달에 의한 호출
	int sum1(int[] values) {	// 정수형 배열이 매개변수
		int sum = 0;
		for (int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	
	// varargs(가변인자)방식: int ... values
	// - 메소드가 동일한 타입의 여러 인자를 받을 수 있도록 해줌
	// - 메소드 호출 시, 배열을 생성하거나 직접 전달할 필요 없이
	// 	 인자를 콤마(,)로 구분하여 전달 가능
	// - 가변인자들은 메소드 내에서 배열처럼 다룰 수 있음
	int sum2(int ... values) {
		int sum = 0;
		for (int i=0; i<values.length; i++) {
			sum += values[i];		// sum = sum + values[i]
		}
		return sum;
	}
	
}


public class ComputerEx_Methid_varargs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Computer클래스의 객체(mycom)생성
		Computer mycom = new Computer();
		
		// sum1 메소드 호출방식
		// 1. 배열변수를 생성하여 이를 메소드에 전달
		int[] values1 = {1, 2, 3};	// int형식의 배열변수 생성 -> 요소 초기화
		int result1 = mycom.sum1(values1);	// values1배열을 sum1메소드에 전달하여 호출
		System.out.println("result1: "+result1);
		
		// 2. 배열을 직접 메소드 호출시에 인라인으로 생성하여 전달
		int result2 = mycom.sum1(new int[] {1,2,3,4,5});
		// 데이터형식의 배열을 직접 인라인으로 작성시, new연산자를 사용하여 메모리에 할당
		System.out.println("result2: "+result2);

		// 가변인자를 매개변수로 사용 => 배열을 생성 or 인자를 쉼표로 구분해 전달 가능
		int result3 = mycom.sum2(1, 2, 3);	// 인자를 쉼표로 구분하여 전달
		System.out.println("result3: "+result3);
		
		int result4 = mycom.sum2(1, 2, 3, 4, 5);	// 인자를 쉼표로 구분하여 전달
		System.out.println("result4: "+result4);
		
	}

}
