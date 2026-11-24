package ensisa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import observer.LoggerObserver;
import observer.SubjectObserved;
import proxy.Siteable;

/**
 * Site du CMS.
 * Il conserve l'interface Siteable utilisée par le pattern Proxy
 * et implémente également SubjectObserved pour le pattern Observer.
 */
public class Site implements Siteable, SubjectObserved {
    private String title;
    private Map<String, Page> pages = new HashMap<>();
    private final Set<LoggerObserver> observers = new LinkedHashSet<>();

    public Site(String title) {
        this.title = title;
    }

    @Override
    public void attach(LoggerObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(LoggerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String action, Page page) {
        // Copie pour éviter une modification de la liste pendant la notification.
        for (LoggerObserver observer : Set.copyOf(observers)) {
            observer.update(action, page);
        }
    }

    @Override
    public void addPage(Page page) {
        pages.put(page.getTitle(), page);
        notifyObservers("Ajout de la page", page);
    }

    @Override
    public void removePage(Page page) {
        Page removed = pages.remove(page.getTitle());
        if (removed != null) {
            notifyObservers("Suppression de la page", removed);
        }
    }

    @Override
    public void render(String title) {
        Page page = pages.get(title);
        if (page == null) {
            System.out.println("Page introuvable : " + title);
            return;
        }
        System.out.println(page.toHTML());
    }
}
