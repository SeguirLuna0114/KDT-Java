class MyDate{   
  private int year;    
  private int month;    
  private int day;

  public MyDate(){
  }
  public MyDate(int new_year, int new_month, int new_day){
    year=new_year;
    month=new_month;
    day=new_day;
  }  
  public void print(){
    System.out.println(year+ "/" +month+ "/" +day); 
  }
}
public class ConstructorTest05 {     
  public static void main(String[] args) {
    MyDate d=new MyDate();  
    d.print();

    MyDate d2=new MyDate(2023, 7, 19);
    d2.print();
  }
}      