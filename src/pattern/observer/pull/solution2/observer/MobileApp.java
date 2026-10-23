package pattern.observer.pull.solution2.observer;

import pattern.observer.pull.solution2.subject.YouTubeChannel;

public class MobileApp implements Observer {

    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(YouTubeChannel channel) {

        String channelName = channel.getName();
        String videoTitle = channel.getLatestVideo();

        System.out.println(appName + " received an update from " + channelName);
        System.out.println("Mobile notification: New video - " + videoTitle);
    }
}