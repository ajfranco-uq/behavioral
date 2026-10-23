package pattern.observer.pull.solution2;

import pattern.observer.pull.solution2.observer.Observer;
import pattern.observer.pull.solution2.observer.Subscriber;
import pattern.observer.pull.solution2.subject.YouTubeChannel;

public class Main {

    public static void main(String[] args) {

        YouTubeChannel channel =
            new YouTubeChannel("Java Tutorials");

        Observer john =
            new Subscriber("John");

        Observer mary =
            new Subscriber("Mary");

        channel.attach(john);
        channel.attach(mary);

        channel.publishVideo(
            "Observer Design Pattern"
        );

        System.out.println();

        channel.publishVideo(
            "Decorator Design Pattern"
        );
    }
}