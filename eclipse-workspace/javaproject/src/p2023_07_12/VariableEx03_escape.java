package p2023_07_12;
// p66
// 이스케이프 문자

public class VariableEx03_escape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// \t : 탭 만큼 띄움
		System.out.println("번호\t\t이름\t직업");

		// \n : 줄바꿈
		System.out.println("행 단위 출력\n\n"); //줄바꿈 2번
		System.out.println("행 단위 출력\n");	//줄바꿈 1번
		
		// \" : " 출력
		// \' : ' 출력
		System.out.println("우리는 \"개발자\" 입니다.");
		
		// \\ : \ 출력
		System.out.println("봄\\여름\\가을\\겨울");
		
	}

}
