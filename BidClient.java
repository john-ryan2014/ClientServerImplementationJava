package assignmentClient;
import java.io.*;
import java.net.*;
import java.util.*;

public class BidClient 
{
	private static InetAddress host;
	private static final int PORT =1234;

	public static void main(String[] args)
	{
		try
		{
			host = InetAddress.getLocalHost();
		}
		catch(UnknownHostException uhEx)
		{
			System.out.println("\nHost id not found!\n");
			System.exit(1);
		}
		sendMessages();
	}
	
	private static void sendMessages()
	{
		Socket socket = null;
		
		try
		{
			socket = new Socket(host,PORT);
			Scanner networkInput = new Scanner(socket.getInputStream());
			PrintWriter networkOutput = new PrintWriter(socket.getOutputStream(),true);
			
			Scanner userEntry = new Scanner(System.in);
			
			String message, response;
			System.out.println("Welcome to  the auction, type ***CLOSE*** at anytime to quit. The first item is a phone worth 100 euro: ");
			do
			{
				System.out.print("Please enter your bid: ");
				message = userEntry.nextLine();
				networkOutput.println(message);
				
				response = networkInput.nextLine();
				System.out.println("\nServer: " + response);
				
				
			}while(!message.equals("***CLOSE***"));
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
		}
		finally
		{
			try
			{
				System.out.println("\nClosing connection...");
				socket.close();
			}
			catch(IOException ioEx)
			{
				System.out.println("\nUnable to disconnect");
				System.exit(1);
			}
		}
	}

}
