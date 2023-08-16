package p2023_07_18;

// p195
// 배열 복사 - for문으로 배열 복사
// -배열은 객체이기에, 배열 복사시에는 주소가 복사되는게 아닌
//  배열의 요소들이 복사됨
// => 원본 배열과 복사된 배열은 독립적인 메모리 공간을 갖게 됨
public class ArrayEx08_CopyArray_For {

	// oldArray의 값들을 newArray로 복사
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] oldArray = {10, 20, 30};	// 원본 배열
		int[] newArray = new int[5];	// 새로운 배열
		// newArray = {0, 0, 0, 0, 0}으로 초기값 형성됨

		// oldArray 배열 값을 newArray로 복사
		for (int i=0; i<oldArray.length; i++) {
			newArray[i] = oldArray[i];		// 배열 복사하는 코드
		}	// 인덱스로 접근하여 newArray값을 변경해야 하기에, 확장for문X
		
		// 복사된 배열 원소값 출력
		System.out.print("newArray = {");
		// 원소값 출력에 대해서는 확장 for문 사용 가능
		// element(i)는 반복할 배열의 각 요소들을 나타내는 변수
		// (확장 for문에서는 내부적으로 배열의 크기를 알아내고, 각 요소에
		//  접근하기 위해 반복 인덱스를 자동 처리함)
		for (int i : newArray) {
			System.out.print(i+"\t");
		}

		System.out.print("}");
		System.out.println();
		
	}

}
