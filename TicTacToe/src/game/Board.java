package game;

//Board ist ein das Spielbrett, es besteht aus 9 Feldern in quadratischer Anordung
public class Board {

	
	//FÜr Testzwecke
//	public static void main(String args[]) {
//	
//		Board boardtest = new Board();
//		boardtest.printBoardConsole();	//Ausgabe des Boards auf Konsole
//		boardtest.setBoard(1, 2, 2);
//		boardtest.printBoardConsole();
//		
//	}
	
	// 2-dimensionales Array aus Typ "field"
	public Field[][] field = new Field[3][3];

	// Konstuktor: Durchläuft alle Felder des Boards in einer 2-stufigen Schleife
	// und erstellt leere
	// Felder durch Aufruf des field-Konstruktors
	public Board() {
		//j vertikal |
		for (int j = 0; j <=2; j++) {
			// i horizontal --
			for (int i = 0;  i<=2; i++) {
				this.field[i][j] = new Field();
				//System.out.println("i: "+ i+ " j: " + j);
			}
		}
	}

//werden zunächst nicht benötigt
//	public field[][] getBoard() {
//		return board;
//	}

	public void setBoard(int i, int j, int newfieldvalue, Round round) {
		if (this.field[i][j].isFree()) {
			this.field[i][j].setFieldValue(newfieldvalue);
			round.setCountMoves(round.getCountMoves()+1);
		}
		else System.out.println("Ungültig: Feld besetzt");
	}

	/*
	 * Klassenmethoden
	 */

	public void printBoardConsole() {
		System.out.println();
		for (int j = 0; j <= 2; j++) {
			for (int i = 0; i <= 2; i++) {
				int temp;
				temp = this.field[i][j].getFieldValue();
				if (temp == 1) {
					System.out.print("|X"); 
				}
				else if (temp == 2){
					System.out.print("|O");
				}
				else {
					System.out.print("| ");
				}
			}
			System.out.println("|");
		}
		System.out.println();
	}

	public void resetBoard() {
		for (int i = 0; i < this.field.length; i++) {
			for (int j = 0; j < this.field.length; j++) {
				this.field[i][j].setFieldValue(0);
				;
			}
		}
	}

}
