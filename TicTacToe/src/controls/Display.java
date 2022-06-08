package controls;

import basics.Roboter;
import game.Field;
import game.Round;
import lejos.hardware.lcd.*;
import positions.Position3D;

public class Display {

	private static int row = 1;
	public Roboter robot;
	public int[][] field = new int[3][3];
	
	public Display(Roboter robot) {
		this.robot = robot;
	}
	
	public static void drawString(String message) {
		// LCD.clearDisplay();
		// LCD.clear();
		LCD.drawString("Hallo", 0, 1);
		LCD.drawString(message, 0, row++);
	}
	
	public static void drawStringpkg(String[] message) {
		// LCD.clearDisplay();
		// LCD.clear();
		for (int i = 0; i < message.length; i++) {
			Display.drawString(message[i]);
		}
		row = 1;
	}
	
	public static void drawStringConsole(String message) {
		// LCD.clearDisplay();
		// LCD.clear();
		System.out.println(message +" 1 " + " " + row);row++;
	}
	
	public static void drawStringConsolepkg(String[] message) {
		// LCD.clearDisplay();
		// LCD.clear();
		for (int i = 0; i < message.length; i++) {
			Display.drawStringConsole(message[i]);
		}
		row = 1;
	}
	
	public static void clear() {
		LCD.clear();
	}
	
	public static void messagePosition(String top, String middle, String bottom) {
		LCD.drawString(top, 0, 1);
		LCD.drawString(middle, 0, 3);
		LCD.drawString(bottom, 0, 7);
	}
	
	public int pvpcvp(String lineTop, String lineMiddle, String lineBottom) {
		int cursor = 1;
		boolean move = true;
		while (move) {
			messagePosition(lineTop, lineMiddle, lineBottom + " " + cursor);
			int button = Button.waitForAnyPress();
			if (button == Button.ID_RIGHT)
				cursor =+ 1;
			else if (button == Button.ID_LEFT)
				cursor =+ -1;
			else if (button == Button.ID_ENTER) {
				move = false;
				break;
			}
			else
				Display.drawString("Wrong input!");
				
		}
		return cursor;
	}
	
	public void feldVorbereiten() throws InterruptedException {
		robot.bereitePapierVor();
		robot.moveToHomePosition();
		robot.moveRobot(field);
	}
	

	public void moveRobot(int[][] field) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}
}
