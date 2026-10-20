package pattern.observer.solution2.observer;

import pattern.observer.solution2.observer.Observer;

public class MobileApp implements Observer {

    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(appName + " displayed notification: " + videoTitle);
    }
}