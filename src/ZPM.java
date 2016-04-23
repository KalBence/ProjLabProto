import java.awt.Image;

//Eklell döntenünk , hogy a ZPMcount  modul hol tároljuk el;
public class ZPM extends Useable {

public Image image;
	@Override
	public void redeem() {
		//A ZPM modul beváltása 
		ZPMCount++;
		System.out.println("A ZPM modul sikeresen elhelyezõdött");
		//todo: Random zpm lerakása
	}
   
}
