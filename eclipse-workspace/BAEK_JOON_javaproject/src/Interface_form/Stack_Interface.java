package Interface_form;

/*
 * 자바 stack Interface
 */

public interface Stack_Interface<E> {
	
	/*
	 * push()메소드: 스택의 맨 위에 요소를 추가
	 * @param item 스택에 추가할 요소
	 * @return 스택에 추가된 요소
	 */
	E push(E item);
	
	/*
	 * pop()메소드: 스택의 맨 위에 있는 요소를 제거하고, 제거된 요소를 반환
	 * @return 제거된 요소
	 */
	E pop();
	
	/*
	 * peek()메소드: 스택의 맨 위에 있는 요소를 제거하지 않고, 반환
	 * @return 스택의 맨 위에있는 요소
	 */
	E peek();
	
	/*
	 * search()메소드:
	 * 스택의 상단 부터 특정 요소가 몇번째 위치에 있는지를 반환
	 * 중복되는 원소가 있는 경우에는, 가장 위에있는 요소의 위치가 반환됨
	 * @param value 스택에서 위치를 찾을 요소
	 * @return 스택의 상단부터 처음으로 요소와 일치하는 위치를 반환.
	 * 			만일 일치하는 요소가 없는 경우 -1을 반환
	 */
	int search(Object value);
	
	/* 
	 * size()메소드: 스택의 요소 개수 반환
	 * @return 스택에 있는 요소의 개수 반환
	 */
	int size();
	
	/*
	 * clear()메소드: 스택에 있는 모든 요소를 삭제
	 */
	void clear();
	
	/*
	 * 스택에 요소가 비어있는지를 반환
	 * @return 스택에 요소가 없을 경우 {@code true},
	 * 			그 외의 경우 {@code false} 반환
	 */
	boolean empty();
	
}
