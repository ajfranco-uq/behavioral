package pattern.observer.push.solution1.subject;

import pattern.observer.push.solution1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {

    private String name;
    private double price;
    private int stock;

    private final List<Observer> observers = new ArrayList<>();

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name, price, stock);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers();
    }

    public void setName(String name){
        this.name = name;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", observers=" + observers +
                '}';
    }
}