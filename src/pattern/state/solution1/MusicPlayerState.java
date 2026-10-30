package pattern.state.solution1;

public interface MusicPlayerState {

    void pressPlay(MusicPlayer player);

    void pressPause(MusicPlayer player);

    void pressStop(MusicPlayer player);
}
