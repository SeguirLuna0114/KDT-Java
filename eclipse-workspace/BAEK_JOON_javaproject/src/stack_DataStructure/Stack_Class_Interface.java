package stack_DataStructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EmptyStackException;

import Interface_form.Stack_Interface;

public class Stack_Class_Interface<E> implements Stack_Interface<E> {

	// 최소 CAPA는 10으로 설정됨(기본 용적 크기)
	private static final int DEFAULT_CAPACITY = 10;
	// 빈 배열
	private static final Object[] EMPTY_ARRAY = {};
	
	// 요소를 담을 배열
	private Object[] array;
	// 요소 개수
	private int size;
	
	// 기본 생성자(초기공간 할당X)
	public Stack_Class_Interface() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	
	// 매개변수 생성자 - 초기공간 할당O
	public Stack_Class_Interface(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	// resize()메소드 - size가 capacity에 얼마만큼 차 있는지 확인하고, 적절한 크기에 맞게 배열의 용적 변경
	private void resize() {
		// 빈 배열의 경우(capacity = 0)
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		
		// 현재 용적의 크기
		int arrayCapacity = array.length;
		
		// 용적이 가득 찰 경우
		if(size == arrayCapacity) {
			int newSize = arrayCapacity * 2;
			
			// 배열 복사
			array = Arrays.copyOf(array,newSize);
			return;
		}
		
		// 용적의 절반 미만으로 요소가 차지하는 경우
		if (size < (arrayCapacity / 2)) {
			int newCapacity = (arrayCapacity / 2);
			
			// 배열 복사
			array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
			return;
		}
	}
	
	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		if (size == array.length) {
			resize();
		}
		// 요소의 마지막 위치에 추가
		array[size] = item;
		size++;		// 사이즈 1 증가
		
		return item;
	}

	@Override
	public E pop() {
		// 만약 삭제할 요소가 없다면, stack이 비어있다는 의미 => 예외발생
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		@SuppressWarnings("unchecked")
		/* 
		 	ClassCastException이 뜨지 않으니 이 경고들을 무시하겠다는 것
			type safe(타입 안정성):  Object -> E 타입으로 변환
			push하여 받아들이는 데이터 타입은 유일하게 E 타입만 존재 => 형 안정성이 보장됨
		 */
		E obj = (E) array[size-1];		// 삭제할 요소 반환하기 위한 임시 변수
		
		// 반환된 요소 삭제
		array[size - 1] = null;
		
		size--;		// 사이즈 1 감소
		resize();	// 용적 재할당
		
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		// 만약 삭제할 요소가 없다면, stack이 비어있다는 의미 => 예외발생
		if(size == 0) {
			throw new EmptyStackException();
		}
		return (E) array[size-1];
		// 항상 마지막 원소의 인덱스는 size 보다 1 작음
	}

	@Override
	public int search(Object value) {
		/* 찾으려는 데이터가 상단의 데이터로부터 얼마만큼 떨어져 있는지'에 대한 상대적 위치 값
			Top으로부터 떨어져있는 거리를 의미한다.(단, 1부터 시작)( size - index )
			value가 null일 때는 eqauls(null)이되어 null pointer exception이 발생할 수 있으니,
			== 로 null값을 비교해준다.*/
		if(value == null) {
			for(int idx = size - 1; idx >= 0; idx--) {
				if(array[idx] == null) {
					// top으로부터 떨어진 거리
					return size - idx;
				}
			}
		} else {
			for(int idx = size - 1; idx >= 0; idx--) {
				// 같은 객체를 찾았을 경우 size - idx 값을 반환 
				if(array[idx].equals(value)) {
					return size - idx;
				}
			}
		}
		return -1;
	}

	@Override
	public int size() {
		// 현재 Stack에 있는 요소의 개수
		return size;
	}

	@Override
	public void clear() {
		// 모든 요소들을 비워버리는 작업(초기화)
		// 저장되어있던 모든 요소를 null 처리 해준다.
		for(int i = 0; i < size; i++) {
			array[i] = null;
		}
		// 요소가 0개라는 말로 size 또한 0으로 초기화
		size = 0;
		// 배열의 용적 또한 현재 용적의 절반(용적량은 10부터 2씩 곱해지므로)
		resize();
	}

	@Override
	public boolean empty() {
		// Stack이 비어있는지, 즉 요소가 한 개도 남아있지 않은지를 true 또는 false로 반환
		// size 변수가 0이면 데이터가 없다는 뜻
		return size == 0;
	}

		
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		// 새로운 스택 객체 생성 
		Stack_Class_Interface<?> cloneStack = (Stack_Class_Interface<?>) super.clone();
		
		// 새로운 스택의 배열도 생성해주어야 함(내부 객체는 깊은 복사가 되지 않기 때문)
		cloneStack.array = new Object[size];
		
		// 현재 배열을 새로운 스택의 배열에 값을 복사함 
		System.arraycopy(array, 0, cloneStack.array, 0, size);
		return cloneStack;
	}
 
	
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}
	
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(array, size, a.getClass());
 
        System.arraycopy(array, 0, a, 0, size);
 
        return a;
    }
    
    
	public void sort() {
		/**
		 *  Comparator를 넘겨주지 않는 경우 해당 객체의 Comparable에 구현된
		 *  정렬 방식을 사용한다.
		 *  만약 구현되어있지 않으면 cannot be cast to class java.lang.Comparable
		 *  에러가 발생한다.
		 *  만약 구현되어있을 경우 null로 파라미터를 넘기면
		 *  Arrays.sort()가 객체의 compareTo 메소드에 정의된 방식대로 정렬한다.
		 */
		sort(null);
	}
 
	@SuppressWarnings("unchecked")
	public void sort(Comparator<? super E> c) {
		Arrays.sort((E[]) array, 0, size, c);
	}
    
}
