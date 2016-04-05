import java.awt.Image;

//import Bullet.Directions;

//Osztály ONeil kezelésére
public class ONeil {
	private Image image;
	 int lives; //életeinek a száma
	 Map map;   
	 public Coord loc;  //koordinátái
	 public Useable object; //milyen tárgy van nála
	 
	 //enumeráció az irányokra
	 public enum Directions{
		  Up, 
		  Down, 
		  Left, 
		  Right
		}
	 
	 Directions direction = Directions.Down;
	 
	 //Konstruktor
	public ONeil(Map map,int lives) {
		System.out.println("ONeil: konstruktor metódus hívás");
		this.map=map;
		this.lives=lives;
		loc = new Coord(8,7); //(oszlop,sor)
	}
	
	//Mozgását kezelõ metódus
	public void move() {
		System.out.println("ONeil: move metódus hívás");
		switch (direction) {
			case Up:  //Felfele mozgás
				loc = map.map[loc.getY()-1][loc.getX()].stepOn(loc); //Koordináták beállítása
				direction = Directions.Up;
			break;
			case Down: //Lefele mozgás
				loc = map.map[loc.getY()+1][loc.getX()].stepOn(loc); //Koordináták beállítása
				direction = Directions.Down;
			break;
			case Left: //Balra mozgás
				loc = map.map[loc.getY()][loc.getX()-1].stepOn(loc); //Koordináták beállítása
				direction = Directions.Left;
			break;
			case Right: //Jobbra mozgás
				loc = map.map[loc.getY()][loc.getX()+1].stepOn(loc); //Koordináták beállítása
				direction = Directions.Right;
			break;		
		}
		
	}
	
	//Felvesz egy tárgyat
	public void pickUp() {
		System.out.println("ONeil: pickUp metódus hívás");
		switch (direction) {
			case Up:   //Fel
				object = map.map[loc.getY()-1][loc.getX()].getObj(); //Koordináták beállítása
			break;
			case Down: //le
				object = map.map[loc.getY()+1][loc.getX()].getObj(); //Koordináták beállítása
			break;
			case Left: //Balra
				object = map.map[loc.getY()][loc.getX()-1].getObj(); //Koordináták beállítása
			break;
			case Right: //Jobb
				object = map.map[loc.getY()][loc.getX()+1].getObj(); //Koordináták beállítása
			break;		
		}
	}
	
	//Lövés kezelése
	public void shoot() {
		System.out.println("ONeil: shoot metódus hívás");
		BlueBullet b = new BlueBullet(direction, loc , map);
		b.move();
		
	}
	
	//Koordináta visszadása
	public Coord getLoc() {
		System.out.println("ONeil: getloc metódus hívás");
		return loc;
	}
	
	
	//Item lerakása
	public void dropDown() {
		System.out.println("ONeil: dropDown metódus hívás");
		switch (direction) {
		case Up: //fel
			map.map[loc.getY()-1][loc.getX()].setObj(object); //Koordináták beállítása
			object = null;
		break;
		case Down: //le
			map.map[loc.getY()+1][loc.getX()].setObj(object); //Koordináták beállítása
			object = null;
		break;
		case Left: //balra
			map.map[loc.getY()][loc.getX()-1].setObj(object); //Koordináták beállítása
			object = null;
		break;
		case Right: //jobbra
			map.map[loc.getY()][loc.getX()+1].setObj(object); //Koordináták beállítása
			object = null;
		break;		
	}
}
	
	
}
