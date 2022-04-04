package game;

//Field ist ein einzelnes Feld eines Spielbretts
public class Field {
	
	private int fieldValue; // 0 = Feld ist leer; 1 = Feld ist "X"; 2 Feld ist "O"

	//Konstruktor: Jedes neue Feld ist am Anfang leer, daher 0
	public Field() {
		setFieldValue(0);
	}
	
	public int getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(int newfieldValue) {
		this.fieldValue = newfieldValue;
	}
	
	public boolean isFree() {
		if (this.getFieldValue() == 0) return true;
		return false;
	}
	
	
}
