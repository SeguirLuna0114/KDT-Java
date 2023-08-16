package p2023_07_20;

//정적 멤버(Static Member)
//: 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드
//정적 필드: 객체 없이 클래스만으로도 사용가능한 필드(static이 붙은 필드)
//정적 메소드: 객체 없이 "클래스.메소드" 만으로도 호출 가능한 메소드(static이 붙은 메소드)

// 정적필드는 모든 인스턴스에 대해 "업데이트"되어 반영됨
// (정적(static) 필드는 해당 클래스의 모든 인스턴스들 사이에서 공유됨)
public class Shared_StaticField_updated {
	
	// StaticCount_StatField클래스내에 정의된 정적 필드 number에 접근
    public static void main( String[] args ) {
    
    	// 정적 멤버도 객체를 생성해서 접근 가능
        StaticCount_StatField sc1 = new StaticCount_StatField();
        System.out.println("sc1.number = " + sc1.number);	// 3
        
        // 생성한 객체를 이용하여 정적필드에 접근 - 객체.정적필드명
        sc1.number++;	// number값을 1 증가시킴
        System.out.println("sc1.number = " + sc1.number);	// 4
        
        // 객체를 생성해서 접근(증가시킨 값이 그대로 반영됨)
        StaticCount_StatField sc2 = new StaticCount_StatField();
        System.out.println("sc2.number = " + sc2.number);	// 4
        
        // 생성한 객체를 이용하여 정적필드에 접근 - 객체.정적필드명
        sc2.number++;	// number값을 1 증가시킴
        System.out.println("sc2.number = " + sc2.number);	// 5
        
        // 해당 클래스명으로 접근 - 클래스명.정적필드명
        StaticCount_StatField.number++;	// number값을 1 증가시킴
        System.out.println(StaticCount_StatField.number); 	// 6
    }
}
            
        
        
        