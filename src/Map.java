import java.io.File;

//A p�lya oszt�lya
public class Map {
	private ONeil oneil;
	private int sizeX;
	private int sizeY;
	private int ZPMcount;
	public Tile[][] map = new Tile[4][4];
	
	public int getSizeX() {
		return sizeX;		
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public Map() {
		
	}
	
	//p�lya fel�p�t�se
	//a v�gleges verzi�ba itt egy f�jlb�l lesz kiolvasva a m�trix 
	//�s ebb�l �p�ti fel a p�ly�t az itt l�totthoz hasonl� m�don
	public void init(int[][] test) {
		System.out.println("Map: init met�dus h�v�s");
        for (int i = 0; i<4; i++) {
        	for (int j = 0; j<4; j++) {
        		int id = test[i][j]; 
        		Coord c= new Coord(j,i);
        		
        		switch (id) {
        		case 0:
        			map[i][j] = new Ground(c);
        			break;
        		}
        	}
       }
       sizeX=4;		//f�jlba l�v� m�trix m�ret�t�l f�gg majd, most fix 4
       sizeY=4;		//f�jlba l�v� m�trix m�ret�t�l f�gg majd, most fix 4
       ZPMcount=7;	
	}
	public void init3() {
        Coord c = new Coord(2,1);
        map[1][2] = new Ground(c);       
	}
	
	public void init4() {
        Coord c = new Coord(2,1);
        map[1][2] = new Wall(c);       
	}
	
	
	public void init5() {
        Coord c1 = new Coord(2,1);
        Coord c2 = new Coord(0,0);
        map[1][2] = new Portal(c1); 
        
        WormHole wh = new WormHole();
        wh.setBlue(c1);
        wh.setYellow(c2);
        map[1][2].setWH(wh);
        
	}
	
	public void init6() {
        Coord c1 = new Coord(2,1);
        Coord c2 = new Coord(2,2);
        map[1][2] = new Scale(c1,c2,this);      
        map[2][2] = new Door(c2); 
	}
	
	public void init8() {
        Coord c = new Coord(2,1);
        map[1][2] = new SpaceShip(c);       
	}
	
	public void init9() {
        Coord c = new Coord(2,1);
        map[1][2] = new Door(c);       
	}
	
	public void init11() {
        Coord c = new Coord(2,1);
        map[1][2] = new Ground(c); 
        map[1][2].object = new ZPM();   
	}
	
	public void init12() {
        Coord c = new Coord(2,1);
        map[1][2] = new Ground(c); 
	}
	
	
	
	public void init15() {
        Coord c1 = new Coord(2,1);
        Coord c2 = new Coord(2,2);
        Box b= new Box();
        map[1][2] = new Scale(c1,c2,this);      
        map[2][2] = new Door(c2); 
        map[1][2].setObj(b);
       
	}
	
	public void init7() {
		oneil=new ONeil(this,1);
        Coord c = new Coord(2,1);
        map[1][2] = new Pit(oneil,c);       
	}

	public void init10() {
		oneil=new ONeil(this,7);
        Coord c = new Coord(2,1);
        map[1][2] = new Pit(oneil,c);       
	}
	
	public void init14(){
		Coord c = new Coord(2,1);
        map[1][2] = new SpaceShip(c);
        
	}
	public void init16(){
		Coord c = new Coord(2,1);
        map[1][2] = new SpecialWall(c);        
	}
	
	public void init17(){
		Coord c = new Coord(2,1);
        map[1][2] = new Wall(c);        
	}
	
	public void init18(){
		Coord c1 = new Coord(2,1);
		Coord c2 = new Coord(3,1);
        map[1][2] = new Ground(c1); 
        map[1][3] = new Wall(c2); 
	}
	
}
