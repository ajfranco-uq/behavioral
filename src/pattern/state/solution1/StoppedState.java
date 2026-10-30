package pattern.state.solution1;

public class StoppedState implements MusicPlayerState {

    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Starting music...");
        player.setState(new PlayingState());
    }

    @Override
    public void pressPause(MusicPlayer player) {
        System.out.println("Cannot pause: music is stopped.");
    }

    @Override
    public void pressStop(MusicPlayer player) {
        System.out.println("Music is already stopped.");
    }
}
