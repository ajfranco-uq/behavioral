package pattern.state.solution1;

public class PlayingState implements MusicPlayerState {

    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Music is already playing.");
    }

    @Override
    public void pressPause(MusicPlayer player) {
        System.out.println("Pausing music...");
        player.setState(new PausedState());
    }

    @Override
    public void pressStop(MusicPlayer player) {
        System.out.println("Stopping music...");
        player.setState(new StoppedState());
    }
}
