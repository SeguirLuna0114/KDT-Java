package p2023_07_28;

// 'abstract'키워드를 사용하여 추상클래스 선언/정의
public abstract class AbsClass_abstract {
	
	// 필드
	int a;
	
	// 추상메소드 - 'abstract'키워드를 사용해서 선언/정의
	// : 메소드 이름만 있고, 내용이 없는 메소드
	public abstract void check();	// 내용이 없기에 {} 사용X
	
	// 일반메소드
	public void check01() {
		System.out.println("일반 메소드");
	}

}
