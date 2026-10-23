package pattern.observer.push.solution2;

import pattern.observer.push.solution2.observer.MobileApp;
import pattern.observer.push.solution2.observer.Observer;
import pattern.observer.push.solution2.subject.YouTubeChannel;
import pattern.observer.push.solution2.observer.Subscriber;

public class Main {

    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel("Java Tutorials");

        Observer john = new Subscriber("John");
        Observer mary = new Subscriber("Mary");
        Observer mobileApp = new MobileApp("YouTube Mobile App");

        channel.attach(john);
        channel.attach(mary);
        channel.attach(mobileApp);

        channel.publishVideo("Observer Design Pattern");

        System.out.println();

        channel.detach(mary);

        channel.publishVideo("Decorator Design Pattern");
    }
}