//Oszt�ly a ground kezel�s�re
public class Ground extends Tile {
	public Boolean hasLifeOnIT; //t�rolja hogy van-e �let a ground-on
	
	
	//Konstruktor
	public Ground (Coord c) {
		super(c);
		System.out.println("Ground: konstruktor h�v�s");
	}
	
	//Met�dus annak az esetnek a kezel�s�re ha vki groundra l�p
	@Override
	public Coord stepOn(Coord c) {
		System.out.println("Ground: stepOn met�dus h�v�s");
		return location; //visszat�r a saj�t koordin�t�ival

	}
	
	
	

}
