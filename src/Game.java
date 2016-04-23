import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;

public class Game {
	public static void main(String[] args)  {
		String n;	
		Map map = new Map();
		ONeil o = null;
		Jaffa j=null;
		WormHole wh=new WormHole();
		
		System.out.println("Utasítások:");
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			try {
				while((n=br.readLine())!=null) {
					
					if(n.equals("LM")){
					
					o = new ONeil(map,3);
					j= new Jaffa(map,3);
					map.initmap(o,j);
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
						if(!o.direction.toString().equals(direction)){
							num--;
							if(direction.equals("Up")){o.direction=ONeil.Directions.Up;	}
							if(direction.equals("Down")){	o.direction=ONeil.Directions.Down;	}
							if(direction.equals("Left")){	o.direction=ONeil.Directions.Left;	}
							if(direction.equals("Right")){o.direction=ONeil.Directions.Right;	}
						}

						System.out.println(o.direction+" "+num);

						for(int i=0;i<num;i++)
							o.move();
						
						System.out.println(o.direction+" "+o.getLoc().getX()+" "+o.getLoc().getY());
					}
					else if(n.startsWith("OUse")){
						if(o.object!=null){
							o.dropDown();
						}
						else o.pickUp();
					}
					
					else if(n.equals("OShootB")){
						o.shoot('b',wh);
					}
					else if(n.equals("OShootY")){
						o.shoot('y',wh);
						
					}
					else if(n.startsWith("JMove")){
						System.out.println(n.substring(6, n.length()-5));
						String direction=n.substring(6, n.length()-5);
						String  snumber=(n.substring(n.length()-3, n.length()-1));
						int num=0;
						num=Character.getNumericValue(snumber.charAt(0))*10;
						num+=Character.getNumericValue(snumber.charAt(1));
						System.out.println(num);
						if(!j.direction.equals(direction)){
							num--;
							if(direction.equals("Up")){j.direction=ONeil.Directions.Up;	}
							if(direction.equals("Down")){	j.direction=ONeil.Directions.Down;	}
							if(direction.equals("Left")){	j.direction=ONeil.Directions.Left;	}
							if(direction.equals("Right")){j.direction=ONeil.Directions.Right;	}
						}
						System.out.println(j.direction+" "+num);
						for(int i=0;i<num;i++)
							j.move();
					}
					else if(n.startsWith("JUse")){
						if(j.object!=null){
							j.dropDown();
						}
						else j.pickUp();
					}
					else if(n.equals("JShootG")){
						j.shoot('g',wh);
					}
					else if(n.equals("JShootR")){
						j.shoot('r',wh);
					}
					else if(n.equals("L")){
						map.getMap();
					}
					else if(n.equals("RMove")){
						
					}
					else if(n.equals("MissionDetails")){
						if(map!=null && o!=null){
						System.out.println("Collected ZPMs: "+new ZPM().getZPMcount());
						System.out.println("Remaining life: "+o.lives);
						//System.out.println("blue"+wh.getBlue().getX()+wh.getBlue().getY()+" Yellow "+wh.getYellow().getX()+wh.getYellow().getY());
						}
						else System.out.println("Rosszcsont !! ELöbb töltsd be a pályát és kezd játszani.");
						
					}
				
				}
					
				
			} catch (IOException e1) {
				System.out.println("Kiestünk a palyaról");
			}
		}
	}
	

