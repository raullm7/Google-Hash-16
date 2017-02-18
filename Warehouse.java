import java.util.ArrayList;
public class Warehouse
{
	Cell location;
	ArrayList<Integer> products = new ArrayList<Integer>();
	int numberProducts = products.size();
	int capacity;

	public Warehouse(Cell givenLocation, ArrayList<Integer> givenProducts)
	{
		location = givenLocation;
		products = givenProducts;
	}

	public void add(Product givenProduct)
	{
		products.set(givenProduct.type, products.get(givenProduct.type) + 1);
	}

	public Product take(Product givenProduct)
	{
		products.set(givenProduct.type, products.get(givenProduct.type) - 1);
		return givenProduct;
	}

	public int numberProducts(int productType)
	{
		return products.get(productType);
	}

	public boolean contains(ArrayList<Integer> givenProducts)
	{
		boolean result = true;
		for(int i = 0; i < givenProducts.size(); i++){
			int productsOfType = givenProducts.get(i);
			if(productsOfType > products.get(i))
				result = false;
		}
		return result;
	}
}