class MyDate{   
  private int year;    
  private int month;    
  private int day;

  public  MyDate(){
    System.out.println("[생성자] : 객체가 생성될 때 자동 호출됩니다.");
  }  
  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}// MyDate end

public class ConstructorTest02 {     
  public static void main(String[] args) {
    MyDate d =  new MyDate();	
    d.print();
//	System.out.println(d.year);
//	MyDate dd =  new MyDate();
 }
} 