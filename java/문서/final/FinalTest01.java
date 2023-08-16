package p2021_06_24;

class FinalMember {
  final int a=10;		// 상수
  public void setA(int a){
    this.a=a;
  }
}

public class FinalTest01{
  public static void main(String[] args) {
    FinalMember ft= new FinalMember();
	final int a=1000;
    ft.setA(100);
    System.out.println(a);
  }
}                                                    
