package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BlogClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//--------------------------------------
				System.out.println("Get Start!!");
				//--------------------------------------
				
				String hostName = "127.0.0.1";
				int portNumber = 3021;
				
				try{
					//--------------------------------------
					System.out.println("Try to connet!!");
					//--------------------------------------
					
					Socket blogclient = new Socket(hostName,portNumber);
					
					//--------------------------------------
					System.out.println("Get ready to start server input and output");
					//--------------------------------------
					
					PrintWriter out = new PrintWriter(blogclient.getOutputStream(),true);
					BufferedReader in = new BufferedReader(new InputStreamReader(blogclient.getInputStream()));
					BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
					
					//--------------------------------------
					System.out.println("Try to get client input!!");
					//--------------------------------------
					
					String userInput;
					while((userInput=stdIn.readLine())!=null){
						if(userInput.equals("quit")){
							out.println(userInput);
							
							//--------------------------------------
							System.out.println("I am closing!!");
							//--------------------------------------
							
							stdIn.close();
							in.close();
							out.close();
							blogclient.close();
							
						}else{
							out.println(userInput);
							System.out.println(in.readLine());
						}
					}
					
						
					}catch(UnknownHostException exception){
						System.err.println("Dont know about host "+hostName);
						System.exit(1);
					}catch(IOException e){
						System.err.println("Couldt get I/O for the connection to "+hostName);
						System.exit(1);
					}
	}

}
