import java.awt.Image;

//Osztály: Sárga lövedék
public class YellowBullet extends Bullet {
	private Image image;
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m) {

		super(directions,coord,m);
		System.out.println("BlueBullet: konstruktor hívás");
	
	}
	
	public void open()
	{
		map.map[loc.getY()][loc.getX()]=new Portal(loc);
		System.out.println("BlueBullet: Sárga portál nyílt");
	}
	
}
