package queue_deque_DataStructure;

import java.util.ArrayDeque;
import java.util.Scanner;
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
public class Deque_AC_isRight_pollFirst_Last2 {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	// AC메소드 정의
	static void AC(String command, ArrayDeque<Integer> deque) {
		// isRight변수로 맨 앞인지 뒤인지 체크하는 변수 선언
		boolean isRight = true;
		
		// tocharArray()로 입력받은 명령을 char타입으로 변형한 배열 형성
		for(char cmd : command.toCharArray()) {
			if (cmd == 'R') {
				// isRight변수의 결과값을 뒤집어서 방향을 전환
				isRight = !isRight;
				continue;
				// continue문 : 더이상 아래의 코드를 실행하지 않고, for문으로 돌아가서 다음 실행
			}
			
			// cmd == 'D'이면서 isRight가 true인 경우
			if(isRight) {
				// 만일 반환된 맨 앞의 원소가 없는 경우에는 error를 출력하고 함수 종료
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
					// 해당 실행중인 메소드를 종료하고, 해당 메소드를 호출한 곳으로 돌아감
				}
			}
			// cmd == 'D'이면서 isRight가 false인 경우
			else {
				// 만일 반환된 맨 뒤의 원소가 없는 경우 error를 출력하고 함수 종료
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
					// 해당 메소드를 종료하고 해당 함수를 호출한 곳으로 돌아감
				}
			}
		}
		// 모든 함수들이 정상 작동한다면, deque의 남은 요소들을 모두 출력
		makePrintString(deque, isRight);
	}
	
	
	// deque의 모든 요소들을 출력하는 메소드
	static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		// 여는 대괄호 먼저 StringBuilder에 저장
		sb.append('[');
		
		// 출력할 원소가 1개이상 존재하는 경우
		if (deque.size() > 0) {
			// isRight=true인 경우 => 맨 앞이 front
			if (isRight) {
				// deque의 맨 앞의 첫번째원소를 넘겨주며 삭제
				sb.append(deque.pollFirst());
				
				// 그 다음 원소부터 ,를 먼저 넘기고 deque의 원소를 맨 앞에서부터 하나씩 넘겨줌
				while(!deque.isEmpty()) {
					sb.append(',').append(' ').append(deque.pollFirst());
				}
			} else {
				// isRight=false인 경우 => 맨 뒤가 front
				// deque의 맨 뒤 원소부터 넘겨주며 삭제
				sb.append(deque.pollLast());
				
				// 그 다음 원소부터 ,를 넘기고 deque의 원소 맨 뒤부터 하나씩 넘겨주며 삭제
				while(!deque.isEmpty()) {
					sb.append(',').append(' ').append(deque.pollLast());
				}
			}
		}
		// 출력할 원소가 남지 않은 경우 ]로 닫아주고 개행문자로 마무리
		sb.append(']').append('\n');
	}
	
	
	public static void main(String[] args) {
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
		// StringTokenizer클래스 객체변수 선언
		StringTokenizer st;
		
		// 입력받은 테스트케이스 개수
		int T = sc.nextInt();
		
		// 반복문으로 테스트케이스 처리
		while(T-- > 0) {
			
			// 테스트 케이스에 수행할 함수p
			String command = sc.next();
			// 배열에 들어있는 수의 개수n
			int n = sc.nextInt();
			
			/*
			 *  [a,b,c,...,x] 중 구분해야 할 것은 대괄호([, ])와 반점(,) 이다.
			 *  StringTokenizer로 여러 구분자를 사용 하고 싶다면
			 *  구분할 문자들을 합쳐서 넘겨주면 된다.
			 *  
			 *  만약 split()을 사용하고싶은 경우 정규식으로는
			 *  String input = br.readLine();
			 *  String[] s = input.subString(1, input.length - 1).split(","); 을 해주어야 한다.
			 *  
			 *  subString을 쓰지않고, split("[^0-9]") 또는, 
			 *  split("[\\[\\]\\,") 같이 정규식으로만 쓴다면 첫 번째 인자가 정규식에 걸려
			 *  빈 문자열을 반환하게 되기 때문
			 *  
			 *  ex)
			 *  str = "[1,2,3,4]";
			 *  strr[] = str.split("[\\[\\]\\,");
			 *  
			 *  result)
			 *  strr[0] = ""
			 *  strr[1] = "1"
			 *  strr[2] = "2"
			 *  strr[3] = "3"
			 *  strr[4] = "4"
			 */
			
			/* nextLine() 메서드로 가져온 문자열은 개행 문자("\n")를 포함
			 	=> StringTokenizer로 파싱할 때 문제 => 구분자로 " \n"을 지정*/
			st = new StringTokenizer(sc.next(), "[],");
			 
			deque = new ArrayDeque<Integer>();
			
			// deque에 배열의 원소를 넣어줌
			for (int i=0; i<n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			// AC메소드를 호출하여 결과 출력
			AC(command, deque);
		}
		// 결과를 출력
		System.out.println(sb);
	}

}
