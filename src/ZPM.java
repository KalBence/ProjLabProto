import java.awt.Image;

//Eklell d�nten�nk , hogy a ZPMcount  modul hol t�roljuk el;
public class ZPM extends Useable {

public Image image;
	@Override
	public void redeem() {
		//A ZPM modul bev�lt�sa 
		ZPMCount++;
		System.out.println("A ZPM modul sikeresen elhelyez�d�tt");
		//todo: Random zpm lerak�sa
	}
   
}
