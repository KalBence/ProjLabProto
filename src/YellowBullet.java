import java.awt.Image;

//Oszt�ly: S�rga l�ved�k
public class YellowBullet extends Bullet {
	private Image image;
	public WormHole wormhole;
	

	public YellowBullet(ONeil.Directions directions, Coord coord, Map m) {

		super(directions,coord,m);
		System.out.println("BlueBullet: konstruktor h�v�s");
	
	}
	
	public void open()
	{
		map.map[loc.getY()][loc.getX()]=new Portal(loc);
		System.out.println("BlueBullet: S�rga port�l ny�lt");
	}
	
}
