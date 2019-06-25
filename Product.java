package assignment;

public class Product 
{
	String name;
	int reservePrice, currentBid;
	boolean sold = false;
	
	public Product(String productName,int productReservePrice)
	{
		name = productName;
		reservePrice = productReservePrice;
		currentBid = productReservePrice;
	}
	
	public synchronized int updatePrice(int newBid) //makes sure that only one client can change the bid at a time.
	{
		if(newBid > currentBid)
		{
			return newBid;
		}
		else
		{
			return currentBid;
		}
	}
}
