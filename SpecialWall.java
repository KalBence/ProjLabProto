//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SpecialWall.java
//  @ Date : 2016.03.27.
//  @ Author : 
//
//




public class SpecialWall extends Wall {
	
	public SpecialWall (Coord c) {
		super(c);
	}
	
	//Megmondja, hogy ONeil mit csin�ljon, ha falra akar l�pni 
		@Override
		public Coord stepOn(Coord k) {
			System.out.println("Wall: stepOn met�dus h�v�s, ONeil nem tud erre a mez�re, marad az eredeti hely�n");
			return k;
		}
		
		@Override
		public boolean fly(Bullet b)
		{
			 b.open();
			 return false;
		}
		
	
}
