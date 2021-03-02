package puntate;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
//si implementa un programma senza uso di monitor anche se piú vantaggioso in questo caso

public class Multiserver {
	private int port = 6666;//necessario
	private String name = "nessuna puntata";
	private double value = 0d;
	private idcoin start = new idcoin(name, value);
	private ArrayList<idcoin> idcoin = new ArrayList<idcoin>();
	private int id = 1;
	//si pone in posizione 0 la combinazione value maggiore e id corrispondente
	//ovvero chi vince la puntata
	public Multiserver() {//necessario costruttore
		try {
			ServerSocket serverSocket = new ServerSocket(port);//necessario ServerSocket nome = new ServerSocket(porta logica usata)
			idcoin.add(start);
			(new Max(idcoin)).start();
			while (true) {
				System.out.println("in attesa su " + port);
				Socket socket = serverSocket.accept();//necessario creazione socket client e assegnazione tramite la socket del server accept()
				System.out.println("Connessione stabilita: " + socket.getInetAddress() + ":" + socket.getPort());
				(new Server(socket, idcoin, id)).start();//avvio thread server
				id++;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Multiserver test= new Multiserver();

	}
	

}
