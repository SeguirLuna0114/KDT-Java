class TestClass {
  private Object member;
  public void setValue(Object value){
    member = value;
  }
   public Object getValue( ){  
    return member;    
  }                
}
class GenericTest02{  
  public static void main(String[] args) { 
   TestClass obj01=new TestClass();
   obj01.setValue(3);
   System.out.println("되돌리는 값은->"+obj01.getValue( ));

   obj01.setValue(3.4);
   System.out.println("되돌리는 값은->"+obj01.getValue( ));

   obj01.setValue("이해할 수 있다.");
   System.out.println("되돌리는 값은->"+obj01.getValue( ));

  }
}                                                                                    
