package pattern.observer.pull.solution2.observer;

import pattern.observer.pull.solution2.subject.YouTubeChannel;

public class Subscriber implements Observer {

    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(YouTubeChannel channel) {

        String videoTitle = channel.getLatestVideo();//El suscriptor recibe la notificación y consulta el canal para obtener el título

        System.out.println(name + " received an update from " + channel.getName());
        System.out.println(name + " is watching: " + videoTitle);
    }
}