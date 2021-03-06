//Oszt�ly a p�ly�n elhelyeszked� ajt�k kezel�s�re
public class Door extends  Wall {
	private Boolean isOpen; //True, ha nyitva az ajt�, false ha csukva
	
	//Konstruktor
	public Door (Coord c) {
		super(c);
		System.out.println("Door: konsturktor h�v�s");
		isOpen=false; //Alap�rtelmezetten csukva van
	}
	
	//Met�dus: az ajt� kinyit�s�ra illetve becsuk�s�ra szolg�l
	@Override 
	public void openDoor() {
		System.out.println("Door: open met�dus h�v�sa");
		if(isOpen==false) //Ha csukva van..
		{
			System.out.println("Ajt� kinyitva");
			isOpen=true; //..nyissa ki
		}
	}
	
	public void closeDoor() {
		System.out.println("Door: open met�dus h�v�sa");
		if(isOpen==true) //Ha csukva van..
		{
			System.out.println("Ajt� kinyitva");
			isOpen=false; //..nyissa ki
		}
	}
	
	//Csukott ajt� eset�n nem engedi �t ONeillt, nyitott ajt� eset�n pedig igen
	@Override
	public Coord stepOn(Coord c) {
		System.out.println("Door: stepOn met�dus h�v�s");
		if(isOpen==false)
		{	
			System.out.println("ONeill marad a hely�n.");
			return c; //visszat�r a ONeill koordin�t�ival
		}
		else
		{
			System.out.println("ONeill �tmehet az ajt�n");
			return this.getLoc(); //Visszat�r az ajt� koordin�t�j�val
		}
	}
}
