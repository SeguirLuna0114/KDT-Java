package p2023_08_04;

/*
 * 키보드로 구구단 1개를 입력받아서, 구구단 1개를 출력하는 프로그램
 * 단, BufferedReader클래스를 활용하여 처리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	BufferedReader 클래스
	: Reader를 버퍼링하여 입력받은 데이터를 효율적으로 읽는 역할
	- Reader 클래스를 확장한 클래스. 문자 입력을 버퍼링하여 효율적으로 처리하는 기능을 제공
	
	o BufferedReader 클래스 객체생성 방법
	: BufferedReader 클래스와 InputStreamreader클래스를 함께 사용하는방법
	- System.in 또는 다른 InputStream을 읽기 위해 InputStreamReader를 사용
		-> BufferedReader의 생성자로 전달하여 BufferedReader를 초기화
	ex) BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
 */

public class CharStream_BufferedReader_gugudan {
	
	static void PrintGugudan_col(int Dan) {
		// 입력받은 단을 출력하는 메소드
		System.out.println("["+Dan+"단]");
		for(int i=1; i <10; i++) {
			System.out.println(Dan+"*"+i+"="+(Dan * i));
		}
		System.out.println(Dan+"단 출력 완료!");
		System.out.println();
	}
	
	static void PrintGugudan_row() {
		// 입력받은 단을 출력하는 메소드
		for(int Dan=2; Dan <=9; Dan++) {
			System.out.print("["+Dan+"단]"+'\t');
			for (int i=1; i<10; i++) {
				System.out.print(Dan+"*"+i+"="+(Dan * i)+'\t');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("구구단을 출력할 1개의 단을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// 입력받은 수(문자)를 정수로 변환
			int Dan = Integer.parseInt(br.readLine());
			
			// 입력받은 단을 아래로 출력하는 구구단
			PrintGugudan_col(Dan);
			
			// 입력받은 단을 오른쪽으로 출력하는 구구단
			PrintGugudan_row();
			
		} catch (IOException e) {
			System.out.println("숫자를 입력하세요.");
		}

	}

}
