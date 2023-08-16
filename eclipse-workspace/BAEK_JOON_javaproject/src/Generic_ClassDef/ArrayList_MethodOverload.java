//package Generic_ClassDef;
//
//// @param <E> the type of elements in this list
//import java.util.Arrays;
//import java.util.List;
//
//// java에서 제네릭(ArrayList<E>)데이터 구조 구현
//class MyArrayList<E> implements List<E>, Cloneable {
//	// E: MyArrayList가 보유할 수 있는 요소의 타입을 나타내는 매개변수
//	// 	  - List<E> 인터페이스 구현을 하며, 객체 복제 지원을 위해 Cloneable 인터페이스 구현
//
//	// 필드
//	private static int Default_capa = 10; // 초기 용량-사용자가 용량지정 안했을 경우 사용
//	private static Object[] EmptyArray = new Object[0]; // 빈 배열
//
//	private int size; // 배열에 담긴 요소(원소) 개수(용적의 크기X)
//	Object[] SizeArray; // 요소를 담을 Object 타입의 빈 배열 선언 (크기 지정하지 않음)
//
//	// 기본 생성자
//	public MyArrayList() {
//		// 초기 공간 0으로 할당
//		this.SizeArray = EmptyArray;
//		this.size = 0;
//	}
//
//	public MyArrayList(int capacity) {
//		// 배열의 크기를 capacity로 설정
//		this.SizeArray = new Object[capacity];
//		this.size = 0;
//	}
//
//	// 메소드
//	// resize()메소드: SizeArray가 가득 차거나, 요소 개수가 용량의 절반미만인 경우 크기조정을 위해 사용
//	private void resize() {
//		// 현재 용적(=SizeArray의 길이)와 데이터 개수(size)를 비교
//		int array_capa = SizeArray.length;
//
//		// SizeArray = 0
//		// 배열 비교: Arrays.equals(arr1, arr2)메소드 (주소값X, 값을 비교)
//		if (Arrays.equals(SizeArray, EmptyArray)) {
//			// 사용자가 용량을 설정하지 않은경우, EmptyArray로 초기화 되어있음
//			// => 용적은 0인 상태
//			SizeArray = new Object[Default_capa];
//			// 새로 SizeArray의 용적을 할당하기 위해 최소 용적으로 설정해둔
//			// Default_capa의 크기만큼 배열 생성
//			return;
//		}
//
//		// 용량이 꽉 찬 경우 => 용량을 늘려야 함
//		if (size == array_capa) {	// 데이터 개수와 용적이 같은 경우
//			int new_capa = array_capa * 2;	// 새로운 용적을 현재 용적의 2배로 함
//			// copy
//			// Arrays.copyOf(복사할 배열, 용적의 크기)메소드: 배열을 새로운 길이로 복사
//			SizeArray = Arrays.copyOf(SizeArray, new_capa);
//			return;
//		}
//
//		// 용량의 절반 미만으로 요소가 차지하는 경우 => 공간 낭비
//		if (size < (array_capa / 2)) {	
//			int new_capa = array_capa / 2;	// 용적의 절반으로 줄여줌
//
//			// copy => 새로운 용적의 배열 생성
//			SizeArray = Arrays.copyOf(SizeArray, Math.max(new_capa, Default_capa));
//			return;
//		}
//	}
//
//	@Override
//	// add메소드 - 요소를 ArrayList의 끝에 추가
//	public boolean add(E value) {
//		// addLast()메소드를 호출하여 작업 수행
//		addLast(value);
//		return true;
//	}
//	
//	// addLast(E value): 가장 마지막 부분에 추가(기본값)
//	public void addLast(E value) {
//		// 꽉 찬 상태라면 용적 재할당
//		if (size == SizeArray.length) {
//			resize();	// resize메소드 사용
//		}
//		SizeArray[size] = value;	// 마지막 위치에 요소 추가
//		size++;		// 증감
//	}
//	
//	@Override
//	// add(int index, E value): 특정 위치에 추가
//	public void add(int index, E value) {
//		// 영역을 벗어날 경우 예외 발생
//		if(index > size || index < 0) {	// size를 벗어나는지, 음수 들어오는지
//			throw new IndexOutOfBoundsException();	// 예외발생
//		}
//		
//		// index가 마지막 위치라면 addLast 메소드로 요소추가
//		if (index == size) {	// index와 size가 같다 => 마지막 추가
//			addLast(value);
//		} else {	// 중간에 삽입되는 경우
//			// 꽉 차있다면 용적 재할당
//			if(size == SizeArray.length) {
//				resize();
//			}
//			// index기준 후자에 있는 모든 요소들 한 칸씩 뒤로밀기
//			for (int i = size; i >index; i--) {
//				SizeArray[i] = SizeArray[i-1];
//			}
//			// index위치에 요소 할당
//			SizeArray[index] = value;
//			size++;
//		}
//		
//	}
//	
//	// addFirst(E value): ArrayList의 첫번째 위치에 요소 추가
//	public void addFirst(E value) {
//		// 기존데이터가 있다면, 모든 데이터를 뒤로 밀어야 함
//		add(0, value);	// add()메소드 호출
//	}
//	
//	// get(int index)메소드 - 지정된 인덱스 요소 반환
//	@SuppressWarnings("unchecked")
//	// type safe에 대해 경고를 받음
//	@Override
//	public E get(int index) {
//		// 범위 벗어나면 예외 발생
//		if(index >= size || index < 0) {
//			throw new IndexOutOfBoundsException();
//		}
//		
//		// Object타입에서 E타입으로 캐스팅 후 반환
//		return (E) SizeArray[index];
//	}
//	
//	// set(int index, E value)메소드 - index에 위치한 데이터 교체
//	@Override
//	public void set(int index, E value) {
//		if(index >= size || index < 0) {
//			throw new IndexOutOfBoundsException();
//		} else {
//			//해당 위치의 요소를 교체
//			SizeArray[index] = value;
//		}
//	}
//	
//	// indexOf(Object value)메소드 - 찾고자 하는 요소value의 위치index 반환
//	@Override
//	public int indexOf(Object value) {
//		int i = 0;
//		
//		// value와 같은 객체(요소값)인 경우 i위치 반환
//		for (i=0; i<size; i++) {
//			if(SizeArray[i].equals(value)) {
//				return i;
//			}
//		}
//		//일치하는게 없는 경우 -1 반환
//		return -1;
//	}
//	
//	// 거꾸로 탐색
//	public int lastIndexOf(Object value) {
//		for(int i=size-1; i>=0; i--) {
//			if(SizeArray[i].equals(value)) {
//				return i;
//			}
//		}
//		//일치하는게 없는 경우 -1 반환
//		return -1;
//	}
//	
//	@Override
//	// contains(Object value)메소드 - 사용자가 찾고자하는 요소(value)가 존재하는지
//	public boolean contains(Object value) {
//		//0이상이면 요소가 존재한다는 뜻
//		if(indexOf(value) >=0) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	// remove(int index)메소드
//	@SuppressWarnings("unchecked")
//	@Override
//	public E remove(int index) {
//		
//		if (index >= size || index<0) {
//			throw new IndexOutOfBoundsException();
//		}
//		
//		// 삭제될 요소를 반환하기위해 임시로 담아둠
//		E element = (E) SizeArray[index];
//		SizeArray[index] = null;
//		
//		// 삭제한 요소의 뒤에 있는 모든 요소들을 한 칸씩 당겨옴
//		for (int i = index; i<size-1; i++) {
//			SizeArray[i] = SizeArray[i+1];
//			SizeArray[i+1] = null;
//		}
//		size--;
//		resize();
//		return element;
//	}
//	
//	// remove(Object value)메소드
//	@Override
//	public boolean remove(Object value) {
//		 
//		// 삭제하고자 하는 요소의 인덱스 찾기
//		int index = indexOf(value);
//	 
//		// -1이라면 array에 요소가 없다는 의미이므로 false 반환
//		if (index == -1) {
//			return false;
//		}
//	 
//		// index 위치에 있는 요소를 삭제
//		remove(index);
//		return true;
//	}
//	
//	// Size메소드 - ArrayList에 있는 요소의 개수를 반환
//	@Override
//	public int size() {
//		return size;	// 요소 개수 반환
//	}
//	
//	// isEmpty메소드 - 현재 ArrayList에 요소가 하나도없는지
//	@Override
//	public boolean isEmpty() {
//		return size == 0;	// 요소가 0개일 경우 비어있다는 의미이므로 true반환
//	}
//	
//	//clear메소드 - 모든 요소를 비워버리는 작업
//	@Override
//	public void clear() {
//		// 모든 공간을 null 처리 해준다. 
//		for (int i = 0; i < size; i++) {
//			SizeArray[i] = null;
//		}
//		size = 0;	// size를 0으로 재설정
//		resize();	// resize()메소드 호출하여 새로운 기본 용량의 배열 할당
//	}
//	
//	// 부록 메소드
//	//clone메소드 - 사용자가 사용하던 ArrayList를 하나 복제하고자 할 때 사용
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//	 
//		// 새로운 객체 생성
//		MyArrayList<?> cloneList = (MyArrayList<?>)super.clone();
//	 
//		// 새로운 객체의 배열도 생성해주어야 함 (객체는 얕은복사가 되기 때문)
//		cloneList.SizeArray = new Object[size];
//	 
//		// 배열의 값을 복사함
//		System.arraycopy(SizeArray, 0, cloneList.SizeArray, 0, size);
//	 
//		return cloneList;
//	}
//	
//	// toArray메소드 - 원본배열의 요소 size만큼 복사해서 Object배열 반환
//	public Object[] toArray() {
//		return Arrays.copyOf(SizeArray, size);
//	}
//		
//	 
//	@SuppressWarnings("unchecked")
//	// ArrayList의 요소를 지정된 배열a에 복사하여 반환하는 역할 수행
//	public <T> T[] toArray(T[] a) {
//		// T[]: 제네릭타입(T)를 사용하여 배열의 타입 지정
//		
//		// a배열의 길이가 ArrayList요소 개수보다 작으면
//		if (a.length < size) {
//			// copyOf(원본 배열, 복사할 길이, Class<? extends T[]> 타입)
//			return (T[]) Arrays.copyOf(SizeArray, size, a.getClass());
//			// 형변환 (T[]) 필요
//		}
//		// 원본배열, 원본배열 시작위치, 복사할 배열, 복사할배열 시작위치, 복사할 요소 수 
//		System.arraycopy(SizeArray, 0, a, 0, size);
//		// SizeArray의 0번째 인덱스부터 size 개수만큼 a 배열의 0번째 인덱스부터 복사
//		return a;
//	}
//
//}
//
//public class ArrayList_MethodOverload {
//	public static void main(String[] args) {
//		
//		// ArrayList 객체 생성
//		MyArrayList<Integer> arrayList = new MyArrayList<>();
//		
//		// 요소 추가
//		arrayList.add(10);
//		arrayList.add(20);
//		arrayList.add(30);
//
//		// ArrayList에 저장된 요소 출력
//		System.out.println("Original arrayList: " + arrayList);
//		
//		// toArray메소드 사용하여 요소들을 다른 배열에 복사
//		Integer[] newArray = new Integer[arrayList.size()];
//		newArray = arrayList.toArray(newArray);
//		
//		System.out.println("New Array: " + Arrays.toString(newArray));
//		
//		// index 1에 있는 요소를 25로 변경
////		arrayList.set(1, 25);
////		System.out.println("Updated arrayList: " + arrayList);
//	}
//}
