class Parent{
  public void parentPrn( ){
     System.out.println("슈퍼 클래스 : ParentPrn 메서드");  
  }
}
//Parent를 슈퍼 클래스로 하는 서브 클래스 Child 정의 
class Child extends Parent{
  //슈퍼 클래스에 있는 ParentPrn 메서드를 오버라이딩하면 
  //Child로 선언된 객체는 슈퍼 클래스의 메서드가 은닉되어 상속 받지 못하게 된다. 
  public void parentPrn( ){
     System.out.println("서브 클래스 : ParentPrn 메서드");  
  }
  public void childPrn( ){
     System.out.println("서브 클래스 : ChildPrn 메서드");  
 }                                             
}

class SuperSub05{
  public static void main(String[] args){
    Child c = new Child( );  	//서브 클래스로 객체를 생성
    c.parentPrn( );          	//오버라이딩된 서브 클래스의 메서드 호출 
    c.childPrn( );             	//서브 클래스 자기 자신의 메서드 호출
    System.out.println("-------------------------------------------->> ");  
    Parent p = new Parent( );	//슈퍼 클래스로 객체를 생성
    p.parentPrn( );            	//슈퍼 클래스(자기 자신)의 메서드 호출
  }                                           
}                                                                                      
