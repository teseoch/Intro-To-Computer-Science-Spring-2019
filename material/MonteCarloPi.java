public class MonteCarloPi
{
	public static void main(String[] args)
	{
		long hits = 0;
		long trials = 0;

		while(true)
		{
			double x = Math.random();
			double y = Math.random();
			trials++;

			if(x*x + y*y < 1){
				hits++;
			}

			if(trials % 10000000 == 0)
				System.out.println((4.0 * hits)/trials);
		}
	}
}