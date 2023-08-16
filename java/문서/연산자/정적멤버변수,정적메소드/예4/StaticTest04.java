class StaticTest{
  private static int a=10;
  private int b=20;
  public static void printA(){  
    System.out.println(a);         
    System.out.println(b);   //컴파일 에러 발생
  }

  public void printB(){        
    System.out.println(b);     
  }                           
}
public class StaticTest04 {
  public static void main(String[] args) {
    StaticTest.printA();  
    StaticTest s1 = new StaticTest();
    StaticTest s2 = new StaticTest();
    s1.printB();
    s2.printB();
  }    
}    