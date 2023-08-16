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
class RefTest01{
  public static void main(String[] args){
    Child c = new Child();  
     
    c.parentPrn();   
    c.childPrn();    
    Parent p;       
    p=(Parent)c;    //암시적으로 업 캐스팅이 일어남
    p.parentPrn(); //업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있다,
// p.childPrn(); //컴파일 에러가 발생하게 된다. 
  }                                           
}       