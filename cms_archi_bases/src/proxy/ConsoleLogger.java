package proxy;
import ensisa.Page; 
import java.time.LocalDate;
import java.time.LocalTime ; 
public class ConsoleLogger extends Logger {
	public ConsoleLogger(Siteable proxyed) {
		super(proxyed) ; 
	}
	
	public void apply(Page p) {
		// to do 
		System.out.println("[" +LocalDate.now()  +" "+ LocalTime.now()+"] Ajout de la Page: "+p.getTitle()) ; 
	}

}
