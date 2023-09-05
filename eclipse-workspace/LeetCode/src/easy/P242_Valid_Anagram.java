package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/** Anagram(두개의 문자열이 같은 문자를 포함하고 있다면 true)
 * : a word or phrase formed by rearranging the letters of a different words
 * or phrase, typically using all the original letters exactly once.
 * 
 *  1. 두개의 입력값의 문자 개수가 같아야 함
 *  2. 입력값 1에 입력값 2에 없는 문자가 있으면 안됨
 *  3. 2개의 input에 문자열이 중복된 문자가 있다면, 그 개수가 같아야 함
 * 
 * Given two String s, t
 * If t is an anagram of s, then return true
 * 
 * ex) s= "anagram", t="nagaram" => true
 */
public class P242_Valid_Anagram {
	
//	방법1) 애너그램 조건을 만족하는 지 여부 확인
	static boolean isAnagram(String s, String t) {
		
		char[] s_ch = s.toCharArray();
		char[] t_ch = t.toCharArray();
		
		// 1. 두 입력값의 문자 개수가 같아야 함
		if(s_ch.length != t_ch.length) {
			return false;
		}
		
		// 2. 입력값 1과 2에 있는 문자가 서로 같아야 함 => 카운팅정렬 사용시, 생략 가능
		for(int i=0; i<s_ch.length; i++) {
			
			// s의 첫번째 문자 -> 문자열 변환
			String str_s = String.valueOf(s_ch[i]);
			// t의 첫번째 문자 -> 문자열 변환
			String str_t = String.valueOf(t_ch[i]);
			
			if(t.contains(str_s) && s.contains(str_t)) {
				/** String.contains(CharSequence s)메소드
				 * : 문자열 내에 특정 문자열 또는 문자 시퀀스(CharSequence)가 포함되어 있는지 여부를 확인
				 * - CharSequence는 문자열 뿐만 아니라 String 클래스를 상속받는 모든 클래스를 포함하는 인터페이스
				 */
			}
			else {
				return false;
			}
		}
		
		// 카운팅 정렬을 사용
		// 3. 중복된 수가 있다면, 그 수가 같아야 함
		int[] sCounter = new int[26];	// 알파벳은 26개
		int[] tCounter = new int[26];	// 알파벳은 26개
		
		for(int i=0; i<s.length(); i++) {
			sCounter[s.charAt(i) - 'a']++;		// charAt()메소드는 ASCII코드를 반환하기에 0번째 인덱스부터 채우기 위해 -'a'
			tCounter[t.charAt(i) - 'a']++;		// charAt()메소드는 ASCII코드를 반환하기에 0번째 인덱스부터 채우기 위해 -'a'
		}
		
		// 카운팅정렬한 배열의 값이 서로 같지않다면, 중복숫자의 개수가 다르다는 의미
		for(int i=0; i<26; i++) {
			if(sCounter[i] != tCounter[i]) {
				return false;
			}
		}
		
		// 모든 조건을 통과했다면 anagram이기에 true반환
		return true;
	}
	
	
//	방법2) 하나의 배열을 사용해서 카운팅정렬을 실행하는 방법
	static boolean isAnagram2(String s, String t) {
		
		// 1. 두 문자열의 길이가 다르면 false
		if(s.length() != t.length()) {
			return false;
		}
		
		// 2. 카운팅 정렬을 사용하여 각 알파벳이 중복된 count를 table배열에 담는다
		int[] table = new int[26];	// 알파벳 26개
		
		// 입력값 s의 문자들과 중복된 count를 table[]에 담음
		for(int i=0; i<s.length(); i++) {
			table[s.charAt(i) -'a']++;
		}
		
		// table에서 입력값 t에 있는 문자를 하나씩 가져와서 -1을 수행
		for(int i=0; i<t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			
			// 만일, 해당 문자와 대응하는 인덱스의 값이 음수라면(t에만 존재하는 문자인 경우)
			// 그 값이 0보다 작으면 즉 마이너스가 되면 다른 문자이거나 같은 문자라도 그 숫자가 다르다는 것이기 때문에 false
			if(table[t.charAt(i)-'a'] < 0) {
				return false;
			}
		}
		
		// 모든 조건을 충족시키는 경우 true
		return true;
	}
	
	
//	방법3) Arrays.Sort()정렬을 시도해서 각 배열의 값이 같다면 true리턴
	static boolean isAnagramSort(String s, String t) {
		
		// 만일 두 문자열의 길이가 다른경우, false
		if(s.length() != t.length()) {
			return false;
		}
		
		// 두 문자열을 char[]배열로 변환
		char[] str_s = s.toCharArray();
		char[] str_t = t.toCharArray();
		
		// 문자 배열을 Arrays.sort()로 오름차순 정렬
		Arrays.sort(str_s);
		Arrays.sort(str_t);
		
		/** Arrays.equals()메소드를 사용해 각 배열의 값을 비교
		 * - boolean equals(char[] a, char[] a2) 메소드 
		 *   : 두 개의 char 배열이 내용적으로 동일한지 여부를 확인하기 위해 사용되는 메서드
		 */
		return Arrays.equals(str_s, str_t);
	}
	
	
//	방법4) String 을 ArrayList로 만들어서 sorting을 하고 equals()를 사용하는 방법
	static boolean isAnagramSplit(String s, String t) {
		
		// 만일 두 문자열의 길이가 다른경우, false
		if(s.length() != t.length()) {
			return false;
		}
		
		// 두 문자열을 split("")메소드를 사용하여 문자열배열로 반환
		String[] sSplit = s.split("");
		String[] tSplit = t.split("");
		
		// Arrays.asList()메소드로 문자열배열 -> 리스트로 변환
		ArrayList<String> sList = new ArrayList<String>(Arrays.asList(sSplit));
		ArrayList<String> tList = new ArrayList<String>(Arrays.asList(tSplit));
		
		// Collection.sort(List<T> list)메소드로 리스트를 오름차순 정렬
		Collections.sort(sList);
		Collections.sort(tList);
		
		// ArrayList.equals(Object o)메소드를 사용하여 리스트의 값이 같은지 확인
		return sList.equals(tList);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = args[0];
		String t = args[1];
		
		// 애너그램인지 확인하는 메소드 실행
//		방법1) 애너그램 조건을 만족하는 지 여부 확인
		System.out.println(isAnagram(s, t));
		
//		방법2) 하나의 배열을 사용해서 카운팅정렬을 실행하는 방법
		System.out.println(isAnagram2(s, t));
		
//		방법3) Arrays.Sort()정렬을 시도해서 각 배열의 값이 같다면 true리턴
		System.out.println(isAnagramSort(s, t));
		
//		방법4) String 을 ArrayList로 만들어서 sorting을 하고 equals()를 사용하는 방법
		System.out.println(isAnagramSplit(s, t));
	}
}
