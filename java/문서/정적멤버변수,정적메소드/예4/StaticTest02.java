class StaticTest{
  private static int a=10;
  private int b=20;
  
  public static void setA(int new_a){  
     a = new_a;
  }
  public static int getA(){
    return a;
  }
}
public class StaticTest02 {
  public static void main(String[] args) {
  System.out.println(StaticTest.a);//a가 private으로 선언되어서 컴파일 에러 발생 
    System.out.println(StaticTest.getA());  

    StaticTest s1=new StaticTest();
    StaticTest s2=new StaticTest();
  
    s1.setA(10000);
    int res1=s1.getA();
    System.out.println(res1);
    System.out.println(s2.getA());
 }    
}              