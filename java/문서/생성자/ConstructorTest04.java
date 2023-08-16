class MyDate{   
  int year;    
  int month;    
  int day;  

/*  public MyDate(){
    year=2023;    month=4;    day=1;
  }*/
 
  public MyDate(int year,int month,int day){
   this.year=year;
   this.month=month;
   this.day=day;
  }
  public void print(){
	System.out.println(year+ "/" +month+ "/" +day); 
  }
}// MyDate end

public class ConstructorTest04 {     
  public static void main(String[] args) {
    MyDate d=new MyDate();	
    d.print();

    MyDate d2=new MyDate(2023, 7, 19);
    d2.print();
  }
}            