import java.util.*;
class HashTableTest02{
  public static void main(String[] args) {
    Hashtable<String, String> ht= new Hashtable<String, String>( );
    ht.put("사과", "Apple");
    ht.put("딸기", "StrawBerry");
    ht.put("포도", "Grapes");         
    // 해쉬 테이블의 값을 키를 이용하여 얻는다.
    String Val = ht.get("포도");   
    if(Val != null) {
      System.out.println("포도-> " + Val);
    }  
    Enumeration<String> Enum = ht.keys();  //해쉬 테이블의 키 요소들에 대한 Enumeration 객체 반환
    while(Enum.hasMoreElements()){     
      String  k = Enum.nextElement();  
      String  v = ht.get(k);             
      System.out.println(k + " : "+ v ); 
    }
  }    
} 