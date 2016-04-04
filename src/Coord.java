//osztály a pálya koordinátáinak a tárolására
public class Coord {
	private int x;  //adott pont x koordinátáját tárolja
	private int y;  //adott pont y koordinátáját tárolja
	
	//Konstruktor, x,y attribútum értékeinek beállítására
	public  Coord(int x, int y) {
	//	System.out.println("Coord: konstruktor");
		this.x=x;
		this.y=y;
	}
	
	//Metódus az x koordináta lekérdezésére
	public int getX() {
	//0	System.out.println("Coord: getX metódus hívás");
		return x;
	}
	
	//Metódus az y koordináta lekérdezésére
	public int getY() {
	//	System.out.println("Coord: getY metódus hívás");
		return y;
	}
	
	//Metódus az x koordináta beállítására
	public void setX(int x) {
	//	System.out.println("Coord: setX metódus hívás");
		this.x=x;
	}
	
	//Metódus az y koordináta beállítására
	public void setY(int y) {
	//	System.out.println("Coord: setY metódus hívás");
		this.y=y;
	}
}
