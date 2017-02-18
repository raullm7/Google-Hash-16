import java.util.ArrayList;
import java.lang.Math;

public class Grid
{
	int rows, columns, drones, turns, payload;
	int productTypes;
	ArrayList<Integer> productsWeights = new ArrayList<Integer>();
	int numberWarehouses;
	ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
	int numberOrders;
	ArrayList<Order> orders = new ArrayList<Order>();
	Cell [][] grid;

	public Grid(int givenColumns, int givenRows, int givenDrones, int givenTurns,
				int givenPayload, ArrayList<Warehouse> givenWarehouses,
				ArrayList<Order> givenOrders)
	{
		grid =  new Cell[givenColumns][givenRows];
		columns = givenColumns;
		rows = givenRows;
		drones = givenDrones;
		turns = givenTurns;
		payload = givenPayload;
		warehouses = givenWarehouses;
		orders = givenOrders;
		run();
	}

	public double getDistance(int ra, int ca, int rb, int cb)
	{
		if(ra == rb && ca == cb)
			return 0;
		return Math.ceil(Math.sqrt((ra - rb) * (ra - rb) + (ca - cb) * (ca - cb)));
	}

	public void run()
	{
		for(int orderIndex = 0; orderIndex < orders.size(); orderIndex++){
			Order order = orders.get(orderIndex);
			ArrayList<Integer> products = order.products;
		}
	}

	public double getClosestWarehouseWithProducts(int givenR, int givenC, ArrayList<Integer> givenProducts)
	{
		double distance = 99999999;
		for(int i = 0; i < warehouses.size(); i++){
			Warehouse w = warehouses.get(i);
			if(w.contains(givenProducts))
				if(getDistance(givenR, givenC, w.location.row, w.location.column) < distance)
					distance = getDistance(givenR, givenC, w.location.row, w.location.column);
		}
		return distance;
	}

	public int averageDistance()
	{
		int tot;

		for(int i = 0; i < numberOrders; i++)
		{
			tot += getClosestWarehouseWithProducts(orders.get(i).target.row, orders.get(i).target.cloumn, orders.get(i).products);
		}

		return tot/numberOrders;
	}
}