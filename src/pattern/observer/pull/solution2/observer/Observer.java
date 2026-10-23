package pattern.observer.pull.solution2.observer;

import pattern.observer.pull.solution2.subject.YouTubeChannel;

public interface Observer {

    void update(YouTubeChannel channel);
}