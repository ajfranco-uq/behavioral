package pattern.state.solution1;

public class PausedState implements MusicPlayerState {

    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Resuming music...");
        player.setState(new PlayingState());
    }

    @Override
    public void pressPause(MusicPlayer player) {
        System.out.println("Music is already paused.");
    }

    @Override
    public void pressStop(MusicPlayer player) {
        System.out.println("Stopping music...");
        player.setState(new StoppedState());
    }
}
