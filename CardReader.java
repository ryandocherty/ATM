// Server Side
import java.net.*;
import java.io.*;

public class CardReader { 
  public int[] run() {
	  int[] readReturn = new int[2];
	  readReturn[0] = 0;
	  readReturn[1] = 0;
	  
	  try {
		int serverPort = 4020;
		ServerSocket serverSocket = new ServerSocket(serverPort);
		serverSocket.setReuseAddress(true);
			
		Socket server = serverSocket.accept();
		
		//PrintWriter toClient = new PrintWriter(server.getOutputStream(),true);
		BufferedReader fromClient =	new BufferedReader(new InputStreamReader(server.getInputStream()));
		
		// Lets do a bunch of checks!
		boolean failRead = true;								// Always default to failing read
	
		String line = fromClient.readLine();
		String[] idp = line.split(":");
		
		if (idp.length != 2) { 
			System.out.println("Invalid argument count.");
			// We should always have an ID and type
		}							
		else if (! Utils.isInteger(idp[0]) ) {
			// ID should always be an integer
			System.out.println("Invalid ID passed.");
		}			
		else if (! Utils.isInteger(idp[1]) ) {
			// PIN should always be an integer
			System.out.println("Invalid CardType passed.");
		} 			
		else { 
			failRead = false; 
			readReturn[0] = Integer.parseInt(idp[0]);
			readReturn[1] = Integer.parseInt(idp[1]);
		}

		// toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
		serverSocket.close();
		
		if (!failRead) {
			System.out.println("Read success!");
		} else {
			System.out.println("Read fail!");
		}
	}
	catch(UnknownHostException ex) {
		// ex.printStackTrace();
		// I don't care :-)
	}
	catch(IOException e){
		// e.printStackTrace();
		// I don't care :-)
	}
	catch (NullPointerException en) {
		// I don't care :-) 
	}
	return readReturn;
  }
}