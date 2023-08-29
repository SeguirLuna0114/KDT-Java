package easy;

/* Reverse String 2
 * 
 * Given a string s and integer k
 * reverse the first k character for every 2k characters counting from the start of the string
 * 
 * - if there are fewer than k character left, reverse all of them.
 * - if there are less than 2k but greater than or equal to k characters,
 * 	then reverse the first k character and leave the other as original.
 * 
 * ex) s= "abcdefg", k=2 => "bacdfeg"
 * 	   s= "abcd", k=2  => "bacd"
 */
public class P541_Reverse_String {
	
	static String reverseStr(String s, int k) {
		
		// 입력받은 스트링을 toCharArray()를 이용해서 배열로 만들고 변수 a 에 할당
		char[] a = s.toCharArray();
		
		// 루프 한번 돌면 i 값은 i + 2 * k 만큼 증가
		for(int i=0; i<a.length; i += 2*k) {
			// i + k 값과 a.length - 1 값 중 작은 값이 대입
			int j= Math.min(i + k - 1, a.length -1);
			
			// i가 배열 아이템 갯수(j) 보다 작을 때 까지 반복
			while(i <j) {
				char temp = a[i];
				a[i++] = a[j];
				a[j--] = temp;
			}
		}
		
		return new String(a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = args[0];
		int k = Integer.parseInt(args[1]);
		
		// 메소드 호출
		System.out.println(reverseStr(s, k));
	}
}
