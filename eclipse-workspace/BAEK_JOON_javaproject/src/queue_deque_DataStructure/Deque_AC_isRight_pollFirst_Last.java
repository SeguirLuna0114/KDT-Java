package queue_deque_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
	Deque 삭제 연산
	- pollFirst() (또는 removeFirst()) : 맨 앞의 원소(배열로 치면 index 0)를 삭제한다.
	- pollLast() (또는 removeLast()) : 맨 뒤의 원소(배열로 치면 index (arr.length - 1))를 삭제
 */

/* 
 	AC는 정수 배열에 연산을 하기 위해 만든언어
 	두가지 함수 R(뒤집기)과 D(첫번째 숫자 버리기)가 있음
 	배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램
 	
 	각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력
 	만일, 에러가 발생한 경우에는 error를 출력
 	
 	R(배열을 뒤집는 과정)
 	=> Deque을 활용해서, 양방향에서 접근 가능한 "큐"를 활용
 	 isRight가 true라면, front가 가장 왼쪽 원소(index 0)라는 의미이므로 pollFisrt() 
 	 		  false라면 front를 맨 뒤 원소로 보고 pollLast()
 	 		  
 	덱에 원소가 없는데 D 연산을 하면 error을 출력
 	1. D 연산을 할 때마다 원소를 삭제하기 전에 삭제할 요소가 있는지 검사하기 위해 Deque의 size를 알아내는 방법
 		=> if(deque.size() == 0) 이라는 조건 사용
 	2. 일단 삭제를 해놓고, 예외가 발생하거나 특정 값을 던지면 error을 출력하도록 하는 방법
 */
public class Deque_AC_isRight_pollFirst_Last {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	// AC메소드 정의
	static void AC(String command, ArrayDeque<Integer> deque) {
		// isRight메소드 사용시, true가 반환되면 front가 가장 왼쪽이라는 의미
		boolean isRight = true;
		
		// toCharArray()로 입력받은 명령을 char타입으로 변형한 배열 형성
		for (char cmd : command.toCharArray()) {
			if (cmd == 'R') {
				// isRight변수의 결과값을 뒤집어서, 방향을 바꿔줌
				isRight = !isRight;	
				continue;
				// continue문: 더이상 아래의 코드를 실행하지 않고, for문으로 되돌아가서 다음번째 체크
			}
			
			// cmd == 'D'이고 isRight가 true인 경우 => 맨 앞이 front
			if(isRight) {
				// 만약 반환 된 맨 앞의 원소가 없을 경우에는 error를 출력하도록 하고, 함수 종료
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
					// 메소드를 종료하고, 해당 함수를 호출한 곳으로 돌아감
				}
			}
			
			// cmd == 'D'이면서 isRight가 false인 경우 => 맨 뒤가 front
			else {
				// 만일 반환 된 맨 뒤의 원소가 없는 경우 error를 출력하고 함수 종료
				if (deque.pollLast() == null) {
					sb.append("error/n");
					return;
					// 메소드를 종료하고, 해당 함수를 호출한 곳으로 돌아감
				}
			}
		}
		// 모든 함수들이 정상 작동했다면, deque의 남은 요소들은 출력문으로 만들어줌
		makePrintString(deque, isRight);
	}
	
	
	static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		// 여는 대괄호 먼저 StringBuilder에 저장
		sb.append('[');
		
		// 만일 출력할 원소가 1개 이상인 경우
		if(deque.size() > 0) {
			// isRight가 true인 경우 => 맨 앞이 front
			if (isRight) {
				// deque의 맨 첫번째 원소를 넘겨주며 삭제
				sb.append(deque.pollFirst());
				
				// 그 다음 원소부터 ,를 먼저 넘기고 deque의 원소를 하나씩 넘겨줌
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			// isRight가 false인 경우 => 맨 뒤가 front
			else {
				// deque의 맨 뒤에서 첫번째 원소를 넘겨주며 삭제
				sb.append(deque.pollLast());
				
				// 그 다음 원소부터 ,를 넘기고 deque의 원소를 뒤에서부터 하나씩 넘겨줌
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		// deque에 있는 모든 원소 출력한 후에는 ]로 닫아줌
		sb.append(']').append('\n');	// 개행으로 마무리
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 첫줄에 테스트 케이스의 개수T가 주어지고, T는 최대 100
		 각 테스트케이스의 첫째줄에는 수행할 함수p가 주어짐. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같음
		 다음 줄에는 배열에 들어있는 수의 개수n이 주어짐(0<=n<=100,000)
		 다음 줄에는 [x1...xn과 같은 형태로 배열에 들어있는 수가 주어짐(1<=x1<= 100)
		 전체 테스트케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않음
		*/
		
		System.out.println("첫줄에 테스트 케이스의 개수T(T는 최대 100)를 입력하고, 각 테스트케이스에 수행할 함수p와 수의 개수n(0<=n<=100,000)을 입력하세요.");
		
		// Deque 객체변수 선언(아직 주소값 할당X)
		ArrayDeque<Integer> deque;
		// StringTokenizer 클래스 객체변수 선언
		StringTokenizer st;
		
		// 입력받은 테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 반복문으로 테스트케이스 처리
		while (T-- >0) {
			
			// 테스트케이스에 수행할 함수p
			String command = br.readLine();
			// 배열에 들어있는 수의 개수n
			int n = Integer.parseInt(br.readLine());
			
			/* [x1...xn과 같은 형태로 배열에 들어있는 수가 주어짐(1<=x1<= 100)
			 	각 배열의 수를 []기호와 , 기호를 통해 파싱*/
			
			/*
			 * String inputArr = br.readLine();	// 입력받은 문자열 전체를 받아옴
			 * # subString()메소드를 사용하는 경우
			 * String[] strArr = inputArr.subString(1. inputArr.length-1).split(",");	// []기호를 빼고 인덱스 범위를 ,를 기준으로 구분
			 * # split()메소드를 사용하는 경우 첫번째 인자가 정규식에 걸려 빈 문자열을 반환함
			 * String[] strArr = inputArr.split("[\\[\\]\\,");
			 */
			
			// StringTokenizer클래스의 객체 생성 with 구분자 [ ] ,
			st = new StringTokenizer(br.readLine(),"[],");
			// ArrayDeque의 객체 생성
			deque = new ArrayDeque<Integer>();
			
			// deque에 배열 원소를 넣어줌
			for (int i=0; i<n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			// AC메소드 호출
			AC(command, deque);
		}
		System.out.println(sb);
	}
}
