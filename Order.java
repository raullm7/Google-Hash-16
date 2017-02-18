import java.util.ArrayList;
import java.lang.Math;
public class Order
{
	Cell target;
	int numberItems;
	ArrayList<Integer> products = new ArrayList<Integer>();
	ArrayList<Integer> productsWeights;

	public Order(Cell givenTarget, int givenNumberItems, ArrayList<Integer> givenProducts,
					ArrayList<Integer> givenProductsWeights)
	{
		target = givenTarget;
		numberItems = givenNumberItems;
		products = givenProducts;
		productsWeights = givenProductsWeights;
	}

	public double orderscore(int turns, int totalTurns)
	{
		return Math.ceil(((totalTurns - turns) / totalTurns) * 100);
	}

	public int weight()
	{
		int totalWeight = 0;
		for(int i = 0; i < )
	}
}