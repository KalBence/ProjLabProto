public class SpecialWall extends Wall {
	
	public SpecialWall (Coord c) {
		super(c);
	}
	
	//Megmondja, hogy ONeil mit csináljon, ha falra akar lépni 
		@Override
		public Coord stepOn(Coord k) {
			System.out.println("Wall: stepOn metódus hívás, ONeil nem tud erre a mezõre, marad az eredeti helyén");
			return k;
		}
		
		@Override
		public boolean fly(Bullet b)
		{
			 b.open();
			 return false;
		}
		
	
}
