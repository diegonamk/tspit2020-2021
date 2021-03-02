package puntate;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
	int port = 6666;//necessario porta logica
	private Socket socket = null;
	
	public Client() {
	}
	
	public void start() {
		try {
			socket = new Socket(InetAddress.getLocalHost(), port);//necessario 
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println("connessione effettuata");
			String value;
			Scanner myObj = new Scanner(System.in);
			String txt;
			value = bufferedReader.readLine();
			System.out.println(value);
			txt = myObj.nextLine();
			bufferedWriter.write(txt);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			while(true) {
				value = bufferedReader.readLine();//
				System.out.println(value);
				value = bufferedReader.readLine();//
				System.out.println(value);
				txt = myObj.nextLine();
				bufferedWriter.write(txt);//
				bufferedWriter.newLine();
				bufferedWriter.flush();
				value = bufferedReader.readLine();//
				System.out.println(value);
				txt = myObj.nextLine();
				bufferedWriter.write(txt);//
				bufferedWriter.newLine();
				bufferedWriter.flush();
				value = bufferedReader.readLine();
				System.out.println(value);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client test= new Client();
		test.start();

	}
	
	
}
