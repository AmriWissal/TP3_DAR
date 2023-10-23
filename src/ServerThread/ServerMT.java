package ServerThread;
import java.net.*;
import java.io.*;
      public class ServerMT extends Thread{
		int ord ;
      public static void main(String[] args) {
	      // TODO Auto-generated method stub
	           // lancement du serveur
	           new ServerMT().start();
               } 
	  public void run() {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("je suis un serveur,j'attends une connexion");
			while (true) {
				// serveur bloquant en attente de communication 
		    Socket s=ss.accept();
			new ClientProcess(s,ord++).start();
			System.out.println("vous etes connecté_bienvenue");
			}
		}
		catch (IOException e)
			{
			e.printStackTrace();
			}
			}
		public class ClientProcess extends Thread {
			Socket s;
			int num_client;
			public ClientProcess(Socket S, int num_client) {
				super();
				this.s=S;
				this.num_client=num_client;
			}
			public void run() {
				try {
					PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
					pw.println("Client numéro "+ord+" Votre address IP :"+s.getRemoteSocketAddress());
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	  }
		}
      
	
	


	
