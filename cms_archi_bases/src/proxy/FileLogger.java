package proxy;
import ensisa.Page;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
public class FileLogger extends Logger {
	public FileLogger(Siteable proxyed) {
		super(proxyed) ;
	}
	public void apply(Page p) {
		// to do 
		try {
			FileWriter log = new FileWriter("log.txt",true) ;
			log.write("[" +LocalDate.now()  +" "+ LocalTime.now()+"] Ajout de la Page: "+p.getTitle()+"\n") ;
			log.close();
		}catch(IOException e) {
			e.printStackTrace()	 ;	
		}
	

		
	}

}
