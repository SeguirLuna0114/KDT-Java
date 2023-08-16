package Input_Output;

public class HelloWorld_StringBuilder_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ##StringBuilder를 이용
		// -데이터를 모아두었다가 한번에 출력
		// -문자열을 조작할 경우 매우 유리
		// -**StringBuilder에서 문자열을 이어 붙인다는 특징
		StringBuilder sb = new StringBuilder();
		sb.append("Hello World~!");
		
		System.out.println(sb);
		
		// ##StringBuffer
		// -동기화는 지원O (StringBuffer는 동기화X)
		// -multi-thread 상황에서 문자열이 리소스로 사용되면, StringBuffer를 사용해줘야 함
		// -동기화를 지원하기에 StringBuilder보다는 느림. 단, 문자열 조작에 있어 String보다 훨씬 빠름
		StringBuffer sb2 = new StringBuffer();
		sb2.append("Hello World!");
		
		System.out.println(sb2);
		
	}

}
