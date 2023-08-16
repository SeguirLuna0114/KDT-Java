package p2023_07_20;

// 구구단(2~9단)의 연산결과를 2차원 배열에 저장
// 배열에 저장된 결과를 이용하여 구구단을 출력하는 프로그램
public class Report_0719_ArrayGugu2to9_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] s = new int[8][9];  // 8행  9열
		// array.length: 행의 갯수
		// array[0].length: 열의 갯수
		System.out.println("행의 갯수: "+s.length);
		System.out.println("열의 갯수: "+s[0].length);
		
		
		// 구구단 세로로 한줄로 출력
//		for(int dan=0; dan<=7; dan++){				// 행
//			System.out.println("["+(dan+2)+"단]");
//			for(int i=0; i<=8; i++){				// 열
//				s[dan][i] = (dan+2)*(i+1);
//				
//				System.out.println((dan+2)+"*"+(i+1)+"="+s[dan][i]);
//			}
//			System.out.println("");
//		}	

		// 구구단 연산결과를 배열에 저장
		for(int dan=0; dan<=7; dan++){				// 행
			for(int i=0; i<=8; i++){				// 열
				s[dan][i] = (dan+2)*(i+1);				
			}
		}		
		// 구구단을 각 단별로 출력
		for(int dan=2; dan<=9; dan++)
			System.out.print("["+dan+"단]\t");
		System.out.println("");
		for(int i=0; i<=8; i++){	
			for(int dan=0; dan<=7; dan++){				
				System.out.print((dan+2)+"*"+(i+1)+"="+s[dan][i]+"\t");
			}
			System.out.println("");
		}		
		
				
	}

}
