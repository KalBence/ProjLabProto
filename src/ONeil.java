import java.awt.Image;

//import Bullet.Directions;

//Oszt�ly ONeil kezel�s�re
public class ONeil {
	private Image image;
	 int lives; //�leteinek a sz�ma
	 Map map;   
	 public Coord loc;  //koordin�t�i
	 public Useable object; //milyen t�rgy van n�la
	 
	 //enumer�ci� az ir�nyokra
	 public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right
		}
	 
	 Directions direction = Directions.Down;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		System.out.println("ONeil: konstruktor met�dus h�v�s");
		this.map=map;
		this.lives=lives;
		loc = new Coord(8,7); //(oszlop,sor)
	}
	
	//Mozg�s�t kezel� met�dus
	public void move() {
		System.out.println("ONeil: move met�dus h�v�s");
		switch (direction) {
			case Up:  //Felfele mozg�s
				loc = map.map[loc.getY()-1][loc.getX()].stepOn(loc); //Koordin�t�k be�ll�t�sa
				direction = Directions.Up;
			break;
			case Down: //Lefele mozg�s
				loc = map.map[loc.getY()+1][loc.getX()].stepOn(loc); //Koordin�t�k be�ll�t�sa
				direction = Directions.Down;
			break;
			case Left: //Balra mozg�s
				loc = map.map[loc.getY()][loc.getX()-1].stepOn(loc); //Koordin�t�k be�ll�t�sa
				direction = Directions.Left;
			break;
			case Right: //Jobbra mozg�s
				loc = map.map[loc.getY()][loc.getX()+1].stepOn(loc); //Koordin�t�k be�ll�t�sa
				direction = Directions.Right;
			break;		
		}
		
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
	public void shoot() {
		System.out.println("ONeil: shoot met�dus h�v�s");
		BlueBullet b = new BlueBullet(direction, loc , map);
		b.move();
		
	}
	
	//Koordin�ta visszad�sa
	public Coord getLoc() {
		System.out.println("ONeil: getloc met�dus h�v�s");
		return loc;
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
