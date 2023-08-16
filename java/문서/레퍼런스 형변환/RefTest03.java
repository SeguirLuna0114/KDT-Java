 class Parent{
  public void parentPrn( ){
     System.out.println("슈퍼 클래스 : ParentPrn 메서드");  
  }
}
class Child extends Parent{ 
  public void childPrn( ){
     System.out.println("서브 클래스 : ChildPrn 메서드");  
 }                                             
}
 class RefTest03{
  public static void main(String[] args){
  Parent  p = new  Child( );  //서브 클래스로 인스턴스 선언
  p.parentPrn();               
 //p.childPrn();//-컴파일 에러
  Child  c;                   //서브 클래스로 레퍼런스 변수 선언
  System.out.println("---------------->>");
  //서브 클래스 레퍼런스 변수에 슈퍼 클래스의 레퍼런스 값이 대입됨
  c = (Child) p;   //강제 형변환으로 다운 캐스팅
  c.parentPrn();               
  c.childPrn();
 }  
}