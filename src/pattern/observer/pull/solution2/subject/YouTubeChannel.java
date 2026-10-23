package pattern.observer.pull.solution2.subject;

import pattern.observer.pull.solution2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {

    private final String name;
    private String latestVideo;
    private final List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String name) {
        this.name = name;
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
            observer.update(this);// referencia a sí mismo (this), de manera que cada observer pueda consultar sus datos.
        }
    }

    public void publishVideo(String title) {
        this.latestVideo = title;
        System.out.println(name + " published a new video.");
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public String getLatestVideo() {
        return latestVideo;
    }
}