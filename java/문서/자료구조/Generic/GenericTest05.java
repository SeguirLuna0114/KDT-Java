class GenericClass<T> {
  private T member;
  public void setValue(T value){
    member = value;
  }                                
   public T getValue( ){  
    return member;    
  }                
}
class GenericTest05{  
  public static void main(String[] args) { 
     GenericClass<Double> obj01=new GenericClass<Double>();
     obj01.setValue(3.4);
     System.out.println("되돌리는 값은->" + obj01.getValue( ));

     GenericClass<Integer> obj02=new GenericClass<Integer>( );
     obj02.setValue(new Integer(10));
     System.out.println("되돌리는 값은->" + obj02.getValue( ));

     GenericClass<String> obj03=new GenericClass<String>( );
     obj03.setValue("이해할 수 있다.");
     System.out.println("되돌리는 값은->" + obj03.getValue( ));
  }
}     