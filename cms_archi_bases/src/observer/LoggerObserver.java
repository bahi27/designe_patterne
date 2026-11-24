package observer;

import ensisa.Page;

/** Observateur notifié lorsqu'une page du site est ajoutée ou supprimée. */
public interface LoggerObserver {
    void update(String action, Page page);
}
