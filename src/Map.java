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
	public Tile[][] map = new Tile[6][5]; //vmi 4
	
	public int getSizeX() {
		return sizeX;		
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public Map() {
		
	}

	public void initmap() throws IOException{
		int Y=0;
		String current = new java.io.File( "." ).getCanonicalPath();
       // System.out.println("Current dir:"+current);
		String currentDir = System.getProperty("user.dir");
       // System.out.println("Current dir using System:" +currentDir);
		BufferedReader br = new BufferedReader(new FileReader("ProtoMap.csv"));
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
		    	
		    	}
		    	else if (c[i].equals("S")){
		    		map[Y][i]=new SpecialWall(new Coord(i,Y));
		    	}
		    	else if (c[i].equals("B")){
		    		map[Y][i]=new Ground(new Coord(i,Y));
		    		
		    	
		    	}
		    	else if (c[i].equals("Z")){
		    		map[Y][i]=new Ground(new Coord(i,Y));
		    	
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
		    		Dx=Character.getNumericValue(c[i].charAt(2)); 
		    		Dy=Character.getNumericValue(c[i].charAt(3));
		    		System.out.println(Dx+" : "+Dy);
		    		
		    		map[Y][i]=new Scale(new Coord(Dy,Dx),new Coord(i,Y),this);
		    		 map[Dx][Dy]=new Door(new Coord(Dy,Dx));  
		    	}
		     }
		        line = br.readLine();
		       
		    }
		    String everything = sb.toString();
		} finally {
			map[5][4]=new Wall(new Coord(4,5)); // 
		    br.close();
		}
		
	}
	public void getMap(){
		System.out.println();
		for (int i=0;i<getSizeY();i++){
			for (int j=0;j<getSizeX();j++){
				if (map[i][j] instanceof Ground)
					System.out.print("G  ");
				else if (map[i][j] instanceof SpecialWall)
					System.out.print("S  ");
				else if (map[i][j] instanceof Door){
					System.out.print("D ");}
				else if (map[i][j] instanceof Wall)
					System.out.print("W  ");
				
				else if (map[i][j] instanceof Pit)
					System.out.print("P  ");
				else if (map[i][j] instanceof SpaceShip)
					System.out.print("SS ");
				
					
				
					
				else if (map[i][j] instanceof Scale)
					System.out.print("SC ");				
			}
			System.out.println();
		}

	}
	public int getZPMcount(){return ZPMcount;}
}
