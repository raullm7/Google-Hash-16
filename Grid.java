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
		numberOrders = orders.size();

	}

	public double getDistance(int ra, int ca, int rb, int cb)
	{
		if(ra == rb && ca == cb)
			return 0;
		return Math.ceil(Math.sqrt((ra - rb) * (ra - rb) + (ca - cb) * (ca - cb)));
	}

	public void run()
	{
		double avgDist = averageDistance();
		System.out.println("Average Distance: " + avgDist);
		/*for(int orderIndex = 0; orderIndex < orders.size(); orderIndex++){
			Order order = orders.get(orderIndex);
			ArrayList<Integer> products = order.products;
		}*/
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

	public double averageDistance()
	{
		double tot = 0;
		for(int i = 0; i < numberOrders; i++)
		{
			tot += getClosestWarehouseWithProducts(orders.get(i).target.row, orders.get(i).target.column, orders.get(i).products);
		}
		return tot/numberOrders;
	}

	public void shit()
	{
		int ohot;
		int sum_Ohot;
		int sum_NOhot;
		
		int whot;
		int sum_Whot;
		
		int ahot;
		
		for (int order = 0; order < orders.size(); order++)
		{
			if ((weight < drone_payload) & (dist < average_dist))
			{
				Ohot = 1;
				Sum_Ohot++;
			}
			else
			{
				Ohot = 0;
				Sum_NOhot++;
			}	
		}
		
		for (int warehouse = 0; warehouse < warehouse.size(); warehouse++)
		{
			if (Sum_Ohot >= Sum_NOhot)
			{
				Whot = 1;
				Sum_Whot++;
			}
			else
			{
				Whot = 0;
			}		
		}
						
		for (int cell = 0; cell < cell.size(); cell++)
		{
			Ahot = Sum_Whot;	
		}
	}
}