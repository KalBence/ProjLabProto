//oszt�ly a p�lya koordin�t�inak a t�rol�s�ra
public class Coord {
	private int x;  //adott pont x koordin�t�j�t t�rolja
	private int y;  //adott pont y koordin�t�j�t t�rolja
	
	//Konstruktor, x,y attrib�tum �rt�keinek be�ll�t�s�ra
	public  Coord(int x, int y) {
	//	System.out.println("Coord: konstruktor");
		this.x=x;
		this.y=y;
	}
	
	//Met�dus az x koordin�ta lek�rdez�s�re
	public int getX() {
	//0	System.out.println("Coord: getX met�dus h�v�s");
		return x;
	}
	
	//Met�dus az y koordin�ta lek�rdez�s�re
	public int getY() {
	//	System.out.println("Coord: getY met�dus h�v�s");
		return y;
	}
	
	//Met�dus az x koordin�ta be�ll�t�s�ra
	public void setX(int x) {
	//	System.out.println("Coord: setX met�dus h�v�s");
		this.x=x;
	}
	
	//Met�dus az y koordin�ta be�ll�t�s�ra
	public void setY(int y) {
	//	System.out.println("Coord: setY met�dus h�v�s");
		this.y=y;
	}
}
