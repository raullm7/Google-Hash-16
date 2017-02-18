import java.util.ArrayList;
import java.lang.Math;
public class Order
{
	Cell target;
	int numberItems;
	ArrayList<Integer> products = new ArrayList<Integer>();

	public Order(Cell givenTarget, int givenNumberItems, ArrayList<Integer> givenProducts)
	{
		target = givenTarget;
		numberItems = givenNumberItems;
		products = givenProducts;
	}

	public double orderscore(int turns, int totalTurns)
	{
		return Math.ceil(((totalTurns - turns) / totalTurns) * 100);
	}
}