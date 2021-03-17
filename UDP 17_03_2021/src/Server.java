import java.net.*;
import java.io.*;


public class Server {
	public static void main (String args[]) throws Exception{
		DatagramSocket serverSocket= new DatagramSocket(6789);
		//boolean attivo = true;				// per la ripetizione del servizio
		byte[] bufferIN = new byte[1024];	// buffer spedizione e ricezione
		byte[] bufferOUT = new byte[1024];
		
		System.out.println("SERVER avviato...");
		BufferedReader reader;
		reader = new BufferedReader( new FileReader("/2020-2021/TPSIT/Dante.txt"));
		String line  = reader.readLine();
		DatagramPacket receivePacket = 
				new DatagramPacket(bufferIN, bufferIN.length);
		serverSocket.receive(receivePacket);
		InetAddress IPClient = receivePacket.getAddress();
		int portaClient = receivePacket.getPort();
		bufferOUT = line.getBytes();
		DatagramPacket sendPacket= 
				new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
		serverSocket.send(sendPacket);
		while(line != null) {
			receivePacket = 
					new DatagramPacket(bufferIN, bufferIN.length);
			serverSocket.receive(receivePacket);
			IPClient = receivePacket.getAddress();
			portaClient = receivePacket.getPort();
			line  = reader.readLine();
			bufferOUT = line.getBytes();
			sendPacket= 
					new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
			serverSocket.send(sendPacket);
			
		}
		reader.close();
		//while(attivo) {
			//definizione del datagramma
			//DatagramPacket receivePacket = 
					new DatagramPacket(bufferIN, bufferIN.length);
			//attesa della ricezione dato dal client 
			//serverSocket.receive(receivePacket);
			//String ricevuto = new String(receivePacket.getData());
			//int numCaratteri = receivePacket.getLength();
			//ricevuto = ricevuto.substring(0,numCaratteri);
			//System.out.println("RICEVUTO: "+ricevuto);
			//riconoscimento dei parametri del socket del client
			//InetAddress IPClient = receivePacket.getAddress();
			//int portaClient = receivePacket.getPort();
			//preparo il dato da spedire
			//String daSpedire = ricevuto.toUpperCase();
			//bufferOUT = daSpedire.getBytes();
			//invio del Datagram
			//DatagramPacket sendPacket= 
			//		new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
			//serverSocket.send(sendPacket);
			//if(ricevuto.equals("fine")) {
			//	System.out.println("SERVER IN CHIUSURA");
			//	attivo=false;
			//}
			
			//}
			serverSocket.close();
		}	
	}
