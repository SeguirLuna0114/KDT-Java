abstract class Hello{
  public abstract void sayHello(String name);
}
abstract class GoodBye{
  public abstract void sayGoodBye(String name);
}

class SubClass extends GoodBye, Hello {
  public void sayHello(String name){
      System.out.println(name+"씨 안녕하세요!");
  }
  public void sayGoodBye(String name){
      System.out.println(name+"씨 안녕히 가세요!");
  }
}
class AbstractTest03{
   public static void main(String[] args) {
     SubClass test= new SubClass();
     test.sayHello(args[0]);
     test.sayGoodBye(args[0]);
   }   
}                                                       
