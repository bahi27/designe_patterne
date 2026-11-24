package ensisa;

import observer.ConsoleLoggerObserver;
import observer.FileLoggerObserver;
// import observer.ApiLoggerObserver;

public class ObserverDemo {
    public static void main(String[] args) {
        Site site = new Site("Mon site");

        // On abonne les observateurs au site.
        site.attach(new ConsoleLoggerObserver());
        site.attach(new FileLoggerObserver("observer-log.txt"));

        // Pour activer la journalisation API, fournir une URL de webhook :
        // site.attach(new ApiLoggerObserver("https://exemple.com/webhook"));

        Page accueil = new Page("Accueil", "Bobo");
        site.addPage(accueil);
        site.removePage(accueil);
    }
}
