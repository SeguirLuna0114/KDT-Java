class Point2D{
  protected int x=10;
  protected int y=20;
  /*
  public Point2D( ){
    System.out.println("슈퍼 클래스인 Point2D 생성자 호출");
  }
  */
  public Point2D(int xx, int yy){
  x=xx; y=yy;
  }
}
class Point3D extends Point2D{
  protected int z=30;
  public void print( ){
  System.out.println(x+", "+y+","+z);
  }
  public Point3D( ){
    System.out.println("서브 클래스인 Point3D 생성자 호출");
  }
}
class SuperTest06{
  public static void main(String[] args){
     Point3D pt=new Point3D( );
    pt.print( );
  }
}