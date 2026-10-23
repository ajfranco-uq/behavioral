package pattern.observer.push.solution2.observer;

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