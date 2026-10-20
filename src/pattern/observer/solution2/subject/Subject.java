package pattern.observer.solution2.subject;

import pattern.observer.solution2.observer.Observer;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}