package p2023_07_31;

// HashSet과 Date 클래스가 있는 패키지를 임포트
import java.util.*;

public class DataStruct_Set_HashSet {
	
	public static void main(String[] args) {

		// Set은 인터페이스이기에, 자체적으로 객체 생성이 불가
		// HashSet 클래스의 객체 생성
		Set hs = new HashSet();
		// set인터페이스의 하위상속을 받는 HashSet클래스만으로도 객체 생성 가능
//      HashSet hs = new HashSet();

//		boolean add(Object e): 중복된 데이터는 추가되지 X(false값 리턴)
		// -최상위 자료형(Object형)으로 되어있기에, 모든 자료형을 모두 저장 가능
		// hs 객체에 데이터 객체 보관
		hs.add("gemini");			// 업캐스팅
		hs.add("johnharu");
		
//		Date d=new Date();
//      hs.add( d );
		hs.add(new Date());

		// hs 객체가 보관하고 있는 데이터 객체 출력
		System.out.println("hs의 내용 : " + hs);

		// remove메소드 사용 -> "johnharau" 데이터 객체를 hs 객체에서 제거
		hs.remove("johnharu");
		System.out.println("hs의 내용 : " + hs);

		// size메소드 사용 -> hs 객체에 있는 데이터 개체의 갯수를 출력
		System.out.println("hs의 데이터 갯수" + hs.size());
	}
}