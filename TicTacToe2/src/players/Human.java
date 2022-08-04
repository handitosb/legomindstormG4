package players;

import java.util.ArrayList;
import java.util.Scanner;

import game.Round;

public class Human extends Player{
	
	public Human() {
		this.type=0;
	}


	public static int playerZug(Round round) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (round.getCountMoves() <= 9 ) {
			int zug = sc.nextInt();
			if (round.board.field[((zug-1) % 3)][(zug - 1) / 3].isFree()) {
				return zug;
			} else {
				System.out.println("Bitte gib nur Zahlen von 1 bis 3 ein.");
			}
		}
		return 0;
	}

}
