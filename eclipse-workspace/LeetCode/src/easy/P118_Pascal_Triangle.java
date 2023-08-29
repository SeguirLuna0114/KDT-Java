package easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* 118번 Pascal’s Triangle
 * 음수가 아닌 정수 numRows가 주어지면, 파스칼 삼각형을 만들어라
 * 
 * - 1 <= numRows <= 30
 * *Pascal's Triangle 
 * : each num is the sum of the two numbers
 * 			 1			numRows = 1
 * 		  1		1		numRows = 2
 * 		1	 2	  1		numRows = 3
 * 	  1	  3	    3   1	numRows = 4	
 * 	1	4	3+3	  ?	 1	numRows = 5
 */
public class P118_Pascal_Triangle {
	
	/** 파스칼의 삼각형
	 * 1. 줄이 늘어날 수록 숫자의 갯수는 1씩 증가
	 * 2. 맨 처음 값과 맨 마지막 값은 각각 1
	 * 3. 나머지 값들은 윗줄의 (col-1) + 윗줄의 col의 값
	 * 	 => triangle[row][col] = triangle[row-1][col-1] + triangle[row-1][col]
	 */
	static List<List<Integer>> PascalTriangle(int numRows) {
		
		// 결과값을 저장할 list변수 생성
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		// 2차원 배열이기에, ArrayList를 add
		triangle.add(new ArrayList<Integer>());
		
		// 파스칼 삼각형의 첫 줄에는 값 1을 hardcoding으로 집어넣음
		triangle.get(0).add(1);
		
		for(int row = 1; row < numRows; row++) {
			// 현재의 줄을 ArrayList로 인스턴스 화
			List<Integer> currRow = new ArrayList<Integer>();
			
			// 계산 후 현재 Row의 각 컬럼값을 얻기 위해 이전 줄의 값을 가져와 prevRow에 저장
			List<Integer> prevRow = triangle.get(row - 1);
			
			// 현재 줄의 첫번째 값은 항상 1. 하드코딩으로 집어넣음
			currRow.add(1);
			
			// 현재 줄의 첫번째 값과 마지막 값을 제외한 중간 컬럼 값을 구하기 위함
			for(int col = 1; col < prevRow.size(); col++) {
				/* 현재 줄의 현재 컬럼에 이전줄의 현재 컬럼 -1 의 값 + 이전줄의 현재 컬럼 값을 넣어줌
				 * triangle[row][col] = triangle[row-1][col-1] + triangle[row-1][col]
				 */
				currRow.add(prevRow.get(col - 1) + prevRow.get(col));
			}
			
			// 현재 줄의 맨 마지막 값은 항상 1. 하드코딩으로 집어넣음
			currRow.add(1);
			
			// triangle에 현재 줄의 값을 add
			triangle.add(currRow);
		}
		
		// 결과값을 return
		return triangle;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numRows = Integer.parseInt(args[0]);
		
		// 메소드 실행
		List<List<Integer>> result = PascalTriangle(numRows);
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (List<Integer> row : result) {
            sb.append(row).append(',');
        }
		/* sb.setLength() 메소드
		 * : StringBuilder 객체의 길이를 설정하는 역할
		 */
		sb.setLength(sb.length() - 1); // 마지막 쉼표 제거
		
		sb.append(']');
		
		System.out.println(sb);
	}
}
