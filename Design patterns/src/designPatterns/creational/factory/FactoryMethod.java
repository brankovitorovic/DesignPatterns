package designPatterns.creational.factory;


enum CoordinateSystem
{
  CARTESIAN,
  POLAR
}

class Point
{
  private double x, y;

  protected Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  // factory method
  public static Point newCartesianPoint(double x, double y)
  {
    return new Point(x,y);
  }

  public static Point newPolarPoint(double rho, double theta)
  {
    return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
  }
  
  @Override
  public String toString() {
	return "Point [x=" + x + ", y=" + y + "]";
  }
}

class FactoryMethod
{
  public static void main(String[] args)
  {
    Point point1 = Point.newCartesianPoint(1, 2);
    System.out.println(point1);
  }
}