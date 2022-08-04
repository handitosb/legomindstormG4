import lejos.hardware.lcd.LCD;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lejos.hardware.Sound;
import lejos.hardware.Sounds;

public class class1 {
	// Schlitten
	static RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);

	// Papiereinzug
	static RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);

	// Stift
	static RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);

	static EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);

	static EV3ColorSensor sensor2 = new EV3ColorSensor(SensorPort.S2);

	static SensorMode sensorMode = touchSensor.getTouchMode();
	static float[] sample = new float[sensorMode.sampleSize()];
	
	static int duck[] = { 440, 440, 440, 349, 523, 440, 349, 523, 440, 659, 659, 659, 698, 523, 415, 349, 523, 440 };
	static int duration[] = { 500, 500, 500, 350, 150, 500, 350, 150, 1000, 500, 500, 500, 350, 150, 500, 350, 150, 1000};
	static int duck1[] = {50,100,200,300,400,500,600,700,800,1000,2000,4000,6000,8000};
	static int duration1[] = {100,100,100,100,100,100,100,100,100,50,50,50,50,50,50,50,50};
	static int duck2[] = {8000,6000,4000,2000,1000,800,700,600,500,400,300,200,100,50};
	static int duration2[] = {100,100,100,100,100,100,100,100,100,50,50,50,50,50,50,50,50};
	
	

	// Übersetzung von Motorseite aus
	public static int[] gearRatioA = new int[] { 12, 36};
	public static double ratioA1mm = 9.075; //in Grad für 1mm Bewegung
	public static int[] gearRatioB = new int[] { 12, 36 };
	public static double ratioB1mm = 7.957; //in Grad für 1mm Bewegung
	public static double dRad = 43.2;

	// Stift ist zu Beginn oben = 0; Stift unten ist durch 1 dargestellt
	static int penState = 0;

	// Angle-Maximum von Schlitten (Ende des Schiene wegen Anstoßen)
	public static int maxAnglemotorA = -1600;

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Main Methode
	 */

	public static void main(String[] args) {

		sensorMode.fetchSample(sample, 0);
		Sound.setVolume(10);
		calibrate();

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
//			while(sample[0] == 0) {
//				motorA.setSpeed(40);
//				motorA.forward();
//				sensorMode.fetchSample(sample, 0);
//				Delay.msDelay(50);
//			}
//			motorA.stop();
//			
//			LCD.drawString("Gedrueckt!", 0, 0);
//		
//			Delay.msDelay(2000);

//			myrotate(motorB, 180);

// Test 1
//		move(50, 100, motorB);
//		Delay.msDelay(8000);
//		move(100, 200, motorB);
//		Delay.msDelay(5000);
//		move(-100, 200, motorB);

// Test 2 - Stift hoch
//		motorC.setSpeed(50);
//		myrotate(motorC, 180);
//		penState = 0;
//		motorC.resetTachoCount();

//  	System.out.print(sensor.sampleSize());
//		System.out.print(sensor2.sampleSize());
//		sensor2.setCurrentMode(0);
//		System.out.print(sensor2.sampleSize());
//		
//		motorC.forward();
//		Delay.msDelay(2000);
//		motorC.stop();
//		motorC.backward();
//		Delay.msDelay(2000);
//		motorC.stop();
//		
//		
//		motorA.rotate(180);
//		
//		motorB.forward();
//		
//		sensor.sampleSize();
//		
//		Delay.msDelay(2000);

//	Test 3 - Kalibrierung und auslesen Tacho		
//		
//		LCD.drawInt(motorA.getTachoCount(), 0, 0);
//		LCD.drawString("Kalibrierung läuft --->", 0, 1);
//		Delay.msDelay(100);
//		
//		calibrate();
//		
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,0);
//		Delay.msDelay(3000);
//		pendown();
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,1);
//		Delay.msDelay(3000);
//		pendown();
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,2);
//		Delay.msDelay(3000);pendown();
//		penup();
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,3);
//		Delay.msDelay(3000);
//		
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,4);
//		Delay.msDelay(3000);
//		pendown();
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,5);
//		Delay.msDelay(3000);pendown();
//		penup();
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,6);
//		Delay.msDelay(3000);
//		
//		pendown();
//		penup();
//		pendown();
//		penup();
//		pendown();
//		penup();
//		pendown();
//		penup();
//		pendown();
//		penup();
//		pendown();
//		penup();
//		LCD.drawString("mC " + String.valueOf(motorC.getTachoCount()),0,6);
//		Delay.msDelay(3000);

//	Test 4 - Prüfung der Aktualisierung TachoCount bei manuellem Drehen
//		
//		LCD.drawString("Test 4",0,0);
//		Delay.msDelay(2000);
//		for (int i = 0; i <= 20; i++) {
//			LCD.drawString("mA " + String.valueOf(motorC.getTachoCount()),0,1);
//			Delay.msDelay(500);
//		}
//		Delay.msDelay(2000);

//	Test 5 - Prüfung Schlupf des Schlittens bei Richtungswechsel Ergebnis: Nach Tacho 12 Schritte mehr
//		
//		LCD.drawString("Test 4",0,0);
//		Delay.msDelay(2000);
//		calibrate();
//		motorA.setSpeed(1000);
//		motorA.setAcceleration(1000);
//		myrotate(motorA, -1000);
//		LCD.drawString("mA " + String.valueOf(motorA.getTachoCount()),0,1);
//		Delay.msDelay(1000);
//		
//		motorA.setSpeed(1000);
//		motorA.setAcceleration(1000);
//		LCD.drawString("Bewegung",0,2);
//		for (int i = 1; i <= 16; i++) {
//			myrotate(motorA,i);
//			LCD.drawString("i " + i,0,4);
//			Delay.msDelay(200);
//			myrotate(motorA, i * (-1));
//			LCD.drawString("i " + i,0,4);
//			Delay.msDelay(200);
//		}
//		
//		LCD.drawString("Ende Bewegung " + String.valueOf(motorA.getTachoCount()),0,5);
//		Delay.msDelay(2000);
//		LCD.drawString("Ende Test 4",0,7);
//		
//		LCD.drawString("5.1 " + String.valueOf(motorA.getTachoCount()),0,0);
//		Delay.msDelay(5000);
//		myrotate(motorA, 100);
//		LCD.drawString("5.1 " + String.valueOf(motorA.getTachoCount()),0,1);
//		Delay.msDelay(5000);
//	
//		Test 6
		
//		LCD.drawString("MaxSpeed " + motorA.getMaxSpeed(), 0, 1);
//		Delay.msDelay(1000);
////
//		calibrate();
//		motorA.setSpeed(360);
//		motorA.setAcceleration(360);
//		// myrotate(motorA, -100);
//		LCD.drawString("TachoMotorA " + motorA.getTachoCount(), 0, 2);
//		Delay.msDelay(2000);
//		myrotate2(motorA, -1500);
//		LCD.drawString("TachoMotorA " + motorA.getTachoCount(), 0, 2);
//		Delay.msDelay(2000);
//		myrotate2(motorA, -100);
//		LCD.drawString("TachoMotorA " + motorA.getTachoCount(), 0, 2);
//		Delay.msDelay(2000);
//		myrotate2(motorA, -100);
//		LCD.drawString("TachoMotorA " + motorA.getTachoCount(), 0, 2);
//		Delay.msDelay(2000);
//		myrotate2(motorA, -100);
//		LCD.drawString("TachoMotorA " + motorA.getTachoCount(), 0, 2);
//		Delay.msDelay(2000);
//		myrotate(motorA, (-1 * motorA.getTachoCount()) - 50);
//		motorA.stop();
//
//		// Stift zum Ende immer nach oben fahren
//		penup();
		
//		easteregg(duck1,duration1);
//		Delay.msDelay(1000);
//		easteregg(duck2,duration2);
	//	easteregg(duck, duration);
		
		

//		Aufgabe 1-5 move(distance in mm, mmSec in mm, motor
//		move(100, 10, motorA);
		
//		Aufgabe 1-6 move(x in mm, x in mm, mm/Sec in mm
		move(80,40,10);
		
		calibrate();
		move(160,100,50);
		
		
		Sound.twoBeeps();
	}

	private static void myrotate(RegulatedMotor motor, int grad) {
		motor.rotate(grad);
	}

	private static void myrotate2(RegulatedMotor motor, int grad) {
		if (motor.getTachoCount() + grad > maxAnglemotorA) {
			LCD.drawString("myRot2 1 " + String.valueOf(grad) + "°", 0, 3);
			motor.rotate(grad);
		} else {
			LCD.drawString("myRot2 2 " + String.valueOf(maxAnglemotorA - motorA.getTachoCount()) + "°", 0, 4);
			motor.rotate(maxAnglemotorA - motorA.getTachoCount());

		}
	}

	private static void myrotate3(RegulatedMotor motor, int grad) {
		while (motorA.getTachoCount() > maxAnglemotorA)
			motor.rotate(grad);
	}

//	Aufgabe 5 ********************************************************************************************

// distance in mm; mm/sek; Motor A,B oder C
	public static void move(int distance, int intmmSec, RegulatedMotor motor) {
		int rotator;
		double speedmmsec;
		

		// RegulatedMotor motorPort1 = new EV3LargeRegulatedMotor(MotorPort.motorPort);

		// Berechnung Umdrehungen in Grad
		rotator = (int) Math
				.round((distance / (dRad * Math.PI) * 360 * (Double.valueOf(gearRatioB[1]) / gearRatioB[0])));
		LCD.drawString(String.valueOf(-rotator), 0, 0);
		// Berechnung Geschwindigkeit

		motor.setSpeed((int)(intmmSec * ratioA1mm));
		motor.rotate(-rotator);

	}

// Aufgabe 6 ********************************************************************************************

	// Idee:
	/**
	 * Stift muss zu Beginn wissen, wo er sich befindet. Schlitten fährt immer zu
	 * Nullpunkt (TouchSensor), um sich zu kalibrieren. Dafür eigene Methode
	 * calibrate() Berechnung der Geschwindigkeit benötigt Länge der Linie;
	 * Berechnung erfolgt über Satz des Pythagoras
	 * 
	 * @param x     Bewegung seitlich über Schlitten / Motor A in mm
	 * @param y     Bewegung vertikal über Papiereinzug / Motor B in mm
	 * @param mmSec Geschwindigkeit, die der Stift fahren soll
	 * 
	 *              Kopplung beider Motoren mit berechneten Speed-Werten
	 * 
	 */

	public static void move(int x, int y, int mmSec) {
		
		LCD.clear();
		LCD.drawString(String.valueOf("move(x,y,mmSec)"), 0, 0);
		LCD.drawString(String.valueOf("x = " + x), 0, 1);
		LCD.drawString(String.valueOf("y = " + y), 0, 2);
		LCD.drawString(String.valueOf("mmSec = " + mmSec), 0, 3);
		Delay.msDelay(2000);
		
		double lHyp = Math.hypot(x, y);
		
//		LCD.clear();
//		LCD.drawString(String.valueOf("LHyp = " + lHyp), 0, 1);
//		Delay.msDelay(2000);Delay.msDelay(2000);
			
		
//		double speedmmsec;
//		int[] gearRatioA = new int[] { 12, 36 };
		RegulatedMotor[] syncList1 = new RegulatedMotor[] { motorB };
		double t = lHyp / mmSec;
		
		LCD.clear();
		LCD.drawString(String.valueOf("t = " + t), 0, 1);
		Delay.msDelay(2000);Delay.msDelay(2000);
			
		
//		Berechnung Geschwindigkeit
//		x und y stehen für die Stiftposition in echt; Variablen mit A oder B hingegen für den Motor		
		double vx = x / t; // mm/sec    
		double vy = y / t; // mm/sec
		
		
		LCD.clear();
		LCD.drawString(String.valueOf("vx = " + vx), 0, 1);
		LCD.drawString(String.valueOf("vy = " + vy), 0, 2);
		Delay.msDelay(2000);Delay.msDelay(2000);
		

		calibrate();

		// Synchronisation der beiden Motoren A (Schlitten) und B (Papiereinzug)
		motorA.synchronizeWith(new RegulatedMotor[] {motorB});

		//

		motorA.setAcceleration(Integer.MAX_VALUE);
		motorB.setAcceleration(Integer.MAX_VALUE);
		motorA.setSpeed((int) Math.round((vx * ratioA1mm)));
		motorB.setSpeed((int) Math.round((vy * ratioB1mm)));

		LCD.clear();
		LCD.drawString(String.valueOf("speed A = " + motorA.getSpeed()), 0, 1);
		LCD.drawString(String.valueOf("speed B = " + motorB.getSpeed()), 0, 2);
		Delay.msDelay(2000);Delay.msDelay(2000);
		
		
		motorA.startSynchronization();
		
		

//		// Berechnung Umdrehungen in Grad
		int rotatorX = (int) Math.round(x * ratioA1mm);
		int rotatorY = (int) Math.round(y * ratioB1mm);
		
		LCD.clear();
		LCD.drawString(String.valueOf("angleA = " + rotatorX), 0, 1);
		LCD.drawString(String.valueOf("angleB = " + rotatorY), 0, 2);
		Delay.msDelay(2000);Delay.msDelay(2000);
				


//
//		motor.setSpeed(intmmSec);
		motorA.rotate(-rotatorX, true);
		motorB.rotate(-rotatorY, true);
		
		
		motorA.endSynchronization();
		motorA.waitComplete();
		motorB.waitComplete();
	}

	/**
	 * Kalibrierung von Motor A (Schlitten)
	 * 
	 */

	static void calibrate() {
		penup();
		motorA.setSpeed(50);
		motorA.setAcceleration(1000);
		while (sample[0] == 0) {
			motorA.forward();
			Delay.msDelay(1);
			sensorMode.fetchSample(sample, 0);
			if (motorA.isStalled()) {
				motorA.stop();
			}
		}
		motorA.stop();
		motorA.resetTachoCount();
		LCD.drawString("Kalibriert!", 0, 0);
		LCD.drawString("TachoA " + String.valueOf(motorA.getTachoCount()), 0, 1);
		Sound.beep();
		Delay.msDelay(2000);

	}

// Methoden für Stift - Hoch und runter
	static void penup() {
		if (penState != 0) {
			myrotate(motorC, -180);
			penState = 0;
		}
	}

	static void pendown() {
		if (penState != 1) {
			myrotate(motorC, 180);
			penState = 1;
		}
	}

// Imperial March
	static void easteregg(int[] duck, int[] dur) {
		Sound.setVolume(10);
		for (int i = 0; i < duck.length; i++) {
			Sound.playTone(duck[i], dur[i]);
			//Thread.sleep(500 + 5 * duration[i]);
		}

	}

}
