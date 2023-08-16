package p2023_07_14;

// while문 (반복문)
// -조건식은 True/False 값을 가져야 함
//	while(조건식){	// 조건식에 따라 반복여부 결정. 
//  	  반복 실행할 문장;
// 	}
public class While01_message {

	// while문을 사용해서 '사랑해요'메시지를 10번 출력하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 반복시킬 초기값변수 설정
		int count = 1;
		
		//증감식: i++, ++i 사용 => 
		while (count <= 10) {
			System.out.println(count+". 사랑해요~!!");
			++count;	// count+=1(count값 1 증가)
		}
		
	}

}
