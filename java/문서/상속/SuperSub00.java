class Point2D{
  private int x;
  private int y;
  public int getX( ){
     return x;
  }
  public void setX(int new_X){
    x=new_X;
  }
  public int getY( ){
     return y;
  }
  public void setY(int new_Y){
    y=new_Y;
  }
}
class Point3D extends Point2D{
  private int z;
  public int getZ( ){
     return z;
  }
  public void setZ(int new_Z){
    z=new_Z;
  }
}
class SuperSub00{
  public static void main(String[] args){

    Point3D  pt=new Point3D( );
    pt.setX(10); //상속받아 사용
    pt.setY(20); //상속받아 사용
    pt.setZ(30); //자신의 것 사용
    System.out.println( pt.getX( )//상속받아 사용 
               +", "+ pt.getY( )//상속받아 사용 
               +", "+ pt.getZ( ));//자신의 것 사용
  }
}