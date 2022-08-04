package plott3r_V1;

import lejos.hardware.Sound;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;
import positions.Position2D;
import positions.Position3D;


public class Roboter {
	
	static int duck[] = { 440, 440, 440, 349, 523, 440, 349, 523, 440, 659, 659, 659, 698, 523, 415, 349, 523, 440 };
	static int duration[] = { 500, 500, 500, 350, 150, 500, 350, 150, 1000, 500, 500, 500, 350, 150, 500, 350, 150, 1000};
	
	public static void main(String args[]) {
		try {
			Roboter roboter = new Roboter();
			Sound.beep();
			roboter.moveToHomePosition();
			roboter.bereitePapierVor();

			Delay.msDelay(1000);
			roboter.entfernePapier();
			roboter.moveToHomePosition();
			Sound.twoBeeps();
		} catch (Exception e) {
			e.printStackTrace();
		}
		easteregg(duck,duration);
	}

	private Position3D currentPosition;

	private MultiPositionAchse xAchse = new MultiPositionAchse(new TouchSensor(SensorPort.S1), MotorPort.A, Einbaurichtung.UMGEKEHRT, new Reifen(40.0), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_MITTEL)));
	private MultiPositionAchse yAchse = new MultiPositionAchse(new LichtSensor(SensorPort.S3), MotorPort.B, Einbaurichtung.UMGEKEHRT, new Reifen(43.2), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_KLEIN), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_GROSS)));
	private DualPositionAchse zAchse = new DualPositionAchse(null, MotorPort.C, Einbaurichtung.REGULAER, null, null);

	public Roboter() {

	}

	private void bereitePapierVor() throws InterruptedException {
		// TODO: Implementierung
	}

	private void entfernePapier() throws InterruptedException {
		zAchse.deaktiviere();
		//yAchse.setSpeed(Integer.MAX_VALUE);
		yAchse.backward(2000);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.exit(0);
	}

	public Position3D getCurrentPosition() {
		return this.currentPosition;
	}

	public MultiPositionAchse getXAchse() {
		return this.xAchse;
	}

	public MultiPositionAchse getYAchse() {
		return this.yAchse;
	}

	protected void moveToHomePosition() throws InterruptedException {
		// TODO: Implementierung
	}

	private void moveToPosition(Position2D position2D, int mmSec) throws InterruptedException {
		// TODO: Implementierung
	}

	private void moveToPosition(Position3D position, int mmSec) throws InterruptedException {
		// TODO: Implementierung
	}

	private void resetTachoCounts() {
		this.xAchse.resetTachoCount();
		this.yAchse.resetTachoCount();
		if (xAchse.getTachoCount() != 0 || yAchse.getTachoCount() != 0)
			throw new RuntimeException("Konnte Tachocount nicht zurücksetzen");
	}

	public void stop() {
		xAchse.stop();
		yAchse.stop();
		zAchse.stop();
	}
	
	static void easteregg(int[] duck, int[] dur) {
		Sound.setVolume(10);
		for (int i = 0; i < duck.length; i++) {
			Sound.playTone(duck[i], dur[i]);
			//Thread.sleep(500 + 5 * duration[i]);
		}
	}

}
