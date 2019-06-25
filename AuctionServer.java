package assignment;
import java.io.*;
import java.net.*;

public class AuctionServer 
{
	private static ServerSocket servSocket;
	private static final int PORT = 1234;
	
	public static void main(String[] args) throws IOException
	{
		try
		{
			servSocket = new ServerSocket(PORT);
		}
		catch(IOException e)
		{
			System.out.println("\nUnable to set up port!");
			System.exit(1);
		}
		
		//create the products for auction
		Product[] items = {new Product("Phone", 100),
		 				   new Product("Shirt", 50),
		 				   new Product("Book", 30),
						   new Product("Desk", 100),
						   new Product("Chair", 50)};
		
		do
		{
			//wait for client to make a connection
			Socket client = servSocket.accept();
			System.out.println("\n New client accepted! \n");
			
			//create a thread to handle all dialogue with this client
			ClientThread handler = new ClientThread(client,items);
			handler.start();
			
		}while(true);
	}
}
