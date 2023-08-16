package p2023_07_25;

//String클래스의 split(String regex)메소드
//- 반환되는 값은 구분자로 구분된 문자열이 배열 String[]형태로 반환됨
//-StringTokenizer클래스와 비슷

// 구분자를 여러개 지정할 경우 => |를 사용해서 나열
// ex) String[] names = text.split("&|,|-");

public class String_Split_regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[]	split(Strng regex)
		
		String text = "홍길동&홍길순,김길동,김자바-안화수";
		
		String[] names = text.split("&|,|-");
		
		// 기본 for문 출력
		for (int i=0; i<names.length; i++) {
			System.out.print(names[i]+"\t");
		}
		
		System.out.println();
		
		// 확장 for문
		for (String name : names) {
			System.out.print(name+"\t");
		}

	}

}
