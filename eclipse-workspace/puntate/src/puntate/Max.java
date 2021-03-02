package puntate;

import java.util.ArrayList;

public class Max extends Thread{
	private ArrayList<idcoin> idcoin;
	private idcoin app;
	public Max(ArrayList<idcoin> idcoin) {
		this.idcoin = idcoin;
		app = idcoin.get(0);
	}
	
	public void run(){
		while(true) {
			for (int i=0; i<idcoin.size(); i++) {
				if(app.get_value()<idcoin.get(i).get_value()) {
					app.set_value(idcoin.get(i).get_value());
					app.set_id(idcoin.get(i).get_id());
				}
			}
			idcoin.set(0, app);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
