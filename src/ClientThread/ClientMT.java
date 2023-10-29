package ClientThread;
import java.net.*;
import java.util.Scanner;
import OperationPAK.Operation;

import java.io.*;

  public class ClientMT extends Thread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		// premiere partie:
		System.out.println("Je suis un client pas encore connecté...");
		InetAddress ia = InetAddress.getByName("192.168.1.144");
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
		// deusieme partie: 
		// flux de communication et traitement 
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		ObjectInputStream ois = new ObjectInputStream(is);
		//Envoie de objet
		System.out.println("Donnez le premier entier");
		Scanner scanner=new Scanner(System.in);
		int nb1= scanner.nextInt();		
		System.out.println("Donnez le deuxieme entier");
		 int nb2= scanner.nextInt();
		char op;
		do {
			System.out.println("choisissez votre opération:");
			op = scanner.next().charAt(0);
			} 
		while (!(op =='+') && !(op == '-') && !(op == '*')&& !(op == '/'));		
		Operation O1= new Operation(nb1,nb2,op);
		oos.writeObject(O1);
		// Réception de l'objet:
		O1 = (Operation)ois.readObject();
		System.out.println("Résultat = "+O1.getResult());
		//Fermeture du Connexion
		socket.close();
	       } 
		catch (IOException  |ClassNotFoundException e) {
		e.printStackTrace();
	    }

}

	}
	


