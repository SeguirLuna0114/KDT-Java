package p2023_07_18;

// p182
// 메인메소드 + 합을 구하는 사용자 정의 메소드
public class ArrayEx05_Sum_Method {

	//(사용자 정의 메소드)합을 구해서 return해주는 메소드
	// Call by Reference방식
	// : 메소드에 인자로 배열을 전달할 경우, 배열의 주소(reference)를 전달하는 방식
	public static int add(int[] scores) {
		// add메소드 - 매개변수로서 int배열 scores를 인자로 받음
		int sum = 0;	// 합계 변수 초기화
		for (int idx=0; idx<scores.length; idx++) {
			sum += scores[idx];
		}
		
		return sum;	// for문을 활용해 구한 합계를 return해줌
		// return구문: 메소드 호출한 곳에 값을 전달
	}
	
	// 메인 메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scores;		// scores배열 선언
		scores = new int[] {83, 90, 87};	// new연산자로 4byte기억공간 형성(=>주소값을 갖게 됨)
//		int[] scores = new int[]{83, 90, 87};
		
		// 합계 변수 초기화
		int total=0;
		for (int idx=0; idx<scores.length; idx++) {
			total += scores[idx];
		}
		System.out.println("총합: "+total);
		
		// 확장 for문 활용
		int total2=0;
		for (int score : scores) {
			total2 += score;
		}
		System.out.println("총합2: "+total2);
		
		// add 메소드를 호출해서, 리턴된 합계를 total2에 저장
		// add메소드와 같이, int형 배열의 주소를 전달하여 호출
		int sum2 = add(new int[] {83, 90, 87});
//		int sum2 = add({83, 90, 87});	// 배열 전달 방식
		// 메소드 호출을 위해서는, 배열을 생성하고 초기화하여 "공간을 형성"한다음
		// 배열의 주소값을 전달해야 함
		System.out.println("총합: "+sum2);		
		
	}

}
