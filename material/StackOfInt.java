public class StackOfInt {
	private int[] elements;
	private int top;
	
	public static void main(String args[])
	{
		StackOfInt soi = new StackOfInt();
		
		soi.print();
		soi.push(1);
		soi.push(2);
		//elements fine 2
		
		soi.print();
		soi.push(3);
		//elements.length 4
		soi.print();
		
		soi.push(4);
		soi.push(4);
		soi.push(4);
		soi.print();
		
		soi.pop();
		soi.pop();
		soi.pop();
		soi.print();
		
		soi.push(5);
		soi.print();
		
		System.out.print(soi.elements.length + "\n");
	}

	public StackOfInt()
	{
		top = 0;
		elements = new int[2];
	}
	
	public void print()
	{
		for(int i = 0; i < top; ++i)
			System.out.print(elements[i] + " ");
		System.out.print("\n");
	}


	public void push(int v)
	{
		if(top >= elements.length)
		{
			int[] tmp = elements;
			elements = new int[elements.length*2];
			System.arraycopy(tmp, 0, elements, 0, tmp.length);
		}
		elements[top] = v;
		top++;
	}

	public int pop()
	{
		top--;

		//int tmp = elements[top];
		//elements[top] = 0;
		//return tmp;

		return elements[top];
	}
}
