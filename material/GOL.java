public class GOL
{
	public static final String DEAD_SYM = "  ";
	public static final String ALIVE_SYM = "\u2B1B";

	public static void draw(boolean[][] alive)
	{
		int size = alive.length;

		for(int i = 0; i < size; ++i){
			for(int j = 0; j < size; ++j){
				if(alive[i][j])
					System.out.print(ALIVE_SYM);
				else
					System.out.print(DEAD_SYM);
			}

			System.out.println();
		}
	}

	public static void init(boolean[][] alive, double prob)
	{
		int size = alive.length;

		for(int i = 0; i < size; ++i){
			for(int j = 0; j < size; ++j){
				// if(Math.random() < 0.5)
				// 	alive[i][j] = true;
				// else
				// 	alive[i][j] = false;

				alive[i][j] = Math.random() < prob;
			}
		}
	}


	public static int countAlive(boolean[][] alive, int i, int j)
	{
		int size = alive.length;

		int result = 0;
		for(int n=i-1; n <= i+1; ++n)
		{
			for(int m=j-1; m <= j+1; ++m)
			{
				if(n == i && m == j)
					continue;

				int n1 = (n+size)%size;
				int m1 = (m+size)%size;

				if(alive[n1][m1])
					++result;
			}
		}

		return result;
	}

	public static void update(boolean[][] alive)
	{
		int size = alive.length;

		boolean[][] tmp = new boolean[size][size];

		for(int i = 0; i < size; ++i){
			for(int j = 0; j < size; ++j){
				int neighs = countAlive(alive, i, j);
				if(alive[i][j])
				{
					if(neighs < 2)
						tmp[i][j] = false;
					else if(neighs == 2 || neighs == 3)
						tmp[i][j] = true;
					else
						tmp[i][j] = false;
				}
				else
				{
					if(neighs == 3)
						tmp[i][j] = true;
				}
			}
		}

		for(int i = 0; i < size; ++i){
			for(int j = 0; j < size; ++j){
				alive[i][j] = tmp[i][j];
			}
		}
	}

	public static void main(String[] args)
	{
		int size = 10;
		double prob = 0.3;

		boolean[][] alive = new boolean[size][size];

		init(alive, prob);

		// alive[2][2]=true;
		// alive[2][3]=true;
		// alive[2][4]=true;
		// alive[3][2]=true;
		// alive[3][3]=true;

		try
		{
			while(true)
			{
				draw(alive);
				update(alive);

				Thread.sleep(100);

				System.out.print("\033[H\033[2J");
				System.out.flush();
			}

		}
		catch(InterruptedException e)
		{ }
	}
}