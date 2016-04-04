import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	public static void main(String[] args)  {
		String n;	
		Map map = new Map();
		ONeil o = null;
		
		//System.out.println("Tesztelni kivánt elem sorszáma:");
		/*try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			while((n=br.readLine())!=null) {
				switch(Integer.parseInt(n)) {
				case 0:
					System.out.println("--- Initialization ---");
					int[][] test = new int[][]{
									{0,0,0,0},
									{0,0,0,0},
									{0,0,0,0},
									{0,0,0,0}
									};	
					map.init(test);
					o = new ONeil(map,3);
					break;
				case 1:
					System.out.println("--- Exit ---");
					System.exit(0);
					break;
					
				case 2:
					System.out.println("----O'neill szakadékba lép---");
					map.init10();
					o = new ONeil(map,2);
					o.move();
					break;
				case 3:
					System.out.println("--- O’neill földre lép ---");
					map.init3();
					o = new ONeil(map,3);
					o.move();
					break;
				case 4:
					System.out.println("--- O’neill falra lép ---");	
					map.init4();
					o = new ONeil(map,3);
					o.move();
					break;
				case 5:
					System.out.println("--- O’neill portalra lép ---");	
					map.init5();
					o = new ONeil(map,3);
					o.move();
					break;
				case 6:
					System.out.println("---O'neill  mérlegre megy----");
					map.init6();
					o = new ONeil(map,1);
					o.move();
					break;
				case 7:
					System.out.println("----O'neill bele esik a szakadékba és meghal végleg---");
					map.init7();
					o = new ONeil(map,1);
					o.move();
					break;
				case 8:
					System.out.println("---O'neill  az ûrhajóra lép----");
					map.init8();
					o = new ONeil(map,1);
					o.move();
					break;
				case 9:
					System.out.println("---O'neill  ajtónak megy----");
					map.init9();
					o = new ONeil(map,1);
					o.move();
					break;
				case 10:
					System.out.println("----O'neill szakadékba lép---");
					map.init10();
					o = new ONeil(map,2);
					o.move();
					break;
				case 11:
					System.out.println("--- O’neill felvesz ---");	
					map.init11();
					o = new ONeil(map,3);
					o.pickUp();
					break;
				case 12:
					System.out.println("--- O’neill lerak egy ZPM-et ---");	
					map.init12();
					o = new ONeil(map,3);
					o.object = new ZPM();
					o.dropDown();
					break;
				case 13:
					System.out.println("--- O’neill lerak egy Dobozt ---");	
					map.init12();
					o = new ONeil(map,3);
					o.object = new Box();
					o.dropDown();
					break;
				case 14:
					System.out.println("---O'neill elhelyez egy ZPM modult az ûrhajón----");
					map.init14();
					o = new ONeil(map,1);
					o.object=new ZPM();
					o.dropDown();
					o.move();
					break;
				case 15:
					System.out.println("---  Ajtó nyitása ---");
					map.init15();
					break;
				case 16:
					System.out.println("---  O’neil specialwallra lõ. ---");
					map.init16();
					o = new ONeil(map,3);
					o.shoot();
					break;
				case 17:
					System.out.println("---  O’neil áthatolhatatlan tárgyra lõ. ---");
					map.init17();
					o = new ONeil(map,3);
					o.shoot();
					break;
				case 18:
					System.out.println("---  O’neil áthatolható tárgyra lõ. ---");	
					map.init18();
					o = new ONeil(map,3);
					o.shoot();
					break;
			   default:
				    System.out.println("Invalid input");
			        break;
			    }			
			}	
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		*/
		
	try {
		map.initmap();
		o = new ONeil(map,3);
		/*for(int i=0;i<18;i++){
		o.move();
		}*/
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println();
	for (int i=0;i<map.getSizeY();i++){
		for (int j=0;j<map.getSizeX();j++){
			if (map.map[i][j] instanceof Ground)
				System.out.print("G  ");
			else if (map.map[i][j] instanceof Wall)
				System.out.print("W  ");
			else if (map.map[i][j] instanceof SpecialWall)
				System.out.print("S  ");
			else if (map.map[i][j] instanceof Pit)
				System.out.print("P  ");
			else if (map.map[i][j] instanceof SpaceShip)
				System.out.print("SS ");
			else if (map.map[i][j] instanceof Door)
				System.out.print("D  ");
			else if (map.map[i][j] instanceof Scale)
				System.out.print("SC ");				
		}
		System.out.println();
	}
		
	}
}
