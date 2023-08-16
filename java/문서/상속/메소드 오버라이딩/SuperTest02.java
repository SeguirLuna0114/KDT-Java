class Point2D{
  protected int x=10;    
  protected int y=20;
}
class Point3D extends Point2D{
  protected int z=30;
  public void print( ){
    System.out.println(  x  +", "+y+", "+z);   //x와 y는 상속 받아 사용하는 멤버변수 
  }
}

class SuperTest02{
  public static void main(String[] args){
    Point3D pt=new Point3D( );
    pt.print( );
  }
}               