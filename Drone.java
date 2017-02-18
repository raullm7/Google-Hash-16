import java.util.ArrayList;
public class Drone
{
	Cell location;
	int payload;
	ArrayList<Integer> products = new ArrayList<Integer>();
	int turns;
	boolean busy = false;
	ArrayList<Integer> productsWeights;

	public Drone(Cell givenLocation, int givenPayload, ArrayList<Integer> givenProductsWeights)
	{
		location = givenLocation;
		payload = givenPayload;
		productsWeights = givenProductsWeights;
	}

	public void load(Product givenProduct, int quantity)
	{
		products.set(givenProduct.type, products.get(givenProduct.type) + quantity);
		turns++;
	}

	public void deliver(Product givenProduct)
	{
		products.set(givenProduct.type, products.get(givenProduct.type) - 1);
		turns++;
	}

	public int currentWeight()
	{
		int currentWeight = 0;
		for(int i = 0; i < products.size(); i++){
			currentWeight += i * products.get(i) * productsWeights.get(i);
		}
		return currentWeight;
	}

	public void move(int move)
	{
		turns += move;
	}

	public void wait(int givenTurns)
	{
		turns += givenTurns;
	}
}