package p2023_07_21;

// 자동 import 단축키: [Ctrl]+[Shift]+[o]
import java.util.Random;

// 난수 발생 방법  	1. Math.random()
//			 	2. Random클래스
public class RandomEx_importRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Random클래스를 활용하여 객체(r)생성
		Random r = new Random();
		
		// import없이 클래스 사용 : 클래스 전체경로를 사용하여 해당 클래스 참조
		// java.util 패키지의 Random 클래스를 사용하여 객체 생성
		java.util.Random r1 = new java.util.Random();
		// - 단, 1번만 불러오기에 좋은 방법은X
		
		// int nextInt()메소드: int 형태(정수형) 난수 생성(음수일 수도 있음)
		// int nextInt(int bound)메소드: 0~bound미만의 범위 내에서 정수형 난수 반환
		int n1 = r.nextInt(10);		// 0~9
		System.out.println("n1= "+n1);
		
		int n2 = r.nextInt(45)+1;	// 1~45사이의 난수 발생
		System.out.println("n2= "+n2);

		// 1~45사이 정수형태 난수 6번 출력
		for (int i=1; i<=6; i++) {
			System.out.print(r.nextInt(45)+1+"\t");
		}
		System.out.println();
		
		// Math.random()메소드를 활용하여 1~45사이 난수 발생
		int n3 = (int)(Math.random()*45) + 1;
		System.out.println("n3= "+n3);
		
		// 1~45사이 정수형태 난수 6번 출력
		for (int i=1; i<=6; i++) {
			System.out.print(((int)(Math.random()*45)+1)+"\t");
		}
		System.out.println();
		
		
	}

}
