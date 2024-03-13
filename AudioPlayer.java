import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {

    private Clip clip;

    public AudioPlayer(String audioFilePath) {
        try {
            File audioFile = new File(audioFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to an audio file.");
            return;
        }

        AudioPlayer player = new AudioPlayer(args[0]);

        System.out.println("Playing the audio...");
        player.play();

        // This is just to keep the program running while audio plays. In a real application, you'd handle this differently.
        try {
            Thread.sleep(60000); // 1 minute. Adjust as necessary.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.stop();
    }
}
