package p2023_07_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 369게임
public class ExSelf_genexpr_369 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("369게임\n숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();	// 사용자가 입력한 숫자
		
		// 1~사용자입력수까지 숫자 리스트 생성
		for (int i=1; i<=num; i++) {
			if (i%10==0) {
				if (i%3==0) {
					System.out.println("짝짝");
				} else {
					System.out.println(i);
				}
			} else {
				if (i%3==0) {
					System.out.print("짝  ");
				} else {
					System.out.print(i+"  ");
				}
			}
		}
		
		// switch문으로 작성
//		for (int i=1; i<=num; i++) {
//			switch
//		}
//		
	}

}
