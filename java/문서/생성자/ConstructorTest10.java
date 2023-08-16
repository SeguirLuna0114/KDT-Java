class MyDate{   

  private int year;    
  private int month;    
  private int day;

  public MyDate(){
    this(2023, 1, 1);                   
  }  
  public MyDate(int new_year){
    this(new_year, 1, 1);                
  }  
  public MyDate(int new_year, int new_month){
     this(new_year, new_month, 1);    
  }  
public MyDate(int new_year,int new_month,int new_day){
    year=new_year;
    month=new_month;
    day=new_day;
  }    

  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}

public class ConstructorTest10 {     
  public static void main(String[] args) {
    MyDate d=new MyDate(2023, 7, 19);  
    d.print();
    MyDate d2=new MyDate(2023, 7);     
    d2.print();
    MyDate d3=new MyDate(2023);       
    d3.print();
    MyDate d4=new MyDate();          
    d4.print();
  }
}