package stack_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단(yes, no)하는 프로그램 작성
	
	문자열에 포함되는 괄호는 소괄호()와 대괄호[]이고, 
	-모든 괄호들은 짝을 이뤄야 한다.(와), [와]
	-모든 오른쪽 괄호들은 자신의 짝을 이룰 수 있는 왼쪽 괄호가 존재
	-모든 괄호의 짝은 1:1매칭만 가능. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지X
	-짝을 이루는 두 괄호가 있을 때, 그 사이 문자열도 균형잡혀야 함
 */
public class Valid_Parenthesis_String {

	// Stack클래스를 사용한 경우
	static String Use_Stack(String str) {
		// stack클래스 - 후입선출(LIFO). 데이터를 쌓아올리는 구조. 배열 기반의 데이터
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0; i<str.length(); i++) {
			// i번째문자를 charAt()메소드로 가져옴
			char charStr = str.charAt(i);
			
			// 여는 (왼쪽)괄호일 경우 stack에 push
			// push(E item): 스택에 새로운 요소를 맨 위에 추가
			if(charStr == '(' || charStr == '[') {
				stack.push(charStr);
			}
			// 닫는 (오른쪽) 소괄호일 경우
			else if (charStr == ')') {
				// 스택이 비어있거나 peek()메소드로 꺼내온 이전 원소가 '('가 아닌 경우
				if(stack.empty() || stack.peek() != '(') {
					// 균형이 맞춰지지 않음
					return "no";
				} else {
					// pop()메소드: 스택의 맨 위 요소를 제거하며 반환
					stack.pop();
				}
			}
			// 닫는 (오른쪽) 대괄호인경우
			else if(charStr == ']') {
				// 스택이 비어있거나 peek()메소드로 꺼내온 이전 원소가 '['가 아닌 경우
				if(stack.empty() || stack.peek() != '[') {
					// 균형이 맞춰지지 않음
					return "no";
				} else {
					// pop()메소드: 스택의 맨 위 요소를 제거하며 반환
					stack.pop();
				}
			}
			// 그 외의 경우에는 확인할 필요가 없는 문자들이기에 skip
		}
		// 모든 괄호 필터링이 끝난 이후에는 stack이 비어있는지 확인
		if (stack.empty()) {
			// 스택에 잔여요소가 없는 경우(비어있으면) 온전한 수식이기에 yes반환
			return "yes";
		} else {
			// 잔여요소가 많다면, 여는 괄호가 많다는 뜻이기에 no반환
			return "no";
		}
	}
	
	
	//char[]배열을 사용한 경우
	static String Use_CharArray(String str) {
		
		// Stack처럼 사용할 char[]배열 선언
		char[] stackArr = new char[str.length()];
		
//		for (int i=0; i<str.length(); i++)) {
		int size = 0;
		for (char charStr : str.toCharArray()) {
			// 여는 (왼쪽)괄호일 경우 배열에 저장 후 size 1증가
			if(charStr == '(' || charStr == '[') {
				stackArr[size] = charStr;
				size++;
			}
			// 닫는 (오른쪽) 소괄호일 경우
			else if (charStr == ')') {
				// 배열이 비어있거나 배열에 저장된 이전 원소가 '('가 아닌 경우
				if(size == 0 || stackArr[size-1] != '(') {
					// 균형이 맞춰지지 않음
					return "no";
				} else {
					// 배열에 저장된 이전요소 확인을 위해 size 1감소
					size--;
				}
			}
			// 닫는 (오른쪽) 대괄호인경우
			else if(charStr == ']') {
				// 배열이 비어있거나 배열에 저장된 이전 원소가 '['가 아닌 경우
				if(size == 0 || stackArr[size-1] != '[') {
					// 균형이 맞춰지지 않음
					return "no";
				} else {
					// 배열에 저장된 이전요소 확인을 위해 size 1감소
					size--;
				}
			}
			// 그 외의 경우에는 확인할 필요가 없는 문자들이기에 skip
		}
		// 모든 괄호 필터링이 끝난 이후에는 배열이 비어있는지 확인
		if (size != 0 ) {
			// 잔여요소가 많다면, 여는 괄호가 많다는 뜻이기에 no반환
			return "no";
		} else {
			// 배열에 잔여요소가 없는 경우(비어있으면) 온전한 수식이기에 yes반환
			return "yes";
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 하나 또는 여러줄에 걸쳐서 문자열이 주어짐. 각 문자열은 영문 알파벳, 공백, 소괄호, 대괄호로 아류오작ㅎ
		// 길이는 100글자보다 작거나 같다. 맨 마지막에 점 하나(".")가 들어오면 종료
		System.out.println("문자열을 입력하세요.(맨 마지막에 점 하나(\".\")가 들어오면 종료)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			String s = br.readLine();
			
			// 맨 마지막에 점 하나(".")가 들어오면 종료
			if(s.equals(".")) {
				// 종료 조건문
				break;			// System.out(0);
			}
			
			// 1. Use_Stack()메소드를 호출하여 입력받은 문자열s를 매개변수로 활용 -> 반환되는 값을 출력
//			sb.append(Use_Stack(s)).append('\n');
			
			// 2. Use_CharArray()메소드를 호출하여 입력받은 문자열s를 매개변수로 전달 -> 반환값 출력
			sb.append(Use_CharArray(s)).append('\n');
		}
		System.out.println(sb);
	}
}
