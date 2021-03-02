package puntate;

public class idcoin {
	private double value;
	private String id;
	public idcoin() {
	}
	public idcoin(String name, double value2) {
		id = name;
		value = value2;
	}

	public void set_id(String id) {
		this.id = id;
	}
	
	public void set_value(double value) {
		this.value = value;
	}
	
	public String get_id() {
		return id;
	}
	
	public double get_value() {
		return value;
	}

}
