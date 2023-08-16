interface IHello{
  int a=10;
  public abstract void sayHello(String name);
}
interface IGoodBye{
  public abstract void sayGoodBye(String name);
}
interface ITotal extends IHello, IGoodBye{
  public abstract void greeting(String name);
}

class SubClass implements ITotal{
  public void sayHello(String name){
    System.out.println(name+"씨 안녕하세요!");
  }
  public void sayGoodBye(String name){
    System.out.println(name+"씨 안녕가세요!");
  }
  public void greeting(String name){
    System.out.println(name + ", 안녕!");
  }
}

class AbstractTest06{
  public static void main(String[] args) {
    SubClass test= new SubClass();
    test.sayHello(args[0]);
    test.sayGoodBye(args[0]);
    test.greeting(args[0]);
  }
}         