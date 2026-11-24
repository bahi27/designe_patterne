package observer;

/** Sujet observé : gère l'inscription et la notification des observateurs. */
public interface SubjectObserved {
    void attach(LoggerObserver observer);
    void detach(LoggerObserver observer);
    void notifyObservers(String action, ensisa.Page page);
}
