package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

	public static final int PORT = 3021;
	private static int visitorcounter=0;
	
	public static void main(String[] args)
	{
		try(ServerSocket serverSocket = new ServerSocket(PORT);)
		{
				
			Socket clientSocket;
			System.out.println("Wait for connect!");
			while((clientSocket = serverSocket.accept()) !=null){
				visitorcounter++;
				Runnable clientConnect= new ThreadHandler(clientSocket,visitorcounter);
				Thread t = new Thread(clientConnect);
				t.start();
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadHandler implements Runnable{
	private int counter;
	private Socket clientSocket;
	
	public ThreadHandler(Socket clientSocket,int visitorcounter) {
		// TODO Auto-generated constructor stub
		this.clientSocket=clientSocket;
		this.counter=visitorcounter;
	}

	public void run(){
		try{
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;
			System.out.println("New thread started!! And wait for command!");
			while ((inputLine= in.readLine()) != null){
				//System.out.println("Server output:"+inputLine);
				if(inputLine.equals("visitor")){
					out.println("You're the "+counter+" visitor today");
				}
				else if(inputLine.equals("quit")){
					return;
				}else{
					out.println(inputLine);
				}
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}