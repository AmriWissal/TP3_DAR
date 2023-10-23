package ClientThread;
import java.net.*;
import java.io.*;

  public class ClientMT extends Thread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		System.out.println("Je suis un client pas encore connecté...");
		InetAddress ia = InetAddress.getByName("192.168.0.3");
		InetSocketAddress isa = new InetSocketAddress(ia,1234);
		Socket socket = new Socket();
		// Etablir connexion 
		socket.connect(isa);
		System.out.println("Je suis un client connecté");
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		System.out.println(s);
		//Fermeture du Connexion
		socket.close();
		
	       } 
		catch (IOException e) {
		e.printStackTrace();
	    }

}

	}
	


