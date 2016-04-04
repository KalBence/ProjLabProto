import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//A p�lya oszt�lya
public class Map {
	private ONeil oneil;
	private int sizeX;
	private int sizeY;
	private int ZPMcount;
	public Tile[][] map = new Tile[11][11];
	
	public int getSizeX() {
		return sizeX;		
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public Map() {
		
	}
/*	
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
       sizeX=18;		//f�jlba l�v� m�trix m�ret�t�l f�gg majd, most fix 4
       sizeY=13;		//f�jlba l�v� m�trix m�ret�t�l f�gg majd, most fix 4
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
	*/
	public void initmap() throws IOException{
		int Y=0;
		String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
 String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
		BufferedReader br = new BufferedReader(new FileReader("Map2.csv"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	Y++;
		    	
		      String[]c=line.split(";");
		     for(int i=0;i<c.length;i++){
		    	if (c[i].equals("W")){
		    		map[i][Y]=new Wall(new Coord(Y,i));
		    	}
		    	else if (c[i].equals("G")){
		    		map[i][Y]=new Ground(new Coord(Y,i));
		    	}
		    	else if (c[i].equals("S")){
		    		map[i][Y]=new SpecialWall(new Coord(Y,i));
		    	}
		    	else if (c[i].equals("P")){
		    		map[i][Y]=new Pit(oneil,new Coord(Y,i));
		    	}
		    	else if (c[i].equals("D")){
		    	}
		    	else if (c[i].equals("SS")){
		    		map[i][Y]=new SpaceShip(new Coord(Y,i));
		    	}
		    	else if (c[i].contains("SC")){
		    		int Dx,Dy;
		    		Dx=Character.getNumericValue(c[i].charAt(2));
		    		Dy=Character.getNumericValue(c[i].charAt(3));
		    		//System.out.println(cx);
		    		map[Dx][Dy]=new Door(new Coord(Dx,Dy));
		    		map[i][Y]=new Scale(new Coord(Dx,Dy),new Coord(Y,i),this);
		    	}
		     }
		        line = br.readLine();
		        System.out.println(c[0]);
		    }
		    String everything = sb.toString();
		} finally {
		    br.close();
		}
	}
}
