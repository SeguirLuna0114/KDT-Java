package p2023_07_20;

// 정적 멤버(Static Member)
// : 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드
public class NoneObject_StaticMem {
	
    static int number = 3;	// 정적 필드
    
    public static void printNumber() {	// 정적 메소드
        System.out.println("number = " + number);
    }
}            