package p2023_07_17;

// p157
//무한루프: while문
//조건식이 항상 참인경우로 평가되어 반복이 끝나지 않는 반복문
//break: 반복문을 빠져 나오는 역할
public class Break03_random {

	//난수 발생 & 무한루프 종료 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count=0;	//변수 초기화
		while (true) {
			count++;	// count=1로 설정하면, while문 끝에서 증감식 작성
			int num = (int)(Math.random()*6)+1; //난수발생: 1~6
			System.out.println("발생시킨 난수: "+num);
			if (num==6) break;	//무한루프 빠져나옴
		}
		
		System.out.println("프로그램 종료");
		System.out.println("루프횟수: "+count);
		
	}

}
