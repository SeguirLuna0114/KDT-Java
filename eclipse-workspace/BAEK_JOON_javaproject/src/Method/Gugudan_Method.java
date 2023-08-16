package Method;

import java.util.Scanner;

// 클래스를 같은 패키지 내에서만 사용 가능
class Gugudan_Arr {
	
	// 정적 메소드 - 입력값을 넣으면 값에 해당하는 구구단을 배열에 저장
	public static int[] calculate(int Dan) {
		// 입력한 단수에 따른 구구단 값을 배열에 저장
		int[] result = new int[9];
		
		for (int i=0; i<result.length; i++) {
			result[i] = Dan * (i+1);
		}
		return result;
	}
	
	public static int[][] AllCalculate(int Dan) {
		// 2단부터 입력단수까지 구구단 값을 배열에 저장
		int[][] result = new int[Dan-1][9];	// Dan-1행 9열 배열
		
		// 2~9단
		for(int i=0; i<Dan-1; i++) {
			result[i] = calculate(i+2);
		}
		return result;
	}
	
	
	// 배열을 출력하는 정적 메소드
	public static void print(int[] Arr) {
		for (int i=0; i<Arr.length; i++) {
			System.out.print(Arr[i]+"\t");
		}
		System.out.println();
	}
	
	// 2차원 배열 출력하는 정적 메소드
	public static void printAll(int[][] Arr) {
		for (int i=0; i<Arr.length; i++) {
			print(Arr[i]);
		}
		System.out.println();
	}
}

public class Gugudan_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("출력할 단을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 입력받은 단에 관련한 배열 출력
		int[] NDanArray = Gugudan_Arr.calculate(N);
		Gugudan_Arr.print(NDanArray);
		
		System.out.println();
		
		// 2~입력한 단까지 구구단 값을 2차원 배열에 저장하고 출력
		int[][] allGugudan = Gugudan_Arr.AllCalculate(N);
		Gugudan_Arr.printAll(allGugudan);

	}

}
