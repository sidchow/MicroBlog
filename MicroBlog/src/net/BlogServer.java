package net;

import java.io.*;
import java.net.*;

public class BlogServer
{

	public static final int PORT = 3021;
	
	public static void main(String[] args)
	{
		try
		(
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket clientSocket = serverSocket.accept();
			//PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		)
		{
			String inputLine;
			while ((inputLine= in.readLine()) != null)
			{
				System.out.println("Server output:"+inputLine);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
