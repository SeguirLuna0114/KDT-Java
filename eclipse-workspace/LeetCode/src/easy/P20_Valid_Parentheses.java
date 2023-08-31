package easy;

import java.util.Map;
import java.util.Stack;

/** 여는 괄호와 닫는 괄호 쌍이 맞는지 안맞는지 구별하는 문제
 * Valid Parentheses
 * 
 * Given a String s containing just the characters(){}[]
 * determine if the input String is valid.
 * 
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 
 * ex) s = "()]" => flase
 * 	   s = "((())), (){()}[[{()}]]" => true
 */
public class P20_Valid_Parentheses {
	
	/** 열고 닫는 괄호의 쌍
	 * 1. 여는 괄호일 때는 true, false를 생각 할 필요가 X
	 * 2. 첫번째 닫는 괄호가 나오면서, 가장 가까운 여는 괄호와 짝이 맞아야 함
	 * 		=> 짝이 맞으면, 해당 여는 괄호를 없애고, 1번과 2번 반복
	 * 		   짝이 맞지 않으면, false를 반환
	 * 3. 이후 모든 짝이 맞다면 true반환
	 */
//	방법1) 여는괄호와 닫는 괄호의 쌍을 비교하니까 Map<K, V> 인터페이스를 사용
	static boolean checkBrackets(String s) {
		
		// Map 인터페이스 사용하여 키, 밸류 값에 (),[],{} 쌍 포함시킴
		Map<Character, Character> map = Map.of( '(', ')',
												'{', '}',
												'[', ']');
		
		// 데이터를 삭제하면서 확인하기 위해 STACK의 POP메소드 사용
		Stack<Character> stack = new Stack<Character>();
		
		// 입력된 스트링의 아이템 갯수 만큼 for 문을 돌림
		int i=0;
		for(char c : s.toCharArray()) {
//			System.out.println(i + " c is " + c);
			
			// 여는 괄호(키)인 경우, stack에 push
			if(map.containsKey(c)) {
				stack.push(c);
			}
			
			// map의 키값(여는 괄호)이 아닌 경우
			// => 비어있거나 닫는 괄호(밸류)인 경우는, stack에 있는 키값(여는 괄호)와 짝이 맞는지 비교
			else {
				// stack이 비어있는 경우 false
				if(stack.isEmpty()) {
					return false;
				}
				
				// 닫는 괄호(뱔류)로 시작하는 경우,
				// 이전 stack에 입력된 값(여는 괄호)을 pop으로 꺼내면서 삭제
				char open = stack.pop();
//				System.out.println(i +" open is " + open);
//				System.out.println("***" + i + " open is " + open +", c is " + c);
				
				// 만일 해당 여는괄호(키)의 닫는 괄호(밸류)값과 c가 같지 않은 경우
				// => stack의 여는괄호와 닫는 괄호가 쌍을 이루지 않는 경우
				if(map.get(open) != c) {
					return false;
				}
			}
			i++;
		}
		// stack에 아무런 값도 없다면, 쌍을 이루어 삭제되었다는 뜻이고,
		// 이는 모든 짝이 맞다는 뜻이기에, 입력값은 valid함 = true리턴
		return stack.isEmpty();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 입력받은 괄호를 포함한 문자열이 valid한지 확인
		System.out.println(checkBrackets(args[0]));
	}
}
