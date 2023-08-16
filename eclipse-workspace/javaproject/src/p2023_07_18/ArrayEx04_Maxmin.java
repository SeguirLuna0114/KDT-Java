package p2023_07_18;

//배열(Array) - 참조형
//동일한 (한가지) 자료형의 데이터를 저장하기 위한 "정적인" 자료구조
//- 인덱스를 사용하여 개별 요소에 접근 가능

public class ArrayEx04_Maxmin {

	// 배열에 저장된 데이터 중 최대/최소값 구하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// double형 배열 선언
		double[] data = {9.5, 7.0, 13.6, 7.5, 10.5};
		
		double max, min;
		max = data[0];
		min = data[1];
		
		for (int idx=0; idx<data.length; idx++) {
			// 최대값
			if (data[idx] > max) {
				max = data[idx];
			}
			// 최소값
			if (data[idx] < min) {
				min = data[idx];
			}
			if (idx==0) {
				System.out.print("data = {"+data[idx]+", ");
			} else if (idx==data.length-1) {
				System.out.print(data[idx]+"}\n");
			} else {
				System.out.print(data[idx]+", ");
			}
		}
		System.out.println("최대값: "+max);
		System.out.println("최솟값: "+min);
		
	}

}
