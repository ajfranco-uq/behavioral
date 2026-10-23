package pattern.observer.push.solution1.subject;

import pattern.observer.push.solution1.observer.Observer;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}