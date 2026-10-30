package pattern.state.solution1;

public class Main {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.pressPlay();
        player.pressPause();
        player.pressPlay();
        player.pressStop();
        player.pressStop();
    }
}
