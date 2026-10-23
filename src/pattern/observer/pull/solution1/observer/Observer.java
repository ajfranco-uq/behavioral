package pattern.observer.pull.solution1.observer;

import pattern.observer.pull.solution1.subject.Product;

public interface Observer {

    void update(Product product);
}