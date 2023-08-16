//package Generic_ClassDef;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//// 제네릭(Generic): 데이터 타입의 안정성과 재사용성 증가를 위한 기능 
//// <E>: 타입 매개변수. 스택에 저장되는 요소의 타입을 나타냄
//// Node<E> 클래스: LinkedList 또는 tree와 같은 자료구조 구현시 표현
//class Node<E> {
//	
//	E data; 	// 노드가 저장하는 데이터 요소
//	Node<E> next;	// 다음 노드객체를 가리키는 레퍼런스 변수
//	
//	Node(E data) {
//		this.data = data;
//		this.next = null;
//	}
//}
//
//class SLinkedList<E> implements List<E> {
//	
//	// 필드
//	private Node<E> head;	// 노드의 첫부분
//	private Node<E> tail; 	// 노드의 마지막 부분
//	private int size;		// 리스트에 있는 요소 개수(연결된 노드의 개수)
//	
//	// 생성자
//	public SLinkedList() {
//		// 처음 단일 연결리스트 생성시에는 아무 데이터X
//		this.head = null;
//		this.tail = null;
//		this.size = 0;
//	}
//	
//	// 메소드
//	// search메소드 - 특정 위치의 노드를 반환하는 메소드
//	private Node<E> search(int index) {
//		
//		// 범위 밖일 경우 예외처리
//		if (index<0 || index >= size) {
//			throw new IndexOutOfBoundsException();
//		}
//		
//		Node<E> x = head;	// head가 가리키는 노드부터 시작
//		
//		for (int i = 0; i < index; i++) {
//			x = x.next;	// x노드의 다음 노드를 x에 저장한다
//		}
//		return x;
//		
//	}
//	
//// add메소드 구현
//	// addFirst(E value): 가장 앞부분에 추가
//	public void addFirst(E value) {
//		// 새로운 노드를 생성하고, 새 노드의 레퍼런스변수(next)가 head노드를 가리키게
//		Node<E> newNode = new Node<E>(value);	// 새 노드 생성
//		newNode.next = head;	// 새 노드의 다음 노드로 head노드 연결
//		head = newNode;			// head가 가리키는 노드를 새 노드로 변경
//		size++;
//
//		// 데이터가 새 노드밖에 없는 경우 => 데이터는 1개뿐 => head=tail
//		if (head.next == null) {
//			tail = head;
//		}
//
//	}
//	
//	@Override
//	public boolean add(E value) {
//		addLast(value);
//		return true;
//	}
//
//	// addLast(): 가장 마지막 부분에 추가(기본값)
//	public void addLast(E value) {
//		Node<E> newNode = new Node<E>(value); // 새 노드 생성
//
//		// 아무런 노드가 없는경우 -> 처음으로 데이터 추가 => addFirst()호출
//		if (size == 0) {
//			addFirst(value);
//			return;
//		}
//
//		// 노드가 존재하는 경우에는
//		// 마지막노드(tail)의 다음노드(next)가 새 노드를 가리키게
//		tail.next = newNode;
//		// tail이 가리키는 노드를 새 노드로 바꿈
//		tail = newNode;
//		size++;
//	}
//
//
//	@Override
//	// add(): 특정 위치에 추가
//	public void add(int index, E value) {
//
//		// 잘못된 인덱스 참조하는 경우 예외 발생
//		if (index > size || index < 0) {
//			throw new IndexOutOfBoundsException();
//		}
//		
//		// 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출
//		if (index == 0) {
//			addFirst(value);
//			return;
//		}
//		
//		// 추가하려는 index가 마지막 위치일 경우 addLast 호출
//		if (index == size) {
//			addLast(value);
//			return;
//		}
//		
//		// 추가하려는 위치의 이전 노드 
//		Node<E> prev_Node = search(index - 1);
//		// 추가하려는 위치의 노드
//		Node<E> next_Node = prev_Node.next;
//		// 추가하려는 노드
//		Node<E> newNode = new Node<E>(value);	
//
//		// 이전 노드가 가리키는 노드를 끊음
//		prev_Node.next = null;
//		// 새 노드로 변경
//		prev_Node.next = newNode;
//		// 새 노드가 가리키는 노드는 next_Node로 설정
//		newNode.next = next_Node;
//		size++;
//
//	}
//	
//// remove메소드 구현(add메소드의 반대 메커니즘)
//	// remove(): 가장 앞의 요소(head)삭제
//	public E remove() {
//		// head가 가리키는 노드의 링크와 데이터를 null로 지워줌
//
//		Node<E> headNode = head;
//
//		if (headNode == null)
//			throw new NoSuchElementException();
//		
//		// 삭제된 노드를 반환하기 위한 임시 변수
//		E element = headNode.data;
//		
//		// head의 다음 노드
//		Node<E> nextNode = head.next;
//		
//		// head 노드의 데이터들을 모두 삭제
//		head.data = null;
//		head.next = null;
//		
//		// head 가 다음 노드를 가리키도록 업데이트
//		head = nextNode;
//		size--;
//
//		// 삭제된 요소가 리스트의 유일한 요소였을 경우, 그 요소는 head=tail
//		if(size == 0) {
//			tail = null;
//		}
//		return element;
//	}
//
//	// remove(int index): 특정 index의 요소 삭제
//	@Override
//	public E remove(int index) {
//
//		// 삭제하려는 노드가 첫 번째 원소일 경우
//		if (index == 0) {
//			return remove();
//		}
//
//		// 잘못된 범위에 대한 예외 
//		if (index >= size || index < 0) {
//			throw new IndexOutOfBoundsException();
//		}
//		
//		// 삭제할 노드의 이전 노드
//		Node<E> prevNode = search(index - 1);
//		// 삭제할 노드
//		Node<E> removedNode = prevNode.next;
//		// 삭제할 노드의 다음 노드
//		Node<E> nextNode = removedNode.next;
//
//		// 삭제되는 노드의 데이터를 반환하기 위한 임시변수
//		E element = removedNode.data;
//		
//		// 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음노드로 변경
//		prevNode.next = nextNode;
//		
//		// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
//		if(prevNode.next == null) {
//			tail = prevNode;
//		}
//		
//		// 데이터 삭제
//		removedNode.next = null;
//		removedNode.data = null;
//		size--;
//
//		return element;
//	}
//
//	// remove(Object value): 특정 요소를 삭제
//	@Override
//	public boolean remove(Object value) {
//		Node<E> prevNode = head;
//		boolean hasValue = false;
//		Node<E> x = head;	// removedNode 
//		
//		// value 와 일치하는 노드를 찾는다.
//		for (; x != null; x = x.next) {
//			if (value.equals(x.data)) {
//				hasValue = true;
//				break;
//			}
//			prevNode = x;
//		}
//
//		// 일치하는 요소가 없을 경우 false 반환
//		if(x == null) {
//			return false;
//		}
//		
//		// 만약 삭제하려는 노드가 head라면 기존 remove()를 사용
//		if (x.equals(head)) {
//			remove();
//			return true;
//		}
//		else {
//			// 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
//			prevNode.next = x.next;
//			
//			// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
//			if(prevNode.next == null) {
//				tail = prevNode;
//			}
//			x.data = null;
//			x.next = null;
//			size--;
//			return true;
//		}
//	}
//
//	@Override
//	public E get(int index) {
//		return search(index).data;
//	}
//
//	@Override
//	public void set(int index, E value) {
//		Node<E> replaceNode = search(index);
//		replaceNode.data = null;
//		replaceNode.data = value;
//	}
//
//	@Override
//	public boolean contains(Object item) {
//		return indexOf(item) >= 0;
//	}
//
//	@Override
//	public int indexOf(Object o) {
//		int index = 0;
//		if (o == null) {
//			for (Node<E> x = head; x != null; x = x.next) {
//				if (x.data == null)
//					return index;
//				index++;
//			}
//		} else {
//			for (Node<E> x = head; x != null; x = x.next) {
//				if (o.equals(x.data))
//					return index;
//				index++;
//			}
//		}
//		// 찾고자 하는 요소를 찾지 못했을 경우 -1 반환
//		return -1;
//	}
//
//	@Override
//	public int size() {
//		return size;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return size == 0;
//	}
//
//	@Override
//	public void clear() {
//		for (Node<E> x = head; x != null;) {
//			Node<E> next = x.next;
//			x.data = null;
//			x.next = null;
//			x = next;
//		}
//		head = tail = null;
//		size = 0;
//	}
//
//	public Object clone() {
//
//		try {
//			@SuppressWarnings("unchecked")
//			SLinkedList<? super E> clone = (SLinkedList<? super E>) super.clone();
//
//			clone.head = null;
//			clone.tail = null;
//			clone.size = 0;
//
//			for (Node<E> x = head; x != null; x = x.next) {
//				clone.addLast(x.data);
//			}
//
//			return clone;
//		} catch (CloneNotSupportedException e) {
//			throw new Error(e);
//		}
//	}
//	
//	public Object[] toArray() {
//		Object[] array = new Object[size];
//		int idx = 0;
//		for (Node<E> x = head; x != null; x = x.next) {
//			array[idx++] = (E) x.data;
//		}
//		return array;
//	}
//
//	@SuppressWarnings("unchecked")
//	public <T> T[] toArray(T[] a) {
//		if (a.length < size) {
//			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
//		}
//		int i = 0;
//		Object[] result = a;
//		for (Node<E> x = head; x != null; x = x.next) {
//			result[i++] = x.data;
//		}
//		if (a.length > size) {
//			a[size] = null;
//		}
//		return a;
//	}
//	
//	public void sort() {
//		sort(null);
//	}
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public void sort(Comparator<? super E> c) {
//		Object[] a = this.toArray();
//		Arrays.sort(a, (Comparator) c);
//
//		Iter it = (SLinkedList<E>.Iter) this.iterator();
//		for(Object e : a) {
//			it.next();
//			it.set((E) e);
//		}
//	}
//		
//	@Override
//	public Iterator<E> iterator() {
//		return new Iter();
//	}
//
//	private class Iter implements Iterator<E> {
//
//		private int nowIndex = 0;
//		private Node<E> nextNode = head;
//		private Node<E> nowNode;
//
//		@Override
//		public boolean hasNext() {
//			return nowIndex < size;
//		}
//
//		@Override
//		public E next() {
//			int cs = nowIndex;
//			if (cs >= size) {
//				throw new NoSuchElementException();
//			}
//			nowNode = nextNode;
//			nextNode = nextNode.next;
//			nowIndex = cs + 1;
//			return (E) nowNode.data;
//		}
//
//		public void set(E e) {
//			if(nowNode == null) {
//				throw new IllegalStateException();
//			}
//			nowNode.data = e;
//		}
//		
//		public void remove() {
//			throw new UnsupportedOperationException();
//		}
//
//	}
//}
//
//class Student {
//	String name;
//	int score;
//	
//	Student(String name, int score){
//		this.name = name;
//		this.score = score;
//	}
//	
//	public String toString() {
//		return "이름 : " + name + "\t성적 : " + score;
//	}
//}
//
//public class Stack {
//	
//	// 사용자 설정 comparator(비교기)
//	static Comparator<Student> customComp = new Comparator<Student>() {
//		@Override
//		public int compare(Student o1, Student o2) {
//			return o2.score - o1.score;
//		}
//	}
//	
//	public static void main(String[] args) {
//		SLinkedList<Student> list = new SLinkedList<>();
//		 
//		list.add(new Student("김자바", 92));
//		list.add(new Student("이시플", 72));
//		list.add(new Student("조시샵", 98));
//		list.add(new Student("파이손", 51));
//		
//		list.sort(customComp);	// Comparator을 파라미터로 넘겨준다.
//		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
//}
