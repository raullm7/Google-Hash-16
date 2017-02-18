import java.util.Scanner;
import java.util.ArrayList;
public class Beer
{
	static int rows, columns, drones, turns, payload;
	static int productTypes;
	static ArrayList<Integer> productsWeights = new ArrayList<Integer>();
	static int numberWarehouses;
	static ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
	static int numberOrders;
	static ArrayList<Order> orders = new ArrayList<Order>();


	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		columns = sc.nextInt();
		drones = sc.nextInt();
		turns = sc.nextInt();
		payload = sc.nextInt();
		sc.nextLine();

		productTypes = sc.nextInt();
		for(int i = 0; i < productTypes; i++)
			productsWeights.add(sc.nextInt());
		sc.nextLine();

		numberWarehouses = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < numberWarehouses; i++){
			ArrayList<Integer> products = new ArrayList<Integer>();
			//Sorry for this
			for(int ind = 0; ind < productTypes; ind++)
				products.add(0);
			int x = sc.nextInt();
			int y = sc.nextInt();
			Cell location = new Cell(x, y);
			sc.nextLine();
			for(int j = 0; j < productTypes; j++){
				int numberOfProductType = sc.nextInt();
				products.set(j, numberOfProductType);
			}
			sc.nextLine();
			Warehouse w = new Warehouse(location, products);
			warehouses.add(w);
		}

		numberOrders = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < numberOrders; i++){
			ArrayList<Integer> products = new ArrayList<Integer>();
			//Sorry for this
			for(int ind = 0; ind < productTypes; ind++)
				products.add(0);
			int x = sc.nextInt();
			int y = sc.nextInt();
			sc.nextLine();
			Cell target = new Cell(x, y);
			int numberItems = sc.nextInt();
			sc.nextLine();
			for(int j = 0; j < numberItems; j++){
				int itemType = sc.nextInt();
				products.set(itemType, products.get(itemType) + 1);
			}
			Order o = new Order(target, numberItems, products);
			orders.add(o);
		}


		// START DOING SHIT

		Grid grid = new Grid(columns, rows, drones, turns, payload, warehouses, orders);
		grid.run();
	}
}