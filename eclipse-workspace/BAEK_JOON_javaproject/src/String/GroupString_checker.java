package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그룹 단어: 단어에 존재하는 모든 문자에 대해, 각 문자가 연속해서 나타나는 경우
// ex) ccazzzzbb : c,a,z,b가 모두 연속해서 나타남(그룹단어)
// ex) abbbccb : b가 떨어져서 나타나기에 그룹단어X
// ex) kln: k, l, n이 연속해서 나타남(그룹단어)

// 문자열의 문자가 연속되지 않으면서, 이미 입력된 문자의 경우 그룹단어X
class CheckString {
	
	// 입력받은 문자열이 그룹단어인지 아닌지만 따지면 됨 => boolean으로 return
	// 알고리즘 - 입력받은 문자열이 중복되는지 여부 확인하는 메소드
	static boolean checkDouble(String inputStr) {
		// 입력받은 N의 크기만큼의 boolean배열 선언
		// 입력받은 문자열을 하나씩 꺼내서, 그룹단어인지 아닌지 검사
		boolean[] checkArr = new boolean[26];
		// 26개의 단어를 체크할 길이 26의 boolean배열 선언
		
		// prev변수: 반복문에서 문자를 꺼내올 때, 앞선 문자와 연속되는지 여부 판별
		// - prev 문자와 해당 문자가 같다면, 해당문자가 중복인지 검사
		// - prev 문자와 해당 문자가 다르다면, 중복인지 검사
		int prev = 0;
		
		// 문자열을 순회하면서 중복여부를 판별하는 코드
		for (int i=0; i<inputStr.length(); i++) {
			// 문자 하나씩을 꺼내와서 검사 => String.charAt()메소드 사용
			int checknow = inputStr.charAt(i);		// i번째 문자 저장(현재문자)
			
			// 앞선 문자와 i번째 문자가 같지 않다면(연속되지 않는다면)
			if (prev != checknow) {
				// 해당 문자가 처음 나오는 경우(false인 경우)
				// checknow - 'a':charAt()은 해당 문자의 아스키코드값을 반환하기에, 알파벳순으로 0번째~위치시키기 위함
				// a(97)의 값을 가짐. 만일 첫문자가 a라면 97의 값을 갖고 0번째에 위치시키기 위해 97을 빼줌
				if (checkArr[checknow - 'a'] == false) {
					// 0번째부터 자신의 문자에 맞는 인덱스를 찾아가게 하는 코드
					checkArr[checknow - 'a'] = true;	// 값을 true로 바꿈
					prev = checknow;					// 다음 값 체크를 위해 prev 업데이트
				} else {
					// 연속되지는 않지만, 해당 문자가 이미 등장한 적 있는경우
					// 이는 그룹단어X => false반환
					return false;		// 함수 종료
				}
			} else {
				// 앞선 문자와 i번째 문자가 같으면(연속된 문자인 경우)
				continue;	// 아무 동작을 하지 않고, 반복문 계속 진행(다음 i값으로 넘어가서 for문 실행)
			}
		}
		// for문이 끝난 후에도 중복된 문자가 없는 그룹단어라면,
		// (주어진 문자열이 그룹단어이기에) true를 반환하고, 중복문자가 발견된 경우에는 false반환
		return true;
	}
	
}


public class GroupString_checker {
	
	// 첫째줄에 단어의 개수N, (N<=100 자연수)
	// 둘째줄 ~ N개의 줄에 단어가 들어옴(단어는 알파벳 소문자로 되어있고 중복되지 않으며 길이 최대 100)
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("단어의 개수와, 알파벳 소문자로 이루어진 단어를 입력하세요");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째줄에 입력받은 단어의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 그룹단어의 개수 출력하는 코드
		int cnt = 0;
		// 받은 boolean배열에서 true일 경우 cnt++
		for(int i=0; i<N; i++) {
			if (CheckString.checkDouble(br.readLine())) {
				cnt++;
			}
		}
		// 그룹단어의 개수 출력하는 메소드 호출
		System.out.println("그룹단어의 개수="+cnt);
		
	}

}
