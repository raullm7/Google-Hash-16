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
	
	public void map()
	{
		int Ohot;
		int Sum_Ohot;
		int Sum_NOhot;
		
		int Whot;
		int Sum_Whot;
		
		int Ahot;
		
		for (order = 0; order < order.size; order++)
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
		
		for (warehouse = 0; warehouse < warehouse.size; warehouse++)
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
						
		for (cell = 0; cell < cell.size; cell++)
		{
			Ahot = Sum_Whot;	
		}
	}
}
