# Java Collections FrameWork

일정 타입의 데이터들이 모여 쉽게 가공 할 수 있도록 지원하는 자료구조들의 뼈대(기본 구조)


- 자바에서 제공하는 Collection은 크게 3가지 인터페이스
 - (Interface 자체가 기본 뼈대(추상구조)만 있음)


## List[리스트]

List Interface(리스트 인터페이스): 대표적인 선형 자료구조로 주로 순서가 있는 데이터를 목록으로 이용할 수 있도록 만들어진 인터페이스


### List Interface를 구현하는 클래스

1. ArrayList

- Object[] 배열을 사용하면서 내부 구현을 통해 동적으로 관리
- 최상위 타입인 Object 타입으로 배열을 생성하여 사용 => 요소 접근(access elements)에서는 탁월
- 중간의 요소가 삽입, 삭제가 일어나는 경우 그 뒤의 요소들은 한 칸씩 밀어야 하거나 당겨야 하기 때문에 삽입, 삭제에서는 비효율적


2. LinkedList

- 데이터(item)와 주소로 이루어진 클래스를 만들어 서로 연결하는 방식
- Node 객체로 연결해서 관리하는 방식: 데이터와 주소로 이루어진 클래스를 Node(노드)라고 하는데, 각 노드는 이전의 노드와 다음 노드를 연결하는 방식
- 해당 노드를 삭제, 삽입해야 할 경우 해당 노드의 링크를 끊거나 연결만 해주면 되기 때문에 삽입, 삭제에서는 매우 좋은 효율


3. Vector(+ Vector를 상속받은 Stack)

- 기본적으로 ArrayList와 거의 같음. Object[] 배열을 사용하며 요소 접근에서 빠른 성능

- '동기화'를 지원: 여러 쓰레드가 동시에 데이터에 접근하려하면 순차적으로 처리
 - 멀티 쓰레드에서는 안전하지만, 단일 쓰레드에서도 동기화를 하기 때문에 ArrayList에 비해 성능이 약간 느림


## Stack[스택]

- LIFO(Last in First out) 또는 후입선출
 - 가장 대표적인 예시로는 웹페이지 '뒤로가기'

- Stack의 경우 Vector클래스를 상속받음



## Queue[큐]

Queue Interface(큐 인터페이스): 선형 자료구조로 주로 순서가 있는 데이터를 기반으로 '선입선출(先入先出, FIFO : First-in First-out)'을 위해 만들어진 인터페이스
    
    Queue<T> arraydeque = new ArrayDeque<>();
    Queue<T> linkedlistdeque = new LinkedList<>();
    Queue<T> priorityqueue = new PriorityQueue<>();

- Stack(스택)과 많이 비교를 하는 자료구조
- 가장 앞쪽에 있는 위치를 head(헤드), 가장 후위(뒤)에 있는 위치를 tail(꼬리)

- 한쪽 방향으로만(단방향) 삽입 삭제가 가능


## Deque[덱]

 Queue를 상속하고 있는 Interface

    Deque<T> arraydeque = new ArrayDeque<>();
    Deque<T> linkedlistdeque = new LinkedList<>();

- Double ended Queue라는 의미로 양쪽에서 삽입삭제가 가능
 - head에서도 접근 가능하며, tail에서도 접근 가능한 양방향 큐(Queue에서 확장된 형태)



### Queue/Deque Interface를 구현하는 클래스

1. LinkedList
- 3가지 용도로 사용 가능: List, Deque, Queue
- Node 객체로 연결해서 관리하는 방식: 데이터와 주소로 이루어진 클래스를 Node(노드)라고 하는데, 각 노드는 이전의 노드와 다음 노드를 연결하는 방식

2. ArrayDeque

    ArrayDeque<T> arraydeque = new ArrayDeque<>();

- Object[] 배열로 구현되어 있음


3. PriorityQueue

    PriorityQueue<T> priorityqueue = new PriorityQueue<>();

- '데이터 우선순위'에 기반하여 우선순위가 높은 데이터가 먼저 나오는 원리
- 정렬방식을 지정하지 않는다면 낮은 숫자가 높은 우선순위를 가짐
- 주어진 데이터들 중 최댓값, 혹은 최솟값을 꺼내올 때 매우 유용하게 사용
- 단, 사용자가 정의한 객체를 타입으로 쓸 경우 반드시 Comparator 또는 Comparable을 통해 정렬 방식을 구현해줘야 함



## Set [셋 / 세트]

Set(세트)는 말 그대로 '집합'

- 데이터를 중복해서 저장할 수 없음
- 입력받은 순서와 상관없이 데이터를 집합시킴 => 입력 순서대로의 저장 순서를 보장하지 않음


### LinkedHashSet

순서 보장이 안된다는 불편함을 개선시키기 위해 만듦

만약 데이터 중복을 허용하고 싶지 않은데 입력 순서를 보장받고 싶다면 LinkedHashSet을 사용


### Set/SortedSet Interface를 구현하는 클래스

1. HashSet
- 가장 기본적인 Set 컬렉션의 클래스
- 입력 순서를 보장하지 않고, 순서도 마찬가지로 보장되지 않음
- hash에 의해 데이터의 위치를 특정시켜 해당 데이터를 빠르게 색인(search)할 수 있게 만든 것
- 삽입, 삭제, 색인이 매우 빠른 컬렉션 중 하나

ex) '닉네임'을 만든다거나 아이디를 생성할 때 '중복확인'을 눌러 중복된 닉네임 또는 아이디인지 확인하는 것
	=>  데이터가 정렬되어있을 필요도 없고, 빠르게 중복되는 값인지만 찾으면 되기 때문


2. LinkedHashSet
- Link + Hash + Set 이 결합된 형태
- 중복은 허용하지 않으면서 순서를 보장받고 싶은경우
- LRU 알고리즘(Least Recently Used Algorithm) -> 입력된(저장된) 순서를 알아야 오래된 캐시를 비울 수 있음

ex) 페이지를 열 때 만약 해당 페이지가 중복되경우 cache는 다시 적재할 필요는 없지만, 새로운 페이지를 할당해야 할 경우 최근에 사용되지 않은 cache을 비우고자 할 때, 가장 오래된 cache를 비우는 것이 현명


3. TreeSet
- Set Interface를 상속받은 SortedSet Interface를 구현
- 입력 순서대로의 저장 순서를 보장하지 않으며 중복 데이터 또한 넣지 못함
- 중복되지 않으면서 특정 규칙에 의해 정렬된 형태의 집합을 쓰고 싶을 때 사용: 데이터의 '가중치에 따른 순서'대로 정렬되어 보장
- 정렬된 형태로 있다보니 특정 구간의 집합요소들을 탐색할 때 매우 유용













