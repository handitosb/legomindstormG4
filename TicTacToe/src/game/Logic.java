package game;

import basics.*;
import controls.*;

import players.Computer;
import players.Human;
import players.Player;
import game.Round;
import game.Match;
import java.util.Random;
import java.util.Scanner;

public class Logic {
	
	
	public static void main(String args[]) {
		init();
		
		
		
//		showmainmenu();
//		Delay.msDelay(3000);
//		Display.clear();
//		Display.drawString("Push Button");
//		ButtonID = Button.waitForAnyEvent(ButtonID);
//		//System.out.println("buttonID "+ ButtonID);
//		Display.drawString(Integer.toString(ButtonID));
//		Delay.msDelay(1000);
		//System.out.println("Gewonnen");
	}

	private static void init() {
		
		
		// Roboter robot = new Roboter();
		// Display display = new Display();
		// Match match = new Match();
		Match match = new Match(1,1);
		Round round = new Round(match);
		Computer computer1 = new Computer();
		Computer computer2 = new Computer();
		Human player1 = new Human();
		Human player2 = new Human();
		
		matchType1(match, round);
		

	}
	public static void matchType1(Match match, Round round) {
		int playerFeld = 0;
		int x;
		int y;
		for (int i = 0; i < 10; i++) {
			while (true) {
				playerFeld = Human.playerZug(round);
				x = (playerFeld - 1) % 3;
				y = (playerFeld - 1) / 3;
				round.board.setBoard(x, y, round.getPlayerTurn(), round);
                round.board.printBoardConsole();
                if (round.isWon()) {
                    match.setScore(round.getRoundWinner()-1,match.getScore(round.getRoundWinner()-1)+1);
                    System.out.println("Gewonnen von Spieler " + round.getRoundWinner() );
                    System.out.println("Spielstand ");
                    match.printScore();
                    return;
                    }
                round.changeTurn();
			}
		}
	}

	// MatchType = 2 C vs. C
//	public static void matchType2(Match match, Round round) {
//        System.out.println("Es beginnt Computer " + match.getBeginner());
//        int AIfeld = 0;
//        int x;
//        int y;
//        for (int i = 1; i < 10; i++) {
//            System.out.println("Zug " + i); // Bugfixing
//            //if (round.getPlayerTurn() == 1) {
//
//                AIfeld = Computer.AIZug(round);
//                x = (AIfeld - 1) % 3;
//                y = (AIfeld - 1) / 3;
//                round.board.setBoard(x, y, round.getPlayerTurn(), round);
//                round.board.printBoardConsole();
//                if (round.isWon()) {
//                    match.setScore(round.getRoundWinner()-1,match.getScore(round.getRoundWinner()-1)+1);
//                    System.out.println("Gewonnen von Spieler " + round.getRoundWinner() );
//                    System.out.println("Spielstand ");
//                    match.printScore();
//                    return;
//                    }
//                round.changeTurn();
//            //}
//        }
//    }
	

	private static void showmainmenu() {
		String[] stringmainmenu = new String[] { "Tic-Tac-Toe", "Mensch gegen Mensch", "Mensch vs Computer",
				"Computer vs Computer" };
		controls.Display.drawStringpkg(stringmainmenu);
	}

	// Init
	// Main Menu
	// Abfrage: Human vs. Human oder Human vs. Computer
	// Abfrage: Wer f�ngt an
	// New Match
	// New Round
	// New Board
	// (class Control) warte auf Eingabe
	// (class Logic) Logic ->> valid?
	// (class Board) Draw()
	// (class Display) Round "O is next"--> Display LCD.print"O is next"
	// (class Logic) Pr�fung, ob gewonnen
	// (Control/class Input) freigegeben
	// (Logic/ Display) "Noch ein Spiel?" (ja-> resetBoard(), nein -> MainMenu)
	// (class Input) Verarbeitung Eingabe

}
