import java.util.Scanner;

public class Triangle
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("V1");
		double x1 = scanner.nextDouble();
		double y1 = scanner.nextDouble();

		System.out.println("V2");
		double x2 = scanner.nextDouble();
		double y2 = scanner.nextDouble();

		System.out.println("V3");
		double x3 = scanner.nextDouble();
		double y3 = scanner.nextDouble();

		double ax = x2-x3;
		double ay = y2-y3;

		double bx = x1-x3;
		double by = y1-y3;

		double cx = x1-x2;
		double cy = y1-y2;

		double a = Math.sqrt(ax*ax+ay*ay);
		double b = Math.sqrt(bx*bx+by*by);
		double c = Math.sqrt(cx*cx+cy*cy);

		double A = Math.acos((a*a-b*b-c*c)/(-2*b*c));
		A *= 180.0/Math.PI;

		System.out.println("angle A: " + A);
		
		double area = Math.abs(cx*by - cy*bx)/2.0;

		System.out.println("area: "+ area);

		boolean isCollinear = area < 1e-10;

		if(isCollinear){
			System.out.println("Collinear!");
		} else {
			System.out.println("Not collinear!");
		}

	}
}
