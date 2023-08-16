import java.util.*;

public class MapTest {
    public static void main( String[] args ) {
        //HashMap 객체 생성
//		Map hm = new HashMap();
        HashMap hm = new HashMap();
        //키와 데이터 쌍을 삽입
        hm.put( "woman", "gemini" );
        hm.put( "man", "johnharu" );
        hm.put( "age", new Integer(10) );
        hm.put( "city", "seoul" );
        
        //HashMap에 있는 객체들을 출력
        System.out.println( hm );
        
        //키 값만 출력
        System.out.println( hm.keySet() );
        
        //키를 이용해 해당 데이터를 출력
        System.out.println( hm.get( "woman" ));
        System.out.println( hm.get( "city" ));
    }
}        
         
         
        