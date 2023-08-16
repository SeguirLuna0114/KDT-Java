class Point2D{
  protected int x=10;     //  private int x=10;
}
class Point3D extends Point2D{
  protected int z=30;
  public void print( ){
    System.out.println(  x  +", "+y+","+z);   
  }
}

class SuperSub04{
  public static void main(String[] args){
    Point3D pt=new Point3D( );
    pt.print( );
  }
}