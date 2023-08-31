package easy;

/** Longest Common Prefix
 * 스트링 배열들이 공통으로 갖고 있는 prefix를 찾는 문제
 * - Write a function to find the longest common prefix string amongst an array of Strings.
 * - If there is no common prefix, return an empty string ""
 * 
 * ex) strs = ["flower", "flow", "flight"]
 * 		=> output : "fl"
 * 
 * * IndexOf()메소드 : 원하는 글자가 어떤 스트링에 몇번째에 있는지 알 수 있는 메소드. 만일 없다면 -1 반환
 * * SubString()메소드 : 해당 스트링의 일부 문자만 가져오고 싶을 경우 사용 
 */
public class P14_Longest_Common_Prefix {
	
//	방법1) 배열의 첫 번째 문자열을 기준으로 시작하여 각 문자열을 순회하며 공통된 접두사를 찾는 방법
	static String LongestCommonPrefix(String[] strs) {
		
		// 입력값이 없는 경우 빈 문자열 반환
		if(strs.length == 0) {
			return "";
		}
		
		// 첫번째 문자열을 prefix변수에 할당
		String prefix = strs[0];
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<strs.length; i++) {
			// 첫번째 문자열
			sb.append(i).append(" prefix is ").append(prefix).append('\n');
			// i번째 문자열
			sb.append(i).append(" strs is ").append(strs[i]).append('\n');
			
			while(strs[i].indexOf(prefix) != 0) {
				// prefix가 없으니까 prefix에서 맨 마지막 글자를 뺌
				prefix = prefix.substring(0, prefix.length() -1);
				sb.append(i).append(" in while prefix is ").append(prefix).append('\n');
				
				if(prefix.isEmpty()) {
					return "";
				}
			}
		}
		System.out.println(sb);
		
		return prefix;
	}
	
	
//	방법2) 문자열 배열 strs에 대해 세로 방향으로 문자열을 비교하여 가장 긴 공통 접두사를 찾는 함수를 구현
	static String LongestCommonPrefix_vertical(String[] strs) {
		
		if(strs == null || strs.length == 0) {
			return "";		// 빈 문자열 반환
		}
		
		// 첫 번째 문자열을 기준으로 각 문자열의 같은 인덱스 위치에 있는 문자를 비교
		for(int i=0; i<strs[0].length(); i++) {
			
			// 첫번째 문자열의 i번째 문자를 가져옴
			char c = strs[0].charAt(i);
			// 두번째 문자열부터 마지막 문자열까지 반복
			for(int j=1; j<strs.length; j++) {
				
				// 두번째 문자열이 비어있거나 or 문자열의 현재 인덱스 위치의 문자가 첫 번째 문자열과 다른 경우
				if(i == strs[j].length() || strs[j].charAt(i) != c) {
					// 현재까지 찾은 접두사를 반환
					return strs[0].substring(0, i);
				}
			}
		}
		
		// 만일 모든 문자열을 순회하여 공통 접두사를 찿았다면, 첫번째 문자열 자체를 반환
		return strs[0];
	}
	
	
//	방법3) 분할정복(Divide and Conquer) 방식을 사용하여 주어진 문자열 배열의 가장 긴 공통 접두사를 찾는 함수
	static String StringCommonPrefix_DivideConquere(String[] strs) {
		
		// 배열이 비어있거나 null인 경우 빈 문자열을 반환
		if(strs == null || strs.length == 0) {
			return "";		// 빈 문자열 반환
		}
		
		return StringCommonPrefix_DivideConquere(strs, 0, strs.length -1);
	}
	
	static String StringCommonPrefix_DivideConquere(String[] strs, int left, int right) {
		
		// 분할정복 코드		
		if(left == right) {
			return strs[left];
		}
		else {
			int mid = (left + right) / 2;
			String LCP_left = StringCommonPrefix_DivideConquere(strs, left, mid);
			String LCP_right = StringCommonPrefix_DivideConquere(strs, mid+1, right);
			
			return commonPrefix(LCP_left, LCP_right);
		}
			
	}
	
	static String commonPrefix(String left, String right) {
		
		int min = Math.min(left.length(), right.length());
		for(int i=0; i<min; i++) {
			if(left.charAt(i) != right.charAt(i)) {
				return left.substring(0, i);
			}
		}
		
		return left.substring(0, min);
	}
	
	
//	방법4) 이분탐색(Binary Search)방식을 사용하여 주어진 문자열 배열의 가장 긴 공통 접두사를 찾는 방법
	static String StringCommonPrefix_BinarySearch(String[] strs) {
		
		// 배열이 비어있거나 null인 경우 빈 문자열을 반환
		if(strs == null || strs.length == 0) {
			return "";		// 빈 문자열 반환
		}
		
		// 최소 길이 변수를 Max_val로 초기값 설정
		int minLen = Integer.MAX_VALUE;
		for(String str : strs) {
			// 입력받은 문자열 배열에서 길이가 가장 작은 문자열의 길이로 갱신
			minLen = Math.min(minLen, str.length());
		}
		
		// 탐색 범위 설정
		int low = 1;
		int high = minLen;
		
		while(low <= high) {
			int middle = (low + high) /2;
			if(isCommonPrefix(strs, middle)) {
				low = middle +1;
			} else {
				high = middle -1;
			}
		}
		
		return strs[0].substring(0, (low+high)/2);
	}
	
	static boolean isCommonPrefix(String[] strs, int len) {
		String str1 = strs[0].substring(0, len);
		for(int i=1; i<strs.length; i++) {
			
			if(!strs[i].startsWith(str1)) {
				return false;
			}
		}
		return true;
	}
	
	
	/** 트라이 자료구조 활용
	 * @param q 검색할 기준이 되는 문자열
	 * @param strs 주어진 문자열 배열
	 * @return 가장 긴 공통 접두사를 찾아 문자열로 반환
	 */
/*
//	방법5) 트라이 자료구조를 활용하여 가장 긴 공통 접두사를 찾는 방법
	static String LongestCommonPredix_TrieNode(String q, String[] strs) {
		
		// 배열이 비어있거나 null인 경우 빈 문자열을 반환
		if(strs == null || strs.length == 0) {
			return "";		// 빈 문자열 반환
		}
		
		// 만일 배열의 길이가 1이면, 첫번째 문자열을 반환
		if(strs.length == 1) {
			return strs[0];
		}
		
		// Trie클래스 객체 생성
		P14_Longest_Common_Prefix.Trie trie = new P14_Longest_Common_Prefix.Trie();
		
		for(int i=1; i<strs.length; i++) {
			trie.insert(strs[i]);
		}
		
		return trie.searchLonestPrefix(q);
	}
	
	// 트라이 자료구조의 노드를 나타내는 클래스
	class TrieNode {
		
		// 다른 노드로의 연결을 나타내는 배열 - 알파벳 소문자에 대응하는 인덱스를 사용해 다음 노드에 연결
		private TrieNode[] links;
		// 알파벳 소문자의 개수 26개로 고정
		private final int R = 26;
		// 해당 노드가 단어의 끝인지를 나타내는 플래그
		private boolean isEnd;
		// 자식 노드의 수
		private int size;
		
		public void put(char ch, TrieNode node) {
			
			links[ch - 'a'] = node;
			size++;
		}
		
		public int getLinks() {
			return size;
		}
	}
	
	// 트라이 자료구조를 나타내는 클래스
	class Trie {
		
		// root: 트라이의 루트 노드
		private P14_Longest_Common_Prefix.TrieNode root;
		
		public Trie() {
			root = new P14_Longest_Common_Prefix.TrieNode();
		}
		
		private String searchLonestPrefix(String word) {
			
			P14_Longest_Common_Prefix.TrieNode node = root;
			StringBuilder prefix = new StringBuilder();
			
			for(int i=0; i<word.length(); i++) {
				
				char currLetter = word.charAt(i);
				
				if (node.containsKey(currLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
	                prefix.append(currLetter);
	                node = node.get(currLetter);
	            } else {
	                return prefix.toString();
	            }
			}
			
			return prefix.toString();
		}
	}
*/	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 문자열 배열에 대해 가장 긴 공통 접두사를 구하는 코드 실행
//		방법1) 배열의 첫 번째 문자열을 기준으로 시작하여 각 문자열을 순회하며 공통된 접두사를 찾는 방법
		System.out.println(LongestCommonPrefix(args));
		
//		방법2) 문자열 배열 strs에 대해 세로 방향으로 문자열을 비교하여 가장 긴 공통 접두사를 찾는 함수를 구현
		System.out.println(LongestCommonPrefix_vertical(args));
		
//		방법3) 분할정복(Divide and Conquer) 방식을 사용하여 주어진 문자열 배열의 가장 긴 공통 접두사를 찾는 함수
		System.out.println(StringCommonPrefix_DivideConquere(args));
		
//		방법4) 이분탐색(Binary Search)방식을 사용하여 주어진 문자열 배열의 가장 긴 공통 접두사를 찾는 방법
		System.out.println(StringCommonPrefix_BinarySearch(args));
		
//		방법5) 트라이 자료구조를 활용하여 가장 긴 공통 접두사를 찾는 방법
		
		
	}
}
