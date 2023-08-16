class Point2D{
  protected int x=10; //은닉 변수
  protected int y=20; //혹은 쉐도우 변수 
}
class Point3D extends Point2D{
  protected int x=40; //슈퍼 클래스에 존재하는 멤버변수를 
  protected int y=50; //서브 클래스에 다시 한 번 정의함

  protected int z=30;
  public void print( ){
    System.out.println(  x  +", "+y+", "+z);   //x와 y는 재 정의된 Point3D 클래스 소속
  }
  public void print02( ){
    System.out.println(super.x+", "+super.y+", "+z); //Point2D 클래스 소속 멤버변수로 접근
  }
}
class SuperTest04{
  public static void main(String[] args){
    Point3D pt=new Point3D( );
    pt.print( );   //40, 50, 30 // Point3D의 x, y
    pt.print02( ); //10, 20, 30 // Point2D의 x, y
  }
}              