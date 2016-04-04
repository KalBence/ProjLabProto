import java.awt.Image;

//Osztály a Portal kezelésére
public class Portal extends Tile {
private Coord location; //a portál koordinátája
public WormHole wormhole;
Useable object;
Image image;

//Konstruktor
	Portal(Coord c){
		super( new Coord(c.getX(),c.getY()));
		System.out.println("Portal: konstruktor hívás");
		System.out.println("A portál létrejött");
	};
	
	public void setWH(WormHole wh) {
		wormhole = wh;
	}
	
	//A portálra lépést kezeli
	@Override 
	public Coord stepOn(Coord c) {
		if (wormhole.isOpen()==true){  //Ha nyitva van
			if(wormhole.getBlue().getX()==c.getX()+1 && wormhole.getBlue().getY()==c.getY()){	 //és ez kék portál
				return wormhole.getYellow(); //adja vissza a sárga koordinátáit
				}
			else	
			return wormhole.getBlue(); //egyébként a kékét
		}
			else return location;	 //egyébként a helyzetét
		}
	
	//koord lekérdezése
	public Coord getLoc()
	{
		System.out.println("Portal: getloc metódus hívás");
		return location;
	}
	//koord beállítása
	public void setLoc(Coord c)
	{
		System.out.println("Portal: setloc metódus hívás");
		location=c;
	}
	
	public Useable getObj(){
		System.out.println("Portal: getObj metódus hívás");
		return null;
	}
	
	public boolean setObj(Useable o)
	{
		System.out.println("Portal: setObj metódus hívás");
		return false;
	}
	
	
	@Override
	public boolean fly(Bullet b)
	 {
		 System.out.println("Portal: fly metódus hívás");
		 return false;
	 }

}
