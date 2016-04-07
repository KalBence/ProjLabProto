import java.awt.Image;


public class RedBullet extends Bullet{
	private Image image;
	public WormHole wormhole;
	
	//Konstruktor
	public RedBullet(Jaffa.Directions directions, Coord coord, Map m)
	{
		super(directions,coord,m);
		System.out.println("RedBullet: konstruktor hívás");
			
	}
	
	//Portál nyitás
	public void open() 
	{
		System.out.println("RedBullett: open metódus hívás");
		map.map[loc.getY()][loc.getX()]=new Portal(loc);
		System.out.println("RedBullet: piros portál nyílt");
	}
	
}

