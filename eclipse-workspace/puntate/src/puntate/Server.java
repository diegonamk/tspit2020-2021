package puntate;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class Server extends Thread{
	private Socket socket;//necessario socket client
	private ArrayList<idcoin> idcoin;
	private int id;
	
	public Server(Socket socket, ArrayList<idcoin> idcoin, int id) {
		this.socket = socket;
		this.idcoin = idcoin;
		this.id = id;
	}
	
	public void run(){
		
		try {
			System.out.println("thred avviato");
			idcoin puntata = new idcoin();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//necessario reader
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//necessario writer 
			System.out.println("st 1");
			bufferedWriter.write("Benvenuto, scegli un id utente");
			bufferedWriter.newLine();
			bufferedWriter.flush();
			System.out.println("st 2");
			String name = bufferedReader.readLine();
			System.out.println("id scelto: " + name);
			String value;
			String response;
			
			while(true) {
				
				bufferedWriter.write("Puntata vincente di " + idcoin.get(0).get_id() + " con un'offerta di " + idcoin.get(0).get_value());
				bufferedWriter.newLine();
				bufferedWriter.flush();
				bufferedWriter.write("Quanto vuoi puntare " + name + "?");
				bufferedWriter.newLine();
				bufferedWriter.flush();
				value = bufferedReader.readLine();
				double dvalue = Double.parseDouble(value);
				bufferedWriter.write("Vuoi puntare "+ value + "?");
				bufferedWriter.newLine();
				bufferedWriter.flush();
			    response = bufferedReader.readLine();
			    System.out.println("readline effettuata");
			    System.out.println(name);
				if(response.equals("si") && dvalue>idcoin.get(0).get_value()) {
					System.out.println("si");
					puntata.set_id(name);
					puntata.set_value(dvalue);
					idcoin.add(0, puntata);
					bufferedWriter.write("Operazione effettuata");
					bufferedWriter.newLine();
					bufferedWriter.flush();
				}
				else {
					System.out.println("no");
					bufferedWriter.write("Operazione annullata");
					bufferedWriter.newLine();
					bufferedWriter.flush();
				}
			}
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

	
	
}
