package pattern.observer.push.solution2.subject;

import pattern.observer.push.solution2.observer.Observer;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}