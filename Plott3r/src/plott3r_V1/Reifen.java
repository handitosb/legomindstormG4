package plott3r_V1;

public class Reifen {
	private double durchmesser;

	public Reifen(double durchmesser) {
		this.durchmesser = durchmesser;
	}

	public double getDurchmesser() {
		return durchmesser;
	}

	public double getUmfang() {
		return this.durchmesser * Math.PI;
	}
}
