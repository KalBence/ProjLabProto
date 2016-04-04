import java.awt.Image;

//ingyom bingyom répakrém más is homo nem csak én

//Osztály a kék lövedék kezelésére
public class BlueBullet extends Bullet {
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public BlueBullet(ONeil.Directions directions, Coord coord, Map m)
	{
		super(directions,coord,m);
		System.out.println("BlueBullet: konstruktor hívás");
			
	}
	
	//Portál nyitás
	public void open() 
	{
		System.out.println("BlueBullet: open metódus hívás");
		map.map[loc.getY()][loc.getX()]=new Portal(loc);
		System.out.println("BlueBullet: Kék portál nyílt");
	}
	
}
