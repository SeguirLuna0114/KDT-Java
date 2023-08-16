package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳 대소문자로 된 단어가 주어지면, 
// 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램
// 단, 가장 많이 사용된 알파벳이 여러개 존재하는 경우 ?을 출력. 대소문자 구별X

// 알고리즘
public class Most_Frequently_UsedAlphabet {
	
	// BufferedReader클래스 활용
	static void FrequentlyUsedAlphabet_num(String Str) {
		// 각 문자들의 빈도수를 나타내기 위한 배열을 선언
		int[] AlphabetArr = new int[26];	// 알파벳(영문자)의 개수는 26개
		
//		// BufferedReader클래스를 활용하여 입력받은 단어를 문자로 받아옴
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String Str = br.readLine();
		
		// 문자열을 검사하기 위해 첫문자부터 마지막문자까지 반복
		// 이때, 대소문자를 구별하지 X
		for (int i=0; i < Str.length(); i++) {
			// charAt()메소드를 활용하여 문자열을 하나의 문자로 받아오고 ASCII코드값으로 반환
			// 대문자의 범위(A(65) ~ Z(90)
			if (65 <= Str.charAt(i) && Str.charAt(i) <= 90) {
				// 해당 인덱스의 값 1 증가
				AlphabetArr[Str.charAt(i) - 65]++;
				// 대문자 A(65)값이 들어와도, AlphabetArr[0]의 값이 1증가되게 함
			}
			// 소문자의 범위(a(97) ~ z(122))
			else if (97 <= Str.charAt(i) && Str.charAt(i) <= 122) {
				// 해당 인덱스의 값 1 증가
				AlphabetArr[Str.charAt(i) - 97]++;
				// 소문자 A(97)값이 들어와도, AlphabetArr[0]의 값이 1증가되게 함
			}
		}
		// CompareMax()메소드를 활용하여 최대값 출력
		CompareMax(AlphabetArr);
	}
	
	// BufferedReader클래스 활용
	// charAt()메소드로 반환되는 값을 숫자가 아닌 '문자'와 비교해줘도 됨
	static void FrequentlyUsedAlphabet_str(String Str) {
		// 각 문자들의 빈도수를 나타내기 위한 배열을 선언
		int[] AlphabetArr = new int[26];	// 알파벳(영문자)의 개수는 26개
		
//		// BufferedReader클래스를 활용하여 입력받은 단어를 문자로 받아옴
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String Str = br.readLine();
		
		// 문자열을 검사하기 위해 첫문자부터 마지막문자까지 반복
		// 이때, 대소문자를 구별하지 X
		for (int i=0; i < Str.length(); i++) {
			// charAt()메소드를 활용하여 문자열을 하나의 문자로 받아오고 ASCII코드값으로 반환
			// 대문자의 범위(A(65) ~ Z(90)
			if ('A' <= Str.charAt(i) && Str.charAt(i) <= 'Z') {
				// 해당 인덱스의 값 1 증가
				AlphabetArr[Str.charAt(i) - 'A']++;
				// 대문자 A(65)값이 들어와도, AlphabetArr[0]의 값이 1증가되게 함
			}
			// 소문자의 범위(a(97) ~ z(122))
			else if ('a' <= Str.charAt(i) && Str.charAt(i) <= 'z') {
				// 해당 인덱스의 값 1 증가
				AlphabetArr[Str.charAt(i) - 'a']++;
				// 소문자 A(97)값이 들어와도, AlphabetArr[0]의 값이 1증가되게 함
			}
		}
		
		// CompareMax()메소드를 활용하여 최대값 출력
		CompareMax(AlphabetArr);
	}
	
	
	
	// 배열 원소들의 값을 비교하여 가장 큰 값을 갖는 인덱스의 문자 출력하는 메소드
	static void CompareMax(int[] AlphabetArr) {
		//최대값을 저장할 max변수와 출력할 문자 변수 charAlphaber를 선언
		int max = -1;	// 정수 배열의 초기값은 0으로 되어있기에, -1로 초기값 선언
		char charAlphabet = '?';
		
		// 입력받은 정수배열 AlphabetArr를 순회하며 최대값 찾는 반복문
		// AlphabetArr.length 대신 26(배열의 크기)를 적어도 됨
		for (int i=0; i < AlphabetArr.length; i++) {
			// 해당 원소의 값이 max보다 클 경우, 해당 원소값을 max로 대치
			if (AlphabetArr[i] > max) {
				max = AlphabetArr[i];
				// charAlphabet의 문자를 해당 인덱스에 대응하는 알파벳으로 대치
				charAlphabet = (char)(i+65);	// 대문자로 반환
				// char형 타입의 변수(charAlphabet)에 int와 char을 연산하여 저장시,
				// (char)을 붙여 캐스팅해줌(해당 인덱스값 -> ASCII코드 문자로 변환)
			}
			// 만일 배열 원소값이 max값과 같을 경우 최대 문자 개수가 2개이상이기에, ? 출력
			else if (AlphabetArr[i] == max) {
				charAlphabet ='?';
			}
		}
		// 모든 알파벳배열을 순회한 후 최대값 문자 출력
		System.out.println(charAlphabet);
	}
	
	

	// 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
	// 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("알파벳 대소문자로 이루어진 단어를 입력하세요.(단, 단어의 길이는 1,000,000을 넘지 않는다)");
		
		// BufferedReader클래스를 활용하여 입력받은 단어를 문자로 받아옴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Str = br.readLine();
		
		// charAt()메소드로 반환되는 ASCII코드값을 숫자로 비교
		// FrequentlyUsedAlphabet_num(String Str)메소드 활용
		FrequentlyUsedAlphabet_num(Str);
		
		// charAt()메소드로 반환되는 값을 숫자가 아닌 '문자'와 비교해줘도 됨
		// FrequentlyUsedAlphabet_str(String Str)메소드 활용
		FrequentlyUsedAlphabet_str(Str);
	}

}
