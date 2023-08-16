package p2023_07_20;

// 정적 멤버(Static Member)
// : 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드
// 정적 필드: 객체 없이 클래스만으로도 사용가능한 필드(static이 붙은 필드)
// 정적 메소드: 객체 없이 "클래스.메소드" 만으로도 호출 가능한 메소드(static이 붙은 메소드)
public class UseNoneObject_StaticMem {

    public static void main( String[] args ) {
    
    // 정적 멤버도 객체를 생성해서 접근 가능
    NoneObject_StaticMem no = new NoneObject_StaticMem();
    System.out.println("no.number = " + no.number);
    no.printNumber();
    
    // 정적필드와 정적 메소드는 객체를 생성하지 않고도,
    // 정적필드를 가진 클래스명과 함께 도트 연산자(.)로 접근 가능
    
    // 정적필드로 접근하여 출력 : 클래스명.정적필드명
    System.out.println("NoneObject.number = " + 
									NoneObject_StaticMem.number);
    
    // 정적 메소드를 호출해서 실행 : 클래스.정적메소드명
    NoneObject_StaticMem.printNumber();	// 클래스명.메소드 방식으로 호출
    
    }
}    