package proxy;
import ensisa.Page;
public abstract class  Logger implements Siteable{
		protected  Siteable proxyed ; 
		public Logger(Siteable proxyed) {
			this.proxyed =proxyed ; 
		}
		public void addPage(Page p ) {
			this.apply(p) ;
			
			this.proxyed.addPage(p) ;
		}
		public void removePage(Page p) {
			proxyed.removePage(p);
		}
		public void render(String name) {
			proxyed.render(name) ;
		}
		public abstract void apply(Page p) ; 
}
