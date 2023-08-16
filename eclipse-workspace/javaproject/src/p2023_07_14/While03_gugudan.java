package p2023_07_14;

// while문 (반복문)
// -조건식은 True/False 값을 가져야 함
//	while(조건식){	// 조건식에 따라 반복여부 결정. 
//	  반복 실행할 문장;
//	}
import java.util.Scanner;

public class While03_gugudan {

	// 키보드로 입력한 구구단 1개단을 while문으로 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("원하는 단을 입력하세요?");
		Scanner sc = new Scanner(System.in);
		int inputD = sc.nextInt();
		
		int count = 1;	// 반복횟수(증감될 것)
		System.out.println("["+inputD+"단]");
		while (count < 10) {
			System.out.println(inputD+"*"+count+"= "+(inputD*count));
			count+=1;
		}
		System.out.println("구구단 완료");
		
		
	}

}
