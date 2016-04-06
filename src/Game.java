import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;





public class Game {
	public static void main(String[] args)  {
		String n;	
		Map map = new Map();
		ONeil o = null;
		
		System.out.println("Utasítások:");
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			try {
				while((n=br.readLine())!=null) {
					
					if(n.equals("LoadMap")){
					map.initmap();
					o = new ONeil(map,3);
					}
					// OMove<direction><number>
					else if(n.startsWith("OMove")){
						System.out.println(n.substring(6, n.length()-5));
						String direction=n.substring(6, n.length()-5);
						String  snumber=(n.substring(n.length()-3, n.length()-1));
						int num=0;
						num=Character.getNumericValue(snumber.charAt(0))*10;
						num+=Character.getNumericValue(snumber.charAt(1));
						System.out.println(num);
						if(!o.direction.equals(direction)){
							num--;
							if(direction.equals("Up")){	}
							if(direction.equals("Down")){		}
							if(direction.equals("Left")){		}
							if(direction.equals("Right")){	}
						}
						System.out.println(o.direction+" "+num);
						/*for(int i=0;i<num;i++)
							o.move();*/
						
					}
					else if(n.startsWith("OUse")){
						if(o.object!=null){
							o.dropDown();
						}
						else o.pickUp();
					}
				// Honnan tudjuk h b/Y
					else if(n.equals("OShootB")){
						o.shoot('b');
					}
					else if(n.equals("OShootY")){
						o.shoot('y');
						
					}
					else if(n.startsWith("JMove")){
						
					}
					else if(n.startsWith("JUse")){
						
					}
					else if(n.equals("JShootG")){
						
					}
					else if(n.equals("JShootR")){
						
					}
					else if(n.equals("ListMap")){
						map.getMap();
					}
					else if(n.equals("RMove")){
						
					}
					else if(n.equals("MissionDetails")){
						if(map!=null && o!=null){
						System.out.println("Collected ZPMs: "+map.getZPMcount());
						System.out.println("Remaining life: "+o.lives);
						}
						else System.out.println("Rosszcsont !! ELöbb töltsd be a pályát és kezd játszani.");
						
					}
				
				}
					
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	

