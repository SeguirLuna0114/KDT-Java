package p2023_07_31;

import java.util.Iterator;
import java.util.TreeSet;

// TreeSet
// 1. 데이터를 오름차순으로 정렬해서 저장하고 출력하는 기능 제공
// 2. 중복된 데이터를 저장할 수 없음
// 			오름차순 정렬							내림차순 정렬
//-----------------------------------------------------------------------
// 숫자: 작은 숫자부터 큰 숫자 순응로 정렬 ex)1, 2, 3...	큰 숫자부터 작은 숫자 순으로 정렬
// 문자: 사전 순 정렬	ex) a, b, c,...				사전 역순 정렬

//* Iterator 인터페이스
//	: 여러요소를 담는 객체(List, Set, Map)를 순회하며 요소에 접근하는데 사용
//- boolean hasNext(): Iterator가 순회하면서 가져올 요소가 남아있는지 확인
//- Object next(): Iterator가 다음 요소를 반환하는 메서드
//- void remove(): 현재 순회중인 요소 삭제하는 메소드
public class DataStruct_TreeSet_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet hs = new TreeSet();
		
		if(hs.add("korea")){
			System.out.println("첫 번째 korea 추가 성공");
		}
		else{
			System.out.println("첫 번째 korea 추가 실패");
		}
		if(hs.add("japan")){
			System.out.println("japan 추가 성공");
		}
		else{
			System.out.println("japan 추가 실패");
		}
		if(hs.add("america")){
			System.out.println("america 추가 성공");
		}
		else{
			System.out.println("america 추가 실패");
		}
		if(hs.add("britain")){
			System.out.println("britain 추가 성공");
		}
		else{
			System.out.println("britain 추가 실패");
		}
		
		if(hs.add("korea")){	// 중복된 데이터를 저장할 수 없음
			System.out.println("두 번째 korea 추가 성공");
		}
		else{
			System.out.println("두 번째 korea 추가 실패");
		}
		
		// 오름차순으로 정렬된 결과 출력
		System.out.println(hs);
		
		// Iterator(반복자) : america, britain, japan, korea
		// Set.iterator()메소드를 사용하여, Set에 저장된 요소를 순회하기 위한 Iterator객체 생성
		Iterator it = hs.iterator();
		
		// Iterator.hasNext()메소드: 가져올 데이터(요소)가 남아있을때만 true리턴
		while(it.hasNext()){
			// Iterator.next()메소드: 다음 데이터(요소)를 1개씩 가져오는 메소드
			System.out.println(it.next());
		}		
	}
}
