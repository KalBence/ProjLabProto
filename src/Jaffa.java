
public class Jaffa extends Caracter {
	private int weight;
	 
	 //Konstruktor
	public Jaffa(Map map,int lives) {
		super(map,lives);
		System.out.println("Jaffa: konstruktor met�dus h�v�s");
		loc = new Coord(8,7); //(oszlop,sor)
	}
	

	
	//Felvesz egy t�rgyat
	public void pickUp() {
		System.out.println("ONeil: pickUp met�dus h�v�s");
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].getObj(); //Koordin�t�k be�ll�t�sa
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].getObj(); //Koordin�t�k be�ll�t�sa
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].getObj(); //Koordin�t�k be�ll�t�sa
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].getObj(); //Koordin�t�k be�ll�t�sa
			break;		
		}
	}
	
	//L�v�s kezel�se
	public void shoot(char c,WormHole w) {
		
		System.out.println("ONeil: shoot met�dus h�v�s");
		if(c=='r')
		{
			System.out.println("Red bullet");
			RedBullet r = new RedBullet(direction, loc , map,w);
			r.move();
		}
		
		if(c=='g')
		{
			System.out.println("Green bullet");
			GreenBullet g = new GreenBullet(direction, loc , map,w);
			g.move();
		}
		
	}
	

	
	//Item lerak�sa
	public void dropDown() {
		System.out.println("ONeil: dropDown met�dus h�v�s");
		switch (direction) {
		case Up: //fel
			map.map[loc.getY()-1][loc.getX()].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;
		case Down: //le
			map.map[loc.getY()+1][loc.getX()].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;
		case Left: //balra
			map.map[loc.getY()][loc.getX()-1].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;
		case Right: //jobbra
			map.map[loc.getY()][loc.getX()+1].setObj(object); //Koordin�t�k be�ll�t�sa
			object = null;
		break;		
	}
}
	
}
