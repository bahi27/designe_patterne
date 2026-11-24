package ensisa;
import java.util.*;

import java.util.Map;

import proxy.Siteable;

public class Site  implements Siteable {
    private String title;
    private Map<String, Page> pages = new HashMap<>();

    public Site(String title){
        this.title = title;
    }

    public void addPage(Page page){
        this.pages.put(page.getTitle(), page);
    }

    public void removePage(Page page){
        this.pages.remove(page.getTitle());
    }

    public void render(String title){
        System.out.println(this.pages.get(title).toHTML());
    }

	
}
