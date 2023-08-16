package stack_DataStructure;

// 스택을 이용해서, 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지
// 있다면 어떤 순서로 push와 pop연산을 수행해야 하는지 계산하는 프로그램
// push연산은 '+'로, pop연산은 '-'로 표현, 불가능한 경우 NO 출력
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택(stack)은 기본적인 자료구조 - 자료를 넣는(push)입구와 자료를 뽑는 pop입구가 같아 
// 제일 나중에 들어간 자료가 제일 먼저 나오는 LIFO 특성을 가짐

// 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써 하나의 수열을 만들 수 있음
// 이때, 스택에 push하는 순서는 반드시 "오름차순"을 시키도록 함.
public class Stack_ArrayStack {
		
	// Stack라이브러리를 사용하는 방법
	static void Use_Stack(BufferedReader br, StringBuilder sb, int N) throws IOException {
		
		// Stack클래스를 사용하기 위해 객체생성 with 제네릭(Integer)
		Stack<Integer> stack = new Stack<Integer>();
		
		// N번 반복
		int start=0;
		
		while(N-- > 0) {	//N을 1씩 감소시키면서 0보다 클때까지 반복
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				// start+1부터 입력받은 value까지 push
				for(int i=start+1; i<=value; i++) {
					stack.push(i);
					sb.append('+').append('\n');	// push할 경우 +로 표시하여 저장
				}
				// 다음 push할 때의 오름차순을 유지하기 위한 변수 초기화
				start = value;
			}
			// top에 있는 원소가 입력받은 값과 같지 않은 경우 NO출력
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;		// 해당 메서드의 실행을 "즉시 종료"하고, 해당 메서드를 호출한 곳으로 돌아가는 역할
				// 또는 System.exit(0);으로 대체해도 됨
			}
			
			// pop연산은 '-'로 표현
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}

	// 배열을 선언하여 스택처럼 사용하는 방법
	static void Use_Array_LikeStack(BufferedReader br, StringBuilder sb, int N) throws IOException {
		
		// 입력받은 N크기의 배열선언
		int[] stackArr = new int[N];
		
		// 인덱스와 start의 초기값 할당
		int idx = 0;
		int start = 0;
		
		// N번 반복
		while(N-- >0) {
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				// start+1(1)부터 입력받은 value까지 push
				for(int i=start+1; i<=value; i++) {
					stackArr[idx] = i;
					idx++;
					sb.append('+').append('\n');
				}
				// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 
				start = value;
			}
			// top에 있는 원소가 입력받은 값과 같이 않은 경우
			else if(stackArr[idx-1] != value) {
				System.out.println("NO");
				return;		// System.exit(0); 으로 대체해도 됨
			}
			
			idx--;
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 첫줄에 n(1<= n <= 100,000)이 주어짐. 
		// 둘째줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어짐(같은정수 중복X)
		System.out.println("n(1<= n <= 100,000)을 입력하고,"
				+ " n개의 줄에 수열을 이루는 1 이상 n 이하의 정수를 입력하세요.");
		// 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력할 결과를 저장
		StringBuilder sb = new StringBuilder();
		
		// 첫줄에 n(1<= n <= 100,000)이 주어짐.
		int N = Integer.parseInt(br.readLine());
		
		// 1. Stack을 사용한 경우
		// Use_Stack메소드 호출
		Use_Stack(br, sb, N);
		
		System.out.println();
		
		// 2. Stack클래스 대신 Stack자료구조를 배열로 직접 구현하여 풀이하는 경우
		// Use_Array_LikeStack()메소드 호출
		Use_Array_LikeStack(br, sb, N);
		
	}

}
