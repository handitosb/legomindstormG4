package players;

import game.*;
import java.math.*;
import java.util.Random;

import game.*;

public class Computer extends Player implements AI {

	public Computer() {
		this.type = 1;
	}

//	@Override
//	public Field AIZug(Round round) {
//		while (round.isEnd() != true && round.getCountMoves() < 9) {
//			Random rn = new Random();
//			int randomNumber = rn.nextInt(9) + 1;
//			if (round.board.field[(randomNumber % 3) - 1][(randomNumber - 1) / 3].isFree()) {
//				return round.board.field[(randomNumber % 3) - 1][(randomNumber - 1) / 3];
//			}
//		}
//		return null;
//	}
	
	
	public static int AIZug(Round round) {
			Random rn = new Random();
			while (round.getCountMoves() < 9 ) {
				int randomNumber = rn.nextInt(9)+1;
				if (round.board.field[((randomNumber-1) % 3)][(randomNumber - 1) / 3].isFree()) {
								return randomNumber;
				}
			}
			return 0;
		}
	

	// Alte Idee: Zug anhand der bereits gemachten Z�ge w�hlen
//	@Override
//	public void Zug2();
//	
//	@Override
//	public void Zug3();
//	
//	@Override
//	public void Zug4();
//	
//	@Override
//	public void Zug5();
//	
//	@Override
//	public void Zug6();
//	
//	@Override
//	public void Zug7();
//	
//	@Override
//	public void Zug8();
//	
//	@Override
//	public void Zug9();	
//	

}
