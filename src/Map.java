import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//A pálya osztálya
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
	//pálya felépítése
	//a végleges verzióba itt egy fájlból lesz kiolvasva a mátrix 
	//és ebbõl építi fel a pályát az itt látotthoz hasonló módon
	public void init(int[][] test) {
		System.out.println("Map: init metódus hívás");
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
       sizeX=18;		//fájlba lévõ mátrix méretétõl függ majd, most fix 4
       sizeY=13;		//fájlba lévõ mátrix méretétõl függ majd, most fix 4
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
       // System.out.println("Current dir:"+current);
		String currentDir = System.getProperty("user.dir");
       // System.out.println("Current dir using System:" +currentDir);
		BufferedReader br = new BufferedReader(new FileReader("Map2.csv"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		    	Y++;
		    	sizeY = Y +1 ;
		      String[]c=line.split(";");
		      sizeX= c.length+1;
		     for(int i=0;i<c.length;i++){
		    	if (c[i].equals("W")){
		    		map[Y][i]=new Wall(new Coord(i,Y));
		    	}
		    	else if (c[i].equals("G")){
		    		map[Y][i]=new Ground(new Coord(i,Y));
		    		//map[Y][i]=new Door(new Coord(i,Y));
		    	}
		    	else if (c[i].equals("S")){
		    		map[Y][i]=new SpecialWall(new Coord(i,Y));
		    	}
		    	else if (c[i].equals("P")){
		    		map[Y][i]=new Pit(oneil,new Coord(i,Y));
		    	}
		    	else if (c[i].equals("D")){
		    	}
		    	else if (c[i].equals("SS")){
		    		map[Y][i]=new SpaceShip(new Coord(i,Y));
		    	}
		    	else if (c[i].contains("SC")){
		    		int Dx,Dy;
		    		Dx=Character.getNumericValue(c[i].charAt(2)); //6
		    		Dy=Character.getNumericValue(c[i].charAt(3)); //10
		    		System.out.println(Dx+" : "+Dy);
		    		
		    		map[Y][i]=new Scale(new Coord(Dy,Dx),new Coord(i,Y),this);
		    		 map[6][10]=new Door(new Coord(10,6));  
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
	public void getMap(){
		System.out.println();
		for (int i=0;i<getSizeY();i++){
			for (int j=0;j<getSizeX();j++){
				if (map[i][j] instanceof Ground)
					System.out.print("G  ");
				else if (map[i][j] instanceof Wall)
					System.out.print("W  ");
				else if (map[i][j] instanceof SpecialWall)
					System.out.print("S  ");
				else if (map[i][j] instanceof Pit)
					System.out.print("P  ");
				else if (map[i][j] instanceof SpaceShip)
					System.out.print("SS ");
				else if (map[i][j] instanceof Door){
					System.out.print("D ");
					
				}
					
				else if (map[i][j] instanceof Scale)
					System.out.print("SC ");				
			}
			System.out.println();
		}

	}
	public int getZPMcount(){return ZPMcount;}
}
