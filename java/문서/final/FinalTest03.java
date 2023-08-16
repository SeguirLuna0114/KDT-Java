package p2021_06_24;

// 상속을 허용하지 않는다.
final class FinalClass{				// 부모 클래스
  String str="Java ";
    public void setStr(String s){
      str=s;
    System.out.println(str);
  }
}
class FinalEx extends FinalClass{   // 자식 클래스  
   int a=10; 
   public void setA(int a)  {
    this.a=a;
   }
   public void setStr(String s){
    str+=s;
    System.out.println(str);
   }
}
public class FinalTest03{
   public static void main(String[] args) {
    FinalEx fe= new FinalEx( );
   }   
}          