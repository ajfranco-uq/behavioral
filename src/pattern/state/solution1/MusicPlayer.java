package pattern.state.solution1;

public class MusicPlayer {

    private MusicPlayerState state;

    public MusicPlayer() {
        this.state = new StoppedState();
    }

    public void setState(MusicPlayerState state) {
        this.state = state;
    }

    public void pressPlay() {
        state.pressPlay(this);
    }

    public void pressPause() {
        state.pressPause(this);
    }

    public void pressStop() {
        state.pressStop(this);
    }
}
