package pattern.state.problem;

public class MusicPlayer {

    private String state = "STOPPED";

    public void pressPlay() {
        if (state.equals("STOPPED")) {
            state = "PLAYING";
            System.out.println("Starting music...");
        } else if (state.equals("PAUSED")) {
            state = "PLAYING";
            System.out.println("Resuming music...");
        } else if (state.equals("PLAYING")) {
            System.out.println("Music is already playing.");
        }
    }

    public void pressPause() {
        if (state.equals("PLAYING")) {
            state = "PAUSED";
            System.out.println("Pausing music...");
        } else {
            System.out.println("Cannot pause right now.");
        }
    }

    public void pressStop() {
        if (state.equals("PLAYING") || state.equals("PAUSED")) {
            state = "STOPPED";
            System.out.println("Stopping music...");
        } else {
            System.out.println("Music is already stopped.");
        }
    }
}
