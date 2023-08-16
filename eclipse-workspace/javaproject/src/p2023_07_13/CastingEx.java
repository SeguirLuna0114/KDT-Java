package p2023_07_13;

// p75 예제
// 강제 형변환
//허용 범위 순: byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
public class CastingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int(4) -> char(2)
		int intValue = 44032;
		char charValue = (char)intValue;	// 강제 형변환
		System.out.println("charValue: " + charValue);	// charValue: 가
		
		// long(8) -> int(4)
		long longValue = 500;
		intValue = (int)longValue;			// 강제 형변환
		System.out.println("intValue: " + intValue);	// intValue: 500
		
		// double(8) -> int(4)
		double doubleValue = 3.14;
		intValue = (int)doubleValue;		// 강제 형변환
		System.out.println("intValue: " + intValue);	// 소수점 아래 삭제됨(데이터 손실): intValue: 3
		
		
	}

}
