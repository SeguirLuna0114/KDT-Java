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

class RefTest02{
  public static void main(String[] args){
  Parent  p = new  Parent();  
  Child  c;                   
  //서브 클래스형 레퍼런스 변수에 슈퍼 클래스의 레퍼런스 값을 대입하면
  c = (Child)p;   //이를 DownCasting 이라하는데 컴파일러 에러가 발생한다. 
  c.parentPrn( );   //2개의 메소드 모두 호출 안됨.
  c.childPrn( );
 }  
}       